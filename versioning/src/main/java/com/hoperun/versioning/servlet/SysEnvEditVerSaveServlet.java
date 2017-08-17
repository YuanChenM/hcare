package com.hoperun.versioning.servlet;

import com.hoperun.core.bean.RsResponse;
import com.hoperun.core.consts.BusinessConst;
import com.hoperun.versioning.entity.ModuleVersionEntity;
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
@WebServlet(name = "SysEnvEditVerSaveServlet", urlPatterns = "/SysEnvEditVerSave")
public class SysEnvEditVerSaveServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(SysEnvEditVerSaveServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost");
        Long id = Long.parseLong(String.valueOf(request.getParameter("id")));
        String isSteady = String.valueOf(request.getParameter("isSteady"));
        SysEnvEditVerService sysEnvEditVerService = new SysEnvEditVerService();
        RsResponse<ModuleVersionEntity> rs = new RsResponse<>();
        try{
            int updateCount = sysEnvEditVerService.editSave(id, isSteady);
            if(updateCount == 1){
                rs.setStatus(BusinessConst.InterfaceStatus.SUCCESS);
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
