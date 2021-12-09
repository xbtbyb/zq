package com.zq.dao;

import com.zq.utils.JDBCUtilsByDruid;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ImplDao {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtilsByDruid.getDatesource());
        String sql="SELECT * FROM stu ";
        List<Map<String,Object>> list=template.queryForList(sql);
        for(Map<String,Object>  StringObjectMap : list){
            System.out.println(StringObjectMap) ;
        }
    }
}
