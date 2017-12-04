package com.ssmr.chapter11.aop.service;

import com.ssmr.chapter11.game.pojo.Role;

public interface RoleService {
	
	public void printRole(Role role);

	public void printRole(Role role, int sort);
}
