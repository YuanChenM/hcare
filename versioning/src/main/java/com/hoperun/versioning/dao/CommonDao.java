package com.hoperun.versioning.dao;

import com.hoperun.core.bean.BaseDao;
import com.hoperun.core.bean.CommonEntity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class CommonDao extends BaseDao {

    public CommonEntity findMaxId(String tableName,String tableField) throws SQLException {

        QueryRunner qr = new QueryRunner();
        String sql = "SELECT CASE WHEN MAX("+tableField+") IS NULL THEN 1 ELSE MAX("+tableField+")+1 END AS id FROM "+tableName+"";

        return qr.query(conn, sql, new BeanHandler<>(CommonEntity.class));
    }
}
