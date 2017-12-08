package com.ssmr.chapter14.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

//注解@Controller表示它是一个控制器
@Controller("myController")
//表明当请求的URI在/my下的时候才有该控制器响应
@RequestMapping("/my")
public class MyController {

    private Long id;

    //表明URI是/index的时候该方法才请求
    @RequestMapping("/index.do")
    public ModelAndView  index() {
        //模型和视图
        ModelAndView mv = new ModelAndView();
        //视图逻辑名称为index
        mv.setViewName("index");
        //返回模型和视图
        return mv;
    }

   /*
        获取http请求的参数
    */
    @RequestMapping("/index1.do")
    public ModelAndView  index1(@RequestParam(value = "id", required = false, defaultValue = "1") Long id) {
        System.out.println(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    /*
        获取Session参数
     */
    @RequestMapping("/index2.do")
    public ModelAndView  index2(@SessionAttribute("userName") String userName) {
        System.out.println(userName);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
