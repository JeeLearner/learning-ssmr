package com.ssmr.chapter03.main;


import com.ssmr.chapter03.dao.RoleDao;
import com.ssmr.chapter03.dao.RoleDao_anno;
import com.ssmr.chapter03.pojo.Role;
import com.ssmr.chapter03.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class Main {

    public static void main(String[] args) {
        testRoleMapper();
        testRoleMapper_anno();
    }

    public static void testRoleMapper(){
        Logger log = Logger.getLogger(Main.class);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
            Role role = roleDao.getRole(1L);
            log.info(role.getRoleName());
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }

    public static void testRoleMapper_anno(){
        Logger log = Logger.getLogger(Main.class);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleDao_anno roleDao_anno = sqlSession.getMapper(RoleDao_anno.class);
            Role role = roleDao_anno.getRole(1L);
            log.info(role.getRoleName());
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
