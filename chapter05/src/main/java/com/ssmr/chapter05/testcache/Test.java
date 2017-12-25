package com.ssmr.chapter05.testcache;

import com.ssmr.chapter05.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class Test {

    public static void main(String[] args) {
        //testOneLevelCache();
        testTwoLevelCache();
    }

    public static void testOneLevelCache() {
        SqlSession sqlSession = null;
        Logger logger = Logger.getLogger(Test.class);
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleDao2 roleDao2 = sqlSession.getMapper(RoleDao2.class);
            Role2 role = roleDao2.getRole(1L);
            logger.info("再获取一次POJO......");
            Role2 role2 = roleDao2.getRole(1L);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

public static void testTwoLevelCache() {
    SqlSession sqlSession = null;
    SqlSession sqlSession2 = null;
    Logger logger = Logger.getLogger(Test.class);
    try {
        sqlSession = SqlSessionFactoryUtil.openSqlSession();
        sqlSession2 = SqlSessionFactoryUtil.openSqlSession();
        RoleDao2 roleDao2 = sqlSession.getMapper(RoleDao2.class);
        Role2 role2 = roleDao2.getRole(1L);
        //需要提交，如果是一级缓存，MyBatis才会缓存对象到SqlSessionFactory层面
        sqlSession.commit();
        logger.info("不同sqlSession再获取一次POJO......");
        RoleDao2 roleDao22 = sqlSession2.getMapper(RoleDao2.class);
        Role2 role22 = roleDao22.getRole(1L);
        //需要提交，MyBatis才缓存对象到SQLSessionFactory
        sqlSession2.commit();
    } catch(Exception e) {
        logger.info(e.getMessage(), e);
    } finally {
        if (sqlSession != null) {
            sqlSession.close();
        }
        if (sqlSession2 != null) {
            sqlSession.close();
        }
    }
}
}
