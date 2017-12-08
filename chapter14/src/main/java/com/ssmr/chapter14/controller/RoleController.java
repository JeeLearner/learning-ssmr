package com.ssmr.chapter14.controller;

import com.ssmr.chapter14.pojo.Role;
import com.ssmr.chapter14.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/getRole.do", method = RequestMethod.GET)
    public ModelAndView getRole(@RequestParam(value = "id", required = false, defaultValue = "1") Long id){
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("roleDetails");
        //给数据模型添加一个角色对象
        mv.addObject("role", role);
        return mv;
    }

    // 获取角色
    @RequestMapping(value = "/getRole2.do", method = RequestMethod.GET)
    public ModelAndView getRole2(@RequestParam(value = "id", required = false, defaultValue = "1") Long id) {
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role", role);
        // 指定视图类型 JSON
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

}
