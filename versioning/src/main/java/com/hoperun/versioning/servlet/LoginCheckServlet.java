package com.hoperun.versioning.servlet;

import com.hoperun.core.bean.RsResponse;
import com.hoperun.core.consts.BusinessConst;
import com.hoperun.versioning.entity.UserEntity;
import com.hoperun.versioning.service.LoginCheckService;
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
@WebServlet(name = "LoginCheckServlet", urlPatterns = "/LoginCheck")
public class LoginCheckServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(LoginCheckServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost");
        String account = String.valueOf(request.getParameter("account"));
        String password = String.valueOf(request.getParameter("password"));
        LoginCheckService loginCheckService = new LoginCheckService();
        try{
            UserEntity userEntity = loginCheckService.loginCheck(account, password);
            RsResponse<UserEntity> rs = new RsResponse<>();
            if(null == userEntity){
                rs.setStatus(BusinessConst.InterfaceStatus.SUCCESS);
            }else{
                rs.setStatus(BusinessConst.InterfaceStatus.FAIL);
            }
            JSONObject resultJSON = new JSONObject(rs);
            PrintWriter out = response.getWriter();
            out.write(resultJSON.toString());
            out.flush();
            out.close();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doGet");
        this.doPost(request,response);

    }
}
