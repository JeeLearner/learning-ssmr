package com.ssmr.chapter11.xml.service.impl;


import com.ssmr.chapter11.game.pojo.Role;
import com.ssmr.chapter11.xml.service.RoleService;

public class RoleServiceImpl implements RoleService {

	@Override
	public void printRole(Role role) {
		System.out.print("id = " + role.getId()+",");
		System.out.print("role_name = " + role.getRoleName()+",");
		System.out.println("note = " + role.getNote());
	}
}