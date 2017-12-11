package com.ssmr.chapter15.controller;

import java.util.List;

import com.ssmr.chapter15.pojo.Role;
import com.ssmr.chapter15.pojo.RoleParams;
import com.ssmr.chapter15.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;



@Controller
@RequestMapping("/params")
public class ParamsController {

	/*
		接收普通参数
	 */
	@RequestMapping("/commonParams")
	public ModelAndView commonParams(String roleName, String note) {
	    System.out.println("roleName =>" + roleName);
	    System.out.println("note =>" + note);
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("index");
	    return mv;
	}

	/*
		接收对象
	 */
	@RequestMapping("/commonParamPojo")
	public ModelAndView commonParamPojo(RoleParams roleParams) {
		System.out.println("roleName =>" + roleParams.getRoleName());
		System.out.println("note =>" + roleParams.getNote());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	/*
		使用@RequestParam("role_name")指定映射HTTP参数名称
	 */
	@RequestMapping("/requestParam")
	public ModelAndView requestParam(@RequestParam("role_name") String roleName, String note) {
		System.out.println("roleName =>" + roleName);
		System.out.println("note =>" + note);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	//注入角色服务对象
	@Autowired
	RoleService roleService;

	/*
		使用URL传递参数
			{id}代表接收一个参数
			注解@PathVariable表示从URL的请求地址中获取参数
	 */
	@RequestMapping("/getRole/{id}")
	public ModelAndView pathVariable(@PathVariable("id") Long id)  {
		Role role = roleService.getRole(id);
		ModelAndView mv = new ModelAndView();
		//绑定数据模型
		mv.addObject(role);
		//设置为JSON视图
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}

	@RequestMapping("/findRoles")
	public ModelAndView findRoles(@RequestBody RoleParams roleParams) {
		List<Role> roleList = roleService.findRoles(roleParams);
		ModelAndView mv = new ModelAndView();
		//绑定模型
		mv.addObject(roleList);
		//设置为JSON视图
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}

	/*
		 var idList = [1, 2, 3];
		 data: JSON.stringify(idList),
	 */
	@RequestMapping("/deleteRoles")
	public ModelAndView deleteRoles(@RequestBody List<Long> idList) {
		ModelAndView mv = new ModelAndView();
		//删除角色
		int total = roleService.deleteRoles(idList);
		//绑定视图
		mv.addObject("total", total);
		//JSON视图
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}

	/*
		var roleList = [
			{roleName: 'role_name_1', note: 'note_1'},
			{roleName: 'role_name_2', note: 'note_2'},
			{roleName: 'role_name_3', note: 'note_3'}
         ];
         data: JSON.stringify(roleList),
	 */
	@RequestMapping("/addRoles")
	public ModelAndView addRoles(@RequestBody List<Role> roleList) {
		ModelAndView mv = new ModelAndView();
		//新增角色
		int total = roleService.insertRoles(roleList);
		//绑定视图
		mv.addObject("total", total);
		//JSON视图
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}

	/*
		序列化表单
		data: $("form").serialize(),
	 */
	@RequestMapping("/commonParamPojo2")
	public ModelAndView commonParamPojo2(String roleName, String note) {
		System.out.println("roleName =>" + roleName);
		System.out.println("note =>" + note);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	
}
