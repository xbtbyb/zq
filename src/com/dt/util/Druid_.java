package com.dt.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class Druid_ {
    @Test
    public void test(){

        try {
            //1.加入 Druid jar包
            //2.加入 配置文件 druid.properties ,将该文件拷贝到项目的src目录
            //3.创建Properti对象，读取配置
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\druid.properties"));
            //4.创建一个指定参数的数据库连接池
            DataSource dataSource =
                    DruidDataSourceFactory.createDataSource(properties);
            //得到连接
            Connection connection = dataSource.getConnection();
            //System.out.println("连接成功！");
            connection.close();


 /*           long start=System.currentTimeMillis();
            for (int i=0;i<500000;i++) {
                Connection connection = dataSource.getConnection();
                //System.out.println("连接成功！");
                connection.close();
            }
            long end=System.currentTimeMillis();
            System.out.println("德鲁伊  连接500000次耗时："+(end-start));
*/


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
