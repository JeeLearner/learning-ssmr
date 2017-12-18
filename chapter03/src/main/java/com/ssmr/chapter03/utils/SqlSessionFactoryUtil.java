package com.ssmr.chapter03.utils;

import com.ssmr.chapter03.dao.RoleDao;
import com.ssmr.chapter03.pojo.Role;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {

    //类线程锁(单例模式)
    private final static Class<SqlSessionFactoryUtil> LOCK = SqlSessionFactoryUtil.class;

    private static SqlSessionFactory sqlSessionFactory = null;

    //私有化构造函数
    private SqlSessionFactoryUtil(){

    }

    public static SqlSessionFactory getSqlSessionFactory(){
        synchronized (LOCK){
            if (sqlSessionFactory != null){
                return sqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e){
                e.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }

    /**
     * 使用代码创建SqlSessionFactory
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory_cfg(){
        synchronized (LOCK) {
            PooledDataSource dataSource = new PooledDataSource();
            dataSource.setDriver("com.mysql.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            dataSource.setUrl("jdbc:mysql://localhost:3306/test-ssmr");
            dataSource.setDefaultAutoCommit(false);
            TransactionFactory transactionFactory = new JdbcTransactionFactory();
            Environment environment = new Environment("development", transactionFactory, dataSource);
            Configuration configuration = new Configuration(environment);
            configuration.getTypeAliasRegistry().registerAlias("role", Role.class);

            configuration.addMapper(RoleDao.class);
            //用SqlSessionFactoryBuilder创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            return sqlSessionFactory;
        }
    }

    /**
     * 创建SqlSession对象
     * @return
     */
    public static SqlSession openSqlSession(){
        if(sqlSessionFactory == null){
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
