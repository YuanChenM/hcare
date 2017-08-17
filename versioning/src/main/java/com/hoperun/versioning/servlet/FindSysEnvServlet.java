package com.hoperun.versioning.servlet;

import com.hoperun.core.bean.RsResponse;
import com.hoperun.core.consts.BusinessConst;
import com.hoperun.versioning.entity.SysEnvEntity;
import com.hoperun.versioning.service.AddSysEnvService;
import com.hoperun.versioning.service.FindSysEnvService;
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
import java.util.List;

/**
 * Created by yuan_chen1 on 2016/5/10.
 */
@WebServlet(name="FindSysEnvServlet",urlPatterns="/findSysEnv")
public class FindSysEnvServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(FindSysEnvServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost");

        FindSysEnvService findSysEnvService = new FindSysEnvService();
        //返回前台信息
        RsResponse<List<SysEnvEntity>> rs = new RsResponse<>();
        try{
            List<SysEnvEntity> sysEnvEntityList = findSysEnvService.find();
            if(null != sysEnvEntityList && sysEnvEntityList.size() > 0){
                rs.setStatus(BusinessConst.InterfaceStatus.SUCCESS);
                rs.setResult(sysEnvEntityList);
            }
        }catch(SQLException e){
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
