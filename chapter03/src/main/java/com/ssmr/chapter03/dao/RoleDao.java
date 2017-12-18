package com.ssmr.chapter03.dao;

import com.ssmr.chapter03.pojo.Role;

import java.util.List;

public interface RoleDao {

    public int insertRole(Role role);
    public int deleteRole(Long id);
    public int updateRole(Role role);
    public Role getRole(Long id);
    public List<Role> findRoles(String roleName);
}
