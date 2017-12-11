package com.ssmr.chapter15.dao;

import com.ssmr.chapter15.pojo.RoleParams;
import org.springframework.stereotype.Repository;

import com.ssmr.chapter15.pojo.Role;

import java.util.List;

@Repository
public interface RoleDao {
	
	public Role getRole(Long id);

	public List<Role> findRoles(RoleParams roleParams);

	public int deleteRole(Long id);

	public int insertRole(Role role);

}
