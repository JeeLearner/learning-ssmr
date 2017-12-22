package com.ssmr.chapter05.dao;

import com.ssmr.chapter05.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    public Role getRole(Long id);

    public List<Role> findRoleByUserId(Long userId);
}
