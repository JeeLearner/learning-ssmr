package com.ssmr.chapter05.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {

    //类线程锁(单例模式)
    private static final Class<SqlSessionFactoryUtil> LOCK = SqlSessionFactoryUtil.class;

    private static SqlSessionFactory sqlSessionFactory;

    //私有化构造函数
    private SqlSessionFactoryUtil(){

    }

    public static SqlSessionFactory getSqlSessionFactory(){
        synchronized (LOCK){
            if (sqlSessionFactory != null) {
                return sqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }

    public static SqlSession openSqlSession(){
        if (sqlSessionFactory == null) {
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }

}

