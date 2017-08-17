package com.hoperun.versioning.servlet;

import com.hoperun.core.bean.RsResponse;
import com.hoperun.core.bean.VersionSysEnv;
import com.hoperun.core.consts.BusinessConst;
import com.hoperun.core.utils.DateTimeUtil;
import com.hoperun.versioning.Job.AutoJobSetting;
import org.json.JSONObject;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by yuan_chen1 on 2016/5/10.
 */
@WebServlet(name = "AutoJobServlet", urlPatterns = "/AutoJob")
public class AutoJobServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(AutoJobServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost");
        RsResponse<List<VersionSysEnv>> rs = new RsResponse<>();
        if("start".equals(String.valueOf(request.getParameter("flag")))){
            Date startTime = DateTimeUtil.parseDate(String.valueOf(request.getParameter("startTime")),DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS);
            int executeInterval = Integer.parseInt(String.valueOf(request.getParameter("executeInterval")));
            int executeCount = Integer.parseInt(String.valueOf(request.getParameter("executeCount")));
            AutoJobSetting.jobStart(startTime,executeInterval,executeCount);
            rs.setStatus(BusinessConst.InterfaceStatus.SUCCESS);
        }else{
            try{
                AutoJobSetting.scheduler.shutdown();
                rs.setStatus(BusinessConst.InterfaceStatus.SUCCESS);
            }catch(SchedulerException e){
                e.printStackTrace();
            }
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
