package com.ssmr.chapter11.xml.main;

import com.ssmr.chapter11.game.pojo.Role;
import com.ssmr.chapter11.xml.service.RoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAopMain {

    /**
     before ......
     around before ......
     id = 1,role_name = role_name_1,note = note_1
     around after ......
     after-returning ......
     after ......
     */
    //注意：这个结果和通过@AspectJ方式是不同的,这个更符合aop理念。
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cfg-aop.xml");
        RoleService roleService = ctx.getBean(RoleService.class);
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        roleService.printRole(role);
    }
}
