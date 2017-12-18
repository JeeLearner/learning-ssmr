package com.ssmr.chapter04.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SqlSessionFactoryUtil {

    private final static Class<SqlSessionFactoryUtil> LOCK = SqlSessionFactoryUtil.class;

    private static SqlSessionFactory sqlSessionFactory = null;
    //构造函数私有化
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
                InputStream in = Resources.getResourceAsStream("jdbc.properties");
                Properties props = new Properties();
                props.load(in);
                String username = props.getProperty("database.username");
                String password = props.getProperty("batabase.password");
                //解密用户名和密码，并在属性中重置
                props.put("database.username", CodeUtils.decode(username));
                props.put("database.password", CodeUtils.decode(password));
                inputStream = Resources.getResourceAsStream(resource);
                // 使用程序传递的方式覆盖原有的properties属性参数
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, props);
            } catch (IOException e){
                e.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }

}
