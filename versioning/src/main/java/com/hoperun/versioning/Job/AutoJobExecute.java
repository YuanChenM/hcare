package com.hoperun.versioning.Job;

import com.hoperun.core.filter.ConnectionContext;
import com.hoperun.core.utils.DbUtil;
import com.hoperun.versioning.servlet.RuningVerServlet;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by yuan_chen1 on 2016/5/12.
 */
public class AutoJobExecute implements Job {

    private final static Logger logger = LoggerFactory.getLogger(AutoJobExecute.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("RuningVersionJob " + new Date());
        getNewConnection();
    }

    public Connection getNewConnection(){
        Connection connection = null;
        try {
            //1、获取数据库连接对象Connection
            connection = DbUtil.getConnection();
            //2、开启事务
            connection.setAutoCommit(false);
            //3、利用ThreadLocal把获取数据库连接对象Connection和当前线程绑定
            ConnectionContext.getInstance().bind(connection);
            //操作DB
            RuningVerServlet runingVerServlet = new RuningVerServlet();
            runingVerServlet.findInterFaceUrl();
            //5、提交事务
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //6、回滚事务
            try {
                connection.rollback();
                ConnectionContext.getInstance().remove();
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
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
        return connection;
    }
}
