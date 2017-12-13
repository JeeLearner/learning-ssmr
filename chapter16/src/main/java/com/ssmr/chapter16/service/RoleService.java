package com.ssmr.chapter16.service;

import com.ssmr.chapter16.pojo.Role;

import java.util.List;

public interface RoleService {

    public Role getRole(Long id);

    public int updateRole(Role role);

    public int updateRoleArr(List<Role> roleList);

}
