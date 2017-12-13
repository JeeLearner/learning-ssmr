package com.ssmr.chapter16.controller;

import com.ssmr.chapter16.pojo.Role;
import com.ssmr.chapter16.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/getRole")
    // 注解，使得Spring MVC把结果转化为JSON类型响应，进而找到转换器
    @ResponseBody
    public Role getRole(Long id) {
        Role role = roleService.getRole(id);
        return role;
    }

    @RequestMapping(value = "/updateRole")
    @ResponseBody
    public Map<String, Object> updateRole(Role role) {
        Map <String, Object> result = new HashMap<String, Object>();
        //更新角色
        boolean updateFlag = (roleService.updateRole(role) == 1);
        result.put("success", updateFlag);
        if (updateFlag) {
            result.put("msg", "更新成功");
        } else {
            result.put("msg", "更新失败");
        }
        return result;
    }

    //需要改变converter，这里没改.
    @RequestMapping(value = "/updateRoleList")
    @ResponseBody
    public Map<String, Object> updateRoleList(List<Role> roleList) {
        Map <String, Object> result = new HashMap<String, Object>();
        //更新角色
        boolean updateFlag = (roleService.updateRoleArr(roleList) > 1);
        result.put("success", updateFlag);
        if (updateFlag) {
            result.put("msg", "更新成功");
        } else {
            result.put("msg", "更新失败");
        }
        return result;
    }


    /**
     * 测试@ModelAttribute
     * http://localhost:8080/role/getRoleFromModelAttribute.do?id=1
     */
    /**
     * 在进入控制器方法前运行，先从数据库中查询角色，然后以键role保存角色对象到数据模型
     * @param id 角色编号
     * @return 角色
     */

    @ModelAttribute("role")
    public Role initRole(@RequestParam(value="id", required = false) Long id) {
        //判断id是否为空
        if (id == null || id < 1 ) {
            return null;
        }
        Role role = roleService.getRole(id);
        return role;
    }
    /**
     * @ModelAttribute注解从数据模型中取出数据，
     * @param role 从数据模型中取出的角色对象
     * @return 角色对象
     */
    @RequestMapping(value="getRoleFromModelAttribute")
    @ResponseBody
    public Role getRoleFromModelAttribute(@ModelAttribute("role") Role role) {
        return role;
    }


}