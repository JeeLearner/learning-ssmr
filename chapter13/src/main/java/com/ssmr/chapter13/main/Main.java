package com.ssmr.chapter13.main;

import com.ssmr.chapter13.pojo.Role;
import com.ssmr.chapter13.service.RoleListService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.management.relation.RoleList;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        RoleListService roleListService = ctx.getBean(RoleListService.class);
        List<Role> roleList = new ArrayList<Role>();
        for (int i=1; i<=2; i++){
            Role role = new Role();
            role.setRoleName("role_name_" + i);
            role.setNote("note_" + i);
            roleList.add(role);
            Role role2 = new Role();
            role2.setRoleName("role_name_" + i);
            role2.setNote("note_" + i);
            roleList.add(role2);
        }
        int count = roleListService.insertRoleList(roleList);
        System.out.println(count);
    }
}
