package com.hoperun.core.filter;

import com.hoperun.core.utils.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
@WebFilter(filterName="TransactionFilter",urlPatterns={"/*"})
public class TransactionFilter implements Filter {

    final static Logger logger = LoggerFactory.getLogger(TransactionFilter.class);

    public void init(FilterConfig config) throws ServletException {
        logger.info("TransactionFilter初始化......");
    }

    public void destroy() {
        logger.info("TransactionFilter销毁......");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        Connection connection = null;
        try {
            //1、获取数据库连接对象Connection
            connection = DbUtil.getConnection();
            //2、开启事务
            connection.setAutoCommit(false);
            //3、利用ThreadLocal把获取数据库连接对象Connection和当前线程绑定
            ConnectionContext.getInstance().bind(connection);
            //4、把请求转发给目标Servlet
            chain.doFilter(request, response);
            //5、提交事务
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //6、回滚事务
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            //req.setAttribute("errMsg", e.getMessage());
            //req.getRequestDispatcher("/error.jsp").forward(req, res);
            //出现异常之后跳转到错误页面
            res.sendRedirect(req.getContextPath()+"/error.jsp");
        }finally{
            //7、解除绑定
            ConnectionContext.getInstance().remove();
            //8、关闭数据库连接
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
