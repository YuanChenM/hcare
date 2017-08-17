package com.hoperun.versioning.servlet;

import com.hoperun.core.bean.RsResponse;
import com.hoperun.core.consts.BusinessConst;
import com.hoperun.core.consts.NumberConst;
import com.hoperun.versioning.entity.ModuleVersionEntity;
import com.hoperun.versioning.service.RuningVerHistoryService;
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
@WebServlet(name = "ModuleVerHistoryServlet", urlPatterns = "/ModuleVerHistory")
public class ModuleVerHistoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(ModuleVerHistoryServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost");
        Long sysEnvId = Long.parseLong(String.valueOf(request.getParameter("sysEnvId")));
        Long versionId = Long.parseLong(String.valueOf(request.getParameter("versionId")));
        RuningVerHistoryService runingVerHistoryService = new RuningVerHistoryService();
        try {
            List<ModuleVersionEntity> moduleVersionList = runingVerHistoryService.findHistoryModule(sysEnvId,versionId);
            RsResponse<List<ModuleVersionEntity>> rs = new RsResponse<>();
            if (moduleVersionList.size() != NumberConst.IntDef.INT_ZERO) {
                rs.setStatus(BusinessConst.InterfaceStatus.SUCCESS);
                rs.setResult(moduleVersionList);
            } else {
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
        this.doPost(request, response);
    }
}
