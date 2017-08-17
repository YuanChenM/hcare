package com.hoperun.core.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DbUtil
 *
 * @author yuan_chen
 * @version 1.0
 **/
public final class DbUtil {

    public static String driver = "com.mysql.jdbc.Driver";
    public static String username="root";
    public static String password="root";
    public static String url="jdbc:mysql://10.20.16.152:3306/versioning";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
