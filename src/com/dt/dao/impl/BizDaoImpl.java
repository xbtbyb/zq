package com.dt.dao.impl;

import com.dt.dao.BizDao;
import com.dt.entity.Student;
import com.dt.util.UtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BizDaoImpl extends UtilsByDruid implements BizDao {
    @Override
    public List<Student> getStudentInfo() {
        List<Student> liststu=new ArrayList<>();

        try {
            QueryRunner qr= new QueryRunner();
            //返回集合(多行多列)
            //String sql="SELECT * FROM stu ";
            //String sql="SELECT id FROM stu ";
            //liststu= qr.query(getConnection(),sql,new BeanListHandler<>(Student.class));
            //返回对象(单行)
            //String sql="SELECT * FROM stu WHERE id=? ";
            //Student stu=qr.query(getConnection(),sql,new BeanHandler<>(Student.class),1);
            //返回对象(一个单元格)
            //String sql="SELECT name FROM stu WHERE id=? ";
            //Object obj=qr.query(getConnection(),sql,new ScalarHandler(),1);
            //System.out.println(obj);
            //返回改变后受影响的行数  affect影响  affected受影响
            //String sql="update stu set name =?  WHERE id=? ";
            //String sql="insert into stu values(null,"李小龙")";
            //String sql="delete from stu  WHERE id=?";
            //int affectedRow=qr.update(getConnection(),sql,"小白",2);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            UtilsByDruid.close(rs,pst,con);
        }
        return liststu;
    }







    //    @Override
//    public List<Student> getStudentInfo() {
//        List<Student> liststu=new ArrayList<>();
//
//        String sql="SELECT * FROM stu ";
//        try {
//            pst=getConnection().prepareStatement(sql);
//            rs=pst.executeQuery();
//            while (rs.next()){
//                Student stu=new Student();
//                stu.setId(rs.getInt(1));
//                stu.setName(rs.getString(2));
//                liststu.add(stu);
//            }
//            System.out.println(con.getClass());
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            UtilsByDruid.close(rs,pst,con);
//        }
//        return liststu;
//    }
}
