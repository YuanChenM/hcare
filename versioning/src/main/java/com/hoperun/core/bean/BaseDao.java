package com.hoperun.core.bean;

import com.hoperun.core.filter.ConnectionContext;

import java.sql.Connection;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class BaseDao {

    protected Connection conn;

    public BaseDao(){
        conn = ConnectionContext.getInstance().getConnection();
    }
}
