package com.ssmr.chapter15.service;

import java.util.List;

import com.ssmr.chapter15.pojo.Role;
import com.ssmr.chapter15.pojo.RoleParams;

public interface RoleService {
	
	public Role getRole(Long id);

	public List<Role> findRoles(RoleParams roleParams);

	public int deleteRoles(List<Long> idList);

	public int insertRoles(List<Role> roleList);

	public int insertRole(Role role);

}
