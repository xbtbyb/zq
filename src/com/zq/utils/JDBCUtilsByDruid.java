package com.zq.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtilsByDruid {

    private static DataSource ds;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\druid.properties"));
            ds= DruidDataSourceFactory.createDataSource(properties);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //获取连接池的方法
    public static DataSource getDatesource(){
        return ds;
    }

    //编写getConnection 方法
    public static Connection getConnection() throws SQLException {

        return ds.getConnection();
    }

    //关闭连接，指把数据库连接池技术 close不是真的断掉连接，是把Connection对象放回连接池
    public static void close(ResultSet rs, PreparedStatement pst,Connection con){
        try {
            if (rs!=null){
                rs.close();
            }
            if(pst!=null){
                pst.close();
            }
            if (con!=null){
               con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
