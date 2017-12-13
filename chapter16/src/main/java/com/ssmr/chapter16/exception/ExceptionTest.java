package com.ssmr.chapter16.exception;

import com.ssmr.chapter16.pojo.Role;
import com.ssmr.chapter16.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class ExceptionTest {

    @Autowired
    private RoleService roleService;

    @RequestMapping("notFound")
    @ResponseBody
    public Role notFound(Long id) {
        Role role = roleService.getRole(id);
        //找不到角色信息抛出RoleException
        if (role == null) {
            throw new RoleException();
        }
        return role;
    }

    //当前控制器发生RoleException异常时，如果和配置的异常相匹配就进入该方法
    @ExceptionHandler(RoleException.class)
    public String HandleRoleException(RoleException e) {
        //返回指定的页面，避免不友好
        return "exception";
    }
}