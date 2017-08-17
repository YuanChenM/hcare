package com.hoperun.versioning.servlet;

import com.alibaba.fastjson.TypeReference;
import com.hoperun.core.bean.*;
import com.hoperun.core.consts.BusinessConst;
import com.hoperun.core.consts.NumberConst;
import com.hoperun.core.exception.BusinessException;
import com.hoperun.core.utils.DateTimeUtil;
import com.hoperun.core.utils.RestClientUtil;
import com.hoperun.versioning.entity.ModuleVersionEntity;
import com.hoperun.versioning.entity.RuningVersionEntity;
import com.hoperun.versioning.entity.SysEnvEntity;
import com.hoperun.versioning.service.CommonService;
import com.hoperun.versioning.service.RuningVersionService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuan_chen1 on 2016/5/10.
 */
@WebServlet(name="RuningVerServlet",urlPatterns="/RuningVer")
public class RuningVerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(RuningVerServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost");

        findInterFaceUrl();

        List<VersionSysEnv> resultVersionList = getRuningVersion();
        RsResponse<List<VersionSysEnv>> rs = new RsResponse<>();
        if(resultVersionList.size() != NumberConst.IntDef.INT_ZERO){
            rs.setStatus(BusinessConst.InterfaceStatus.SUCCESS);
            rs.setResult(resultVersionList);
        }else{
            rs.setStatus(BusinessConst.InterfaceStatus.FAIL);
        }
        JSONObject resultJSON = new JSONObject(rs);
        PrintWriter out = response.getWriter();
        out.write(resultJSON.toString());
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doGet");
        this.doPost(request, response);
    }

    /**
     * 获取所有的接口路径
     */
    public void findInterFaceUrl(){
        //逻辑处理类
        RuningVersionService runingVersionService = new RuningVersionService();
        try{
            List<SysEnvModule> sysEnvList = runingVersionService.findInterFaceUrlList();
            findAllVersion(sysEnvList);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * 根据接口List获取所有环境下所有模块的版本信息
     * @param sysEnvList
     * @return
     */
    public void findAllVersion(List<SysEnvModule> sysEnvList){
        //获取所有版本信息
        List<ModuleVersion> versionSysEnvList = new ArrayList<>();
        for (int i = 0; i < sysEnvList.size(); i++) {
            String url = sysEnvList.get(i).getSysEnvIpAddr() + sysEnvList.get(i).getInterfaceURL();
            RsResponse<ModuleVersion> moduleVersion = RestClientUtil.post(url, new HashMap<String, String>(),new TypeReference<RsResponse<ModuleVersion>>(){});
            //取接口获取值
            ModuleVersion versionResult = moduleVersion.getResult();
            //如果获取值不为空则插入DB
            if(null != versionResult){
                //环境
                versionResult.setSysEnvId(sysEnvList.get(i).getSysEnvId());
                versionResult.setSysEnvName(sysEnvList.get(i).getSysEnvName());
                //模块
                versionResult.setModuleId(sysEnvList.get(i).getModuleId());
                versionResult.setModuleName(sysEnvList.get(i).getModuleName());
                versionResult.setModuleShort(sysEnvList.get(i).getModuleShort());
                //发布者和发布时间
                versionResult.setIsRuning("1");
                versionResult.setPublisher("admin");
                versionResult.setPublishTime(DateTimeUtil.parseDate(versionResult.getBuildTime(),DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS));
                versionSysEnvList.add(versionResult);
            }
        }
        checkSysEnvVersion(versionSysEnvList);
    }

    /**
     * 检查环境版本是否是最新的并更新DB
     * @param versionSysEnvList
     */
    public void checkSysEnvVersion(List<ModuleVersion> versionSysEnvList){
        //逻辑处理类
        RuningVersionService runingVersionService = new RuningVersionService();
        CommonService commonService = new CommonService();
        try{
            //正在运行的环境版本
            List<RuningVersionEntity> runingVersionList = runingVersionService.findRunVer();

            if(runingVersionList != null && runingVersionList.size() > 0){
                //设置环境表最新版本
                for (int i = 0; i < runingVersionList.size(); i++) {
                    for (int j = 0; j < versionSysEnvList.size(); j++) {
                        if(String.valueOf(runingVersionList.get(i).getSysEnvId()).equals(String.valueOf(versionSysEnvList.get(j).getSysEnvId()))){
                            if(Integer.parseInt(runingVersionList.get(i).getSvnVersion()) < Integer.parseInt(versionSysEnvList.get(j).getSvnVersion())){
                                runingVersionList.get(i).setSvnVersion(versionSysEnvList.get(j).getSvnVersion());
                                runingVersionList.get(i).setPublishTime(versionSysEnvList.get(j).getPublishTime());
                                break;
                            }
                        }
                    }
                    //获取当前环境版本在DB中是否存在
                    RuningVersionEntity runVersion = runingVersionService.findSysEnvByVersion(runingVersionList.get(i).getSysEnvId(), runingVersionList.get(i).getSvnVersion());
                    if(null == runVersion){
                        CommonEntity maxId = commonService.findMaxId("runing_version","id");
                        runingVersionList.get(i).setId(maxId.getId());
                        runingVersionList.get(i).setIsSteady("0");
                        //更新环境表数据设置环境版本为不在运行版本
                        runingVersionService.updateSysEnv(runingVersionList.get(i).getSysEnvId());
                        //插入环境表数据
                        runingVersionService.addSysEnv(runingVersionList.get(i));
                        //更新模块表该环境下的所有模块不在运行
                        runingVersionService.updateModuleVer(runingVersionList.get(i).getSysEnvId());
                        //批量插入模块表各模块版本信息
                        for (int j = 0; j < versionSysEnvList.size(); j++) {
                            if(runingVersionList.get(i).getSysEnvId() == versionSysEnvList.get(j).getSysEnvId()){
                                CommonEntity moduleMaxId = commonService.findMaxId("module_version","id");
                                versionSysEnvList.get(j).setId(moduleMaxId.getId());
                                versionSysEnvList.get(j).setVersionId(maxId.getId());
                                //新增模块版本
                                runingVersionService.addModuleVersion(versionSysEnvList.get(j));
                            }
                        }
                    }
                }
            }else{
                List<SysEnvEntity> sysEnvList = runingVersionService.findSysEnvList();
                for (int i = 0; i < sysEnvList.size(); i++) {
                    CommonEntity maxId = commonService.findMaxId("runing_version","id");
                    RuningVersionEntity runingVersionEntity = new RuningVersionEntity();
                    runingVersionEntity.setSvnVersion("0");
                    for (int j = 0; j < versionSysEnvList.size(); j++) {
                        if(sysEnvList.get(i).getSysEnvId() == versionSysEnvList.get(j).getSysEnvId()){
                            runingVersionEntity.setId(maxId.getId());
                            runingVersionEntity.setSysEnvId(versionSysEnvList.get(j).getSysEnvId());
                            runingVersionEntity.setSysEnvName(versionSysEnvList.get(j).getSysEnvName());
                            runingVersionEntity.setProjectVersion(versionSysEnvList.get(j).getProjectVersion());
                            if(Integer.parseInt(versionSysEnvList.get(j).getSvnVersion()) > Integer.parseInt(runingVersionEntity.getSvnVersion())){
                                runingVersionEntity.setSvnVersion(versionSysEnvList.get(j).getSvnVersion());
                            }
                            runingVersionEntity.setIsSteady("0");
                            runingVersionEntity.setIsRuning("1");
                            runingVersionEntity.setPublishTime(versionSysEnvList.get(j).getPublishTime());
                            runingVersionEntity.setPublisher(versionSysEnvList.get(j).getPublisher());
                            //新增模块版本
                            CommonEntity moduleMaxId = commonService.findMaxId("module_version","id");
                            versionSysEnvList.get(j).setId(moduleMaxId.getId());
                            versionSysEnvList.get(j).setVersionId(maxId.getId());
                            //新增模块版本
                            runingVersionService.addModuleVersion(versionSysEnvList.get(j));
                        }
                    }
                    //插入环境表数据
                    runingVersionService.addSysEnv(runingVersionEntity);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取正在运行的环境和环境下的模块版本
     * 获取是否存在历史版本
     * @return
     */
    public List<VersionSysEnv> getRuningVersion(){
        //逻辑处理类
        RuningVersionService runingVersionService = new RuningVersionService();
        List<VersionSysEnv>  versionSysEnvList = new ArrayList<>();
        try{
            //正在运行的环境版本
            List<RuningVersionEntity> runingVersionList = runingVersionService.findRunVer();
            //获取正在运行的系统环境和各模块版本
            if(runingVersionList.size() > 0 && runingVersionList != null){
                for (int i = 0; i < runingVersionList.size(); i++) {
                    List<ModuleVersionEntity> moduleVersionList = new ArrayList<>();
                    moduleVersionList = runingVersionService.findModule(runingVersionList.get(i).getSysEnvId());
                    CommonEntity commonEntity = runingVersionService.historyVerCount(runingVersionList.get(i).getSysEnvId());
                    VersionSysEnv versionSysEnv = new VersionSysEnv();
                    versionSysEnv.setId(runingVersionList.get(i).getId());
                    versionSysEnv.setSysEnvId(runingVersionList.get(i).getSysEnvId());
                    versionSysEnv.setSysEnvName(runingVersionList.get(i).getSysEnvName());
                    versionSysEnv.setProjectVersion(runingVersionList.get(i).getProjectVersion());
                    versionSysEnv.setSvnVersion(runingVersionList.get(i).getSvnVersion());
                    versionSysEnv.setPublishTime(runingVersionList.get(i).getPublishTime());
                    versionSysEnv.setPublisher(runingVersionList.get(i).getPublisher());
                    versionSysEnv.setIsSteady(runingVersionList.get(i).getIsSteady());
                    versionSysEnv.setIsRuning(runingVersionList.get(i).getIsRuning());
                    versionSysEnv.setHistoryCount(commonEntity.getHistoryCount());
                    versionSysEnv.setModuleVersionList(moduleVersionList);
                    versionSysEnvList.add(versionSysEnv);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return versionSysEnvList;
    }
}
