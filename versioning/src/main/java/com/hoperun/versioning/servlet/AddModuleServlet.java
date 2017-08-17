package com.hoperun.versioning.servlet;

import com.hoperun.core.bean.CommonEntity;
import com.hoperun.core.bean.RsResponse;
import com.hoperun.core.consts.BusinessConst;
import com.hoperun.versioning.entity.ModuleEntity;
import com.hoperun.versioning.entity.SysEnvEntity;
import com.hoperun.versioning.service.AddModuleService;
import com.hoperun.versioning.service.AddSysEnvService;
import com.hoperun.versioning.service.CommonService;
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

/**
 * Created by yuan_chen1 on 2016/5/10.
 */
@WebServlet(name="AddModuleServlet",urlPatterns="/AddModule")
public class AddModuleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(AddModuleServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost");
        //模块ID
        Long moduleId = Long.parseLong(String.valueOf(request.getParameter("moduleId")));
        //所在系统环境ID
        Long sysEnvId = Long.parseLong(String.valueOf(request.getParameter("sysEnvId")));
        //所在系统环境名称
        String sysEnvName = String.valueOf(request.getParameter("sysEnvName"));
        //模块名称
        String moduleName = String.valueOf(request.getParameter("moduleName"));
        //模块英文简称
        String moduleShort = String.valueOf(request.getParameter("moduleShort"));
        //接口ID
        String interfaceId = String.valueOf(request.getParameter("interfaceId"));
        //接口访问路径
        String interfaceURL = String.valueOf(request.getParameter("interfaceURL"));
        ModuleEntity moduleEntity = new ModuleEntity();
        moduleEntity.setSysEnvId(sysEnvId);
        moduleEntity.setSysEnvName(sysEnvName);
        moduleEntity.setModuleId(moduleId);
        moduleEntity.setModuleName(moduleName);
        moduleEntity.setModuleShort(moduleShort);
        moduleEntity.setInterfaceId(interfaceId);
        moduleEntity.setInterfaceURL(interfaceURL);

        //返回前台信息
        RsResponse<String> rs = new RsResponse<>();
        AddModuleService moduleService = new AddModuleService();
        CommonService commonService = new CommonService();
        try{
            ModuleEntity checkAdd = moduleService.find(moduleId);
            if(null != checkAdd){
                rs.setStatus(BusinessConst.InterfaceStatus.FAIL);
            }else{
                CommonEntity commonEntity = commonService.findMaxId("module","id");
                moduleEntity.setId(commonEntity.getId());
                moduleService.add(moduleEntity);
                rs.setStatus(BusinessConst.InterfaceStatus.SUCCESS);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
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
}
