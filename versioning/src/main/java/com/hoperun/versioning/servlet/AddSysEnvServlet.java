package com.hoperun.versioning.servlet;

import com.hoperun.core.bean.RsResponse;
import com.hoperun.core.consts.BusinessConst;
import com.hoperun.versioning.entity.SysEnvEntity;
import com.hoperun.versioning.service.AddSysEnvService;
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
@WebServlet(name="AddSysEnvServlet",urlPatterns="/AddSysEnv")
public class AddSysEnvServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(AddSysEnvServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost");
        //环境ID
        Long sysEnvId = Long.parseLong(String.valueOf(request.getParameter("sysEnvId")));
        //环境名称
        String sysEnvName = String.valueOf(request.getParameter("sysEnvName"));
        //环境IP
        String sysEnvIpAddr = String.valueOf(request.getParameter("sysEnvIpAddr"));
        //环境WAR包存储路径
        String sysEnvURL = String.valueOf(request.getParameter("sysEnvURL"));
        SysEnvEntity sysEnvEntity = new SysEnvEntity();
        sysEnvEntity.setSysEnvId(sysEnvId);
        sysEnvEntity.setSysEnvName(sysEnvName);
        sysEnvEntity.setSysEnvIpAddr(sysEnvIpAddr);
        sysEnvEntity.setSysEnvURL(sysEnvURL);

        //返回前台信息
        RsResponse<String> rs = new RsResponse<>();
        AddSysEnvService sysEnvService = new AddSysEnvService();
        try{
            SysEnvEntity checkAdd = sysEnvService.find(sysEnvId);
            if(null != checkAdd){
                rs.setStatus(BusinessConst.InterfaceStatus.FAIL);
            }else{
                sysEnvService.add(sysEnvEntity);
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
