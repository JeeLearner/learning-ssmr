package com.ssmr.chapter10.annotation.controller;

import com.ssmr.chapter10.annotation.pojo.Role;
import com.ssmr.chapter10.annotation.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleController2 {

    private RoleService roleService = null;

    /**
        带参数的构造方法
     */
    public RoleController2(@Autowired RoleService roleService){
        this.roleService = roleService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService( RoleService roleService) {
        this.roleService = roleService;
    }

    public void printRole(Role role) {
        roleService.printRoleInfo(role);
    }
}
