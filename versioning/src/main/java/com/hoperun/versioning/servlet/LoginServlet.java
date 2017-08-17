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
@WebServlet(name = "LoginServlet", urlPatterns = "/HomePage")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost");
        request.getRequestDispatcher("/jsp/HomePage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doGet");
        this.doPost(request,response);

    }
}
