package com.ssmr.chapter15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {

    /*
        使用HttpServletRequest作为方法参数的时候容易造成API入侵
     */
    @RequestMapping("/upload")
    public ModelAndView upload(HttpServletRequest request){
        //进行转换
        MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
        //获得请求上传的文件
        MultipartFile file = mhsr.getFile("file");
        //设置视图为JSON视图
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        //获取原始文件名
        String fileName = file.getOriginalFilename();
        //目标文件
        File dest = new File(fileName);
        try {
            // 保存文件
            file.transferTo(dest);
            // 保存成功
            mv.addObject("success", true);
            mv.addObject("msg", "上传文件成功");
        } catch (IllegalStateException | IOException e) {
            // 保存失败
            mv.addObject("success", false);
            mv.addObject("msg", "上传文件失败");
            e.printStackTrace();
        }
        return mv;
    }

    // 使用MultipartFile
    @RequestMapping("/uploadMultipartFile")
    public ModelAndView uploadMultipartFile(MultipartFile file) {
        // 定义JSON视图
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        // 获取原始文件名
        String fileName = file.getOriginalFilename();
        file.getContentType();
        // 目标文件
        File dest = new File(fileName);
        try {
            // 保存文件
            file.transferTo(dest);
            mv.addObject("success", true);
            mv.addObject("msg", "上传文件成功");
        } catch (IllegalStateException | IOException e) {
            mv.addObject("success", false);
            mv.addObject("msg", "上传文件失败");
            e.printStackTrace();
        }
        return mv;
    }

    // 使用Part
    @RequestMapping(value="/uploadPart", method= RequestMethod.POST)
    public ModelAndView uploadPart(Part file) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        // 获取原始文件名
        String fileName = file.getSubmittedFileName();
        File dest = new File(fileName);
        try {
            // 保存文件
            file.write("e:/mvc/" + fileName);
            mv.addObject("success", true);
            mv.addObject("msg", "上传文件成功");
        } catch (IllegalStateException | IOException e) {
            mv.addObject("success", false);
            mv.addObject("msg", "上传文件失败");
            e.printStackTrace();
        }
        return mv;
    }
}
