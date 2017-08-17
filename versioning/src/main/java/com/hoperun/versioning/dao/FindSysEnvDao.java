package com.hoperun.versioning.dao;

import com.hoperun.core.bean.BaseDao;
import com.hoperun.versioning.entity.SysEnvEntity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class FindSysEnvDao extends BaseDao {

    public List<SysEnvEntity> find() throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sys_env WHERE delFlg = 0";
        return qr.query(conn,sql,new BeanListHandler<>(SysEnvEntity.class));
    }
}
