package com.hoperun.versioning.dao;

import com.hoperun.core.bean.BaseDao;
import com.hoperun.versioning.entity.RuningVersionEntity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class SysEnvEditVerDao extends BaseDao {

    //根据版本ID获取模块版本信息
    public RuningVersionEntity findSysEnvVer(Long id) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "select * from runing_version where id = ? and delFlg = 0";
        Object params[] = {id};
        return qr.query(conn,sql,new BeanHandler<>(RuningVersionEntity.class),params);
    }

    //保存编辑
    public int editSave(Long id,String isSteady) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "update runing_version set isSteady = ? where id = ? and delFlg = 0";
        Object params[] = {isSteady,id};
        return qr.update(conn,sql,params);
    }
}
