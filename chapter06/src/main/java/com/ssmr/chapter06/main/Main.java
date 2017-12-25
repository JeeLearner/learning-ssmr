package com.ssmr.chapter06.main;

import com.ssmr.chapter06.mapper.RoleMapper;
import com.ssmr.chapter06.pojo.Role;
import com.ssmr.chapter06.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        Logger log = Logger.getLogger(Main.class);
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        RoleMapper roleDao = sqlSession.getMapper(RoleMapper.class);
        Role role = new Role();
        role.setRoleName("");
        role.setNote("note");
       /* List<String> idList = new ArrayList<String>();
        idList.add("1");
        idList.add("22");*/
        List<Role> roles = roleDao.findRoles7(role);
        System.out.println(roles.get(0).getRoleName());
        System.out.println(roles.size());
    }
}
