package com.dt.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class UtilsByDruid {
    protected Connection con=null;
    protected PreparedStatement pst=null;
    protected ResultSet rs=null;
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

    //编写getConnection 方法
    public Connection getConnection() throws SQLException {
        con=ds.getConnection();
        return con;
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
