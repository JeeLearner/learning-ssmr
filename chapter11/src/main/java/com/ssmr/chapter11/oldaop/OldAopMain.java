package com.ssmr.chapter11.oldaop;

import com.ssmr.chapter11.game.pojo.Role;
import com.ssmr.chapter11.game.service.RoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 经典Spring Aop实现，现在几乎被废弃了
 */
public class OldAopMain {

	/**
	 前置通知！！
	 {id =1, roleName=role_name, note=note}
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-cfg-aop-old.xml");
		Role role = new Role();
		role.setId(1L);
		role.setRoleName("role_name");
		role.setNote("note");
		RoleService roleService = (RoleService) ctx.getBean("roleService");
		roleService.printRole(role);
	}
}
