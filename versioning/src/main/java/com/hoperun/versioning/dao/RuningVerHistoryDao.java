package com.hoperun.versioning.dao;

import com.hoperun.core.bean.BaseDao;
import com.hoperun.versioning.entity.ModuleVersionEntity;
import com.hoperun.versioning.entity.RuningVersionEntity;
import com.mysql.jdbc.StringUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class RuningVerHistoryDao extends BaseDao {

    //获取当前运行的环境版本
    public List<RuningVersionEntity> findRunVerHistory(Long sysEnvId) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "select * from runing_version where delFlg = 0 and isRuning = 0 and sysEnvId = ? order by svnVersion desc";
        Object params[] = {sysEnvId};
        return qr.query(conn,sql,new BeanListHandler<>(RuningVersionEntity.class),params);
    }
    //获取所有的环境版本
    public List<RuningVersionEntity> findRunVerHistory() throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "select * from runing_version where delFlg = 0 and isRuning = 0 order by svnVersion desc";
        return qr.query(conn,sql,new BeanListHandler<>(RuningVersionEntity.class));
    }
    //获取该环境下的模块历史版本
    public List<ModuleVersionEntity> findHistoryModule(Long sysEnvId,Long versionId) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "select * from module_version where delFlg = 0 and isRuning = 0 and sysEnvId = ? and versionId = ?";
        Object params[] = {sysEnvId,versionId};
        return qr.query(conn,sql,new BeanListHandler<>(ModuleVersionEntity.class),params);
    }
    //根据查询条件获取历史运行版本
    public List<RuningVersionEntity> searchRunVerHistory(String sysEnvName,String svnVersion,String isSteady,String isRuning)throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "select * from runing_version where ";
        List<String> param = new ArrayList<>();

        if(!StringUtils.isNullOrEmpty(sysEnvName)){
            sql = sql + "sysEnvName = ? and ";
            param.add(sysEnvName);
        }
        if(!StringUtils.isNullOrEmpty(svnVersion)){
            sql = sql + "svnVersion = ? and ";
            param.add(svnVersion);
        }
        sql = sql + "isSteady = ? and isRuning = ? and delFlg = 0 order by svnVersion desc";

        param.add(isSteady);
        param.add(isRuning);

        Object params[] = param.toArray();

        return qr.query(conn,sql,new BeanListHandler<>(RuningVersionEntity.class),params);
    }
}
