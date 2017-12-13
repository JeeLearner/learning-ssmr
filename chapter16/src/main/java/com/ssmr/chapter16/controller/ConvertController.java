package com.ssmr.chapter16.controller;

import java.util.Date;

import com.ssmr.chapter16.pojo.FormatPojo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/convert")
public class ConvertController {

	@RequestMapping("/format")
	public ModelAndView format(
			//日期格式化
			@RequestParam("date1") @DateTimeFormat(iso = ISO.DATE) Date date,
			//金额格式化
			@RequestParam("amount1") @NumberFormat(pattern = "#,###.##") Double amount
	) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("date", date); //Thu Jun 01 08:00:00 CST 2017
		mv.addObject("amount", amount); //123000.0
		return mv;
	}
	
	@RequestMapping("/formatPojo")
	public ModelAndView formatPojo(FormatPojo pojo) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("date", pojo.getDate1());//Thu Jun 01 08:00:00 CST 2017
		mv.addObject("amount", pojo.getAmount1()); //123000.00
		return mv;
	}
}