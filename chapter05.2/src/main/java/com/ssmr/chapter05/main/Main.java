package com.ssmr.chapter05.main;

import com.ssmr.chapter05.dao.EmployeeDao;
import com.ssmr.chapter05.dao.EmployeeTaskDao;
import com.ssmr.chapter05.pojo.Employee;
import com.ssmr.chapter05.pojo.EmployeeTask;
import com.ssmr.chapter05.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class Main {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        SqlSession sqlSession = null;
        try {
            Logger log = Logger.getLogger(Main.class);
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = employeeDao.getEmployee(1L);
            log.info(employee.getBirthday().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

    public static void test1(){
        SqlSession sqlSession = null;
        try {
            Logger log = Logger.getLogger(Main.class);
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            EmployeeTaskDao employeeTaskDao = sqlSession.getMapper(EmployeeTaskDao.class);
            EmployeeTask task = employeeTaskDao.getEmployeeTaskByEmpId(1L);
            log.info(task.getTask().getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
