package com.ssmr.chapter14.dao;

import org.springframework.stereotype.Repository;

import com.ssmr.chapter14.pojo.Role;

@Repository
public interface RoleDao {
	
	public Role getRole(Long id);
}
