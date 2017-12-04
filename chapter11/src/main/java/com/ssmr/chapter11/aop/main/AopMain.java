package com.ssmr.chapter11.aop.main;

import com.ssmr.chapter11.aop.config.AopConfig;
import com.ssmr.chapter11.aop.service.RoleService;
import com.ssmr.chapter11.aop.verifier.RoleVerifier;
import com.ssmr.chapter11.game.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        //testAnnotation();
        //testXml();
        testIntroduction();
    }

    /**
     around before ....
     before...
     {id =1, roleName=role_name_1, note=note_1}
     around after ....
     after ....
     afterReturning ......
     */
    public static void testAnnotation(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        RoleService roleService = ctx.getBean(RoleService.class);
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        roleService.printRole(role);
        //System.out.println("##############");
        //role = null;
        //roleService.printRole(role);
        //给通知传参
        roleService.printRole(role, 1);
    }

    /**
     around before ....
     before...
     {id =1, roleName=role_name_1, note=note_1}
     around after ....
     after ....
     afterReturning ....
     */
    public static void testXml(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cfg-aop-test.xml");
        RoleService roleService = ctx.getBean(RoleService.class);
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        roleService.printRole(role);
    }

    //引入
    public static void testIntroduction(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        RoleService roleService = ctx.getBean(RoleService.class);
        RoleVerifier roleVerifier = (RoleVerifier) roleService;
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        if (roleVerifier.verify(role)){
            roleService.printRole(role);
        }
    }
}
