package com.ssmr.chapter05.main;

import com.ssmr.chapter05.dao.RoleDao;
import com.ssmr.chapter05.dao.UserDao;
import com.ssmr.chapter05.pojo.Role;
import com.ssmr.chapter05.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

import static org.apache.xmlbeans.impl.store.Public2.test;

public class Main {

    public static void main(String[] args) {
        testRowBounds();
    }

    public static void testRowBounds(){
        SqlSession sqlSession = null;
        try {
            Logger log = Logger.getLogger(Main.class);
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
            Role role = roleDao.getRole(1L);
            role.getUserList();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.getUser(1L);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
