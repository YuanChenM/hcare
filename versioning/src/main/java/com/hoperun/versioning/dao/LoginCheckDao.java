package com.hoperun.versioning.dao;

import com.hoperun.core.bean.BaseDao;
import com.hoperun.versioning.entity.UserEntity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class LoginCheckDao extends BaseDao {

    public UserEntity loginCheck(String account,String password) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from user where userAccount=? and userPwd=?";
        Object params[] = {account,password};
        return qr.query(conn, sql, new BeanHandler<>(UserEntity.class), params);
    }
}
