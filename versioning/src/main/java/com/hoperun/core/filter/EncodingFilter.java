package com.hoperun.core.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * Created by yuan_chen1 on 2016/5/10.
 */
@WebFilter(filterName="EncodingFilter",urlPatterns="/*")
public class EncodingFilter implements Filter {
    final static Logger logger = LoggerFactory.getLogger(EncodingFilter.class);

    public void init(FilterConfig fConfig) throws ServletException {
        logger.info("EncodingFilter初始化......");
    }

    public void destroy() {
        logger.info("EncodingFilter销毁......");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
}
