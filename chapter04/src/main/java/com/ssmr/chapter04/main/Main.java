package com.ssmr.chapter04.main;

import com.ssmr.chapter04.dao.RoleDao;
import com.ssmr.chapter04.dao.UserDao;
import com.ssmr.chapter04.pojo.Role;
import com.ssmr.chapter04.pojo.User;
import com.ssmr.chapter04.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class Main {

    public static void main(String[] args) {
        //testRoleMapper();
        //testTypeHandler();
        testObjectFactory();
    }

    public static void testRoleMapper(){
        Logger log = Logger.getLogger(Main.class);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
            Role role = roleDao.getRole(1L);
            log.info(role.getRoleName());
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    private static void testTypeHandler() {
        Logger log = Logger.getLogger(Main.class);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = userDao.getUser(1L);
            System.out.println(user.getSex().getName());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    private static void testObjectFactory() {
        Logger log = Logger.getLogger(Main.class);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = userDao.getUser(1L);
            System.out.println(user.getSex().getName());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
