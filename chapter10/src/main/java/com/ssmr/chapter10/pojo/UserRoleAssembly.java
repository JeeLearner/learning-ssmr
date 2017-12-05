package com.ssmr.chapter10.pojo;

import com.ssmr.chapter10.pojo.Role;
import com.ssmr.chapter10.pojo.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserRoleAssembly {
	
	private Long id;
	private List<com.ssmr.chapter10.pojo.Role> list;
	private Map<com.ssmr.chapter10.pojo.Role, com.ssmr.chapter10.pojo.User> map;
	private Set<com.ssmr.chapter10.pojo.Role> set;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<com.ssmr.chapter10.pojo.Role> getList() {
		return list;
	}

	public void setList(List<com.ssmr.chapter10.pojo.Role> list) {
		this.list = list;
	}

	public Map<com.ssmr.chapter10.pojo.Role, com.ssmr.chapter10.pojo.User> getMap() {
		return map;
	}

	public void setMap(Map<com.ssmr.chapter10.pojo.Role, User> map) {
		this.map = map;
	}

	public Set<com.ssmr.chapter10.pojo.Role> getSet() {
		return set;
	}

	public void setSet(Set<Role> set) {
		this.set = set;
	}

}
