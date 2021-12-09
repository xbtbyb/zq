package com.zq.dao;


import com.zq.domain.Student;
import com.zq.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class BasicDAO<T> {

   private QueryRunner qr= new QueryRunner();

   public int updata(String sql,Object... parameters){
       Connection con=null;
       try {
           con=JDBCUtilsByDruid.getConnection();
           int updata=qr.update(con,sql,parameters);
           return updata;
       }catch (Exception e){
           throw new RuntimeException(e);//编译异常----》运行异常，抛出
       }finally {
           JDBCUtilsByDruid.close(null,null,con);
       }
   }

   public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters){
       Connection con=null;
       try {
           con=JDBCUtilsByDruid.getConnection();
           return  qr.query(con,sql,new BeanListHandler<T>(clazz),parameters);

       }catch (Exception e){
           throw new RuntimeException(e);//编译异常----》运行异常，抛出
       }finally {
           JDBCUtilsByDruid.close(null,null,con);
       }
   }

   public T querySingle(String sql,Class<T> clazz,Object... parameters){
       Connection con=null;
       try {
           con=JDBCUtilsByDruid.getConnection();
           return  qr.query(con,sql,new BeanHandler<T>(clazz),parameters);

       }catch (Exception e){
           throw new RuntimeException(e);//编译异常----》运行异常，抛出
       }finally {
           JDBCUtilsByDruid.close(null,null,con);
       }
   }

   public Object queryScalar(String sql,Object... parameters){
       Connection con=null;
       try {
           con=JDBCUtilsByDruid.getConnection();
           return  qr.query(con,sql,new ScalarHandler(),parameters);

       }catch (Exception e){
           throw new RuntimeException(e);//编译异常----》运行异常，抛出
       }finally {
           JDBCUtilsByDruid.close(null,null,con);
       }
   }
}
