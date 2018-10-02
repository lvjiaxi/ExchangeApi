package com.iduoyu.uilts;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * 数据库链接池
 */
public class JavaUiltsData {
    public static ComboPooledDataSource dataSource;//优先
    static { //执行一次
        dataSource = new ComboPooledDataSource("c3p0");
    }

    public static Connection getConnect() throws SQLException {
        return dataSource.getConnection();
    }
    public static void closeConn(Connection conn){
        try {
            if(conn!=null && conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }}



    }
