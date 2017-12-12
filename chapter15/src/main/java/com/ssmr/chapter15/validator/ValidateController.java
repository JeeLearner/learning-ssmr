package com.ssmr.chapter15.validator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/validate")
public class ValidateController{

    /*
        将验证器和控制器捆绑在一起
     */
    @InitBinder
    public void initBinder(DataBinder binder){
        //数据绑定器键入验证器
        binder.setValidator(new TransactionValidator());
    }

    @RequestMapping("/annotation")
    public ModelAndView annotationValidate(@Valid Transaction trans, Errors errors){
        //是否存在错误
        if(errors.hasErrors()){
            //获取错误信息
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError error : errorList) {
                System.err.println("fied :" + error.getField() + "\t" + "msg:" + error.getDefaultMessage());
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

}
