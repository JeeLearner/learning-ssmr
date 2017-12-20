package com.ssmr.chapter04.dao;

import com.ssmr.chapter04.pojo.Role;

import java.util.List;

public interface RoleDao {

    public Role getRole(Long id);
    public List<Role> findRoles(String roleName);
    public List<Role> findRoles2(String note);
}
