package com.hoperun.core.filter;

import java.sql.Connection;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class ConnectionContext {

    private ConnectionContext(){
    }

    private static ConnectionContext connectionContext = new ConnectionContext();

    public static ConnectionContext getInstance(){
        return connectionContext;
    }

    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    public void bind(Connection connection){
        connectionThreadLocal.set(connection);
    }

    public Connection getConnection(){
        return connectionThreadLocal.get();
    }

    public void remove(){
        connectionThreadLocal.remove();
    }
}
