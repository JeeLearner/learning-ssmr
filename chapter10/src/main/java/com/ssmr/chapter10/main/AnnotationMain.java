package com.ssmr.chapter10.main;


import com.ssmr.chapter10.annotation.config.ApplicationConfig;
import com.ssmr.chapter10.annotation.config.AutowiredConfig;
import com.ssmr.chapter10.annotation.controller.RoleController;
import com.ssmr.chapter10.annotation.controller.RoleController2;
import com.ssmr.chapter10.annotation.pojo.PojoConfig;
import com.ssmr.chapter10.annotation.pojo.Role;
import com.ssmr.chapter10.annotation.service.RoleDataSourceService;
import com.ssmr.chapter10.annotation.service.RoleService;
import com.ssmr.chapter10.annotation.service.RoleService2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class AnnotationMain {
	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		test7();
		//test10();
	}

	/**
	 * 测试注解生成IOC容器
	 * 		1
	 */
	private static void test1() {
		ApplicationContext context = new AnnotationConfigApplicationContext(PojoConfig.class);
		Role role = context.getBean(Role.class);
		System.out.println(role.getId());
	}

	/**
	 * 测试basePackages 和basePackageClasses配置
	 */
	private static void test2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Role role = context.getBean(Role.class);
		RoleService roleService = context.getBean(RoleService.class);
		roleService.printRoleInfo(role);
		context.close();
	}

	/**
	 * 测试自动装配@Autowired
	 */
	private static void test3() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleService2 roleService = context.getBean(RoleService2.class);
		roleService.printRoleInfo();
		context.close();
	}

	/**
	 * 测试@Primary
	 */
	private static void test4() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Role role = context.getBean(Role.class);
		RoleService roleService = context.getBean("roleService3", RoleService.class);
		roleService.printRoleInfo(role);
		context.close();
	}

	/**
	 * 测试@Qualifier 通过名称查找
	 */
	private static void test5() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfig.class);
		RoleController roleController = context.getBean(RoleController.class);
		Role role = context.getBean(Role.class);
		roleController.printRole(role);
		context.close();
	}

	/**
	 * 装载带有参数的构造方法类  @Autowired/@Qualifier
	 */
	private static void test6() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfig.class);
		RoleController2 roleController = context.getBean(RoleController2.class);
		Role role = context.getBean(Role.class);
		roleController.printRole(role);
		context.close();
	}

	/**
	 * 测试@Bean装配Bean
	 */
	private static void test7() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DataSource dataSource = context.getBean(DataSource.class);
		try {
			System.out.println(dataSource.getConnection().getMetaData().getDatabaseProductName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试注解自定义Bean的初始化和销毁方法
	 */
	private static void test8() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		context.close();
	}

	/***
	 * 测试装配的混合使用
	 */
	private static void test9() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDataSourceService roleDataSourceService = context.getBean(RoleDataSourceService.class);
		Role role = roleDataSourceService.getRole(1L);
		System.out.println(role.getRoleName());
		context.close();
	}

	/**
	 * 测试加载属性文件
	 * 		jdbc:mysql://localhost:3306/chapter10
	 */
	private static void test10(){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		String url = ctx.getEnvironment().getProperty("jdbc.database.url");
		System.out.println(url);
	}

}
