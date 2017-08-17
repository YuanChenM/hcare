package com.hoperun.versioning.servlet;

import com.hoperun.core.bean.RsResponse;
import com.hoperun.core.consts.BusinessConst;
import com.hoperun.versioning.entity.ModuleVersionEntity;
import com.hoperun.versioning.entity.RuningVersionEntity;
import com.hoperun.versioning.service.SysEnvEditVerService;
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
@WebServlet(name = "SysEnvEditVerServlet", urlPatterns = "/SysEnvEditVer")
public class SysEnvEditVerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(SysEnvEditVerServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost");
        Long id = Long.parseLong(String.valueOf(request.getParameter("id")));
        SysEnvEditVerService sysEnvEditVerService = new SysEnvEditVerService();
        RsResponse<RuningVersionEntity> rs = new RsResponse<>();
        try{
            RuningVersionEntity runingVersionEntity = sysEnvEditVerService.findSysEnvVer(id);
            if(null != runingVersionEntity){
                rs.setStatus(BusinessConst.InterfaceStatus.SUCCESS);
                rs.setResult(runingVersionEntity);
            }else{
                rs.setStatus(BusinessConst.InterfaceStatus.FAIL);
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
        this.doPost(request,response);
    }
}
