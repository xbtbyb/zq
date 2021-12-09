package com.dt.demo;

import com.dt.dao.impl.BizDaoImpl;
import com.dt.entity.Student;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        BizDaoImpl bizDao = new BizDaoImpl();
        List<Student> stu = bizDao.getStudentInfo();
        for (Student s1:stu ) {
            System.out.println("id:"+s1.getId()+"    姓名："+s1.getName());
            System.out.println(111111);
        }

    }
}
