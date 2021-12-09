package com.zq.test;


import com.zq.dao.StudentDAO;
import com.zq.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestDAO {
@Test
    public void testTestDAO(){
        StudentDAO studentDAO = new StudentDAO();
       List<Student> st= studentDAO.queryMulti("SELECT * FROM stu WHERE id=?",Student.class,1);
        for (Student stu:st) {
            System.out.println(stu.getId()+stu.getName());
        }
    }

}
