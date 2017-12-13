package com.ssmr.chapter16.config;

import com.ssmr.chapter16.converter.StringToRoleConverter;
import com.sun.tools.javac.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebConfig {
    //自定义转换器列表
    private List<Converter> myConverter = null;

    //依赖注入FormattingConversionServiceFactoryBean对象，它是一个自动初始化的对象
    @Autowired
    private FormattingConversionServiceFactoryBean fcsfb = null;

    @Bean(name = "myConverter")
    public List<Converter> initMyConverter() {
        if (myConverter == null) {
            myConverter = new ArrayList<Converter>();
        }
        //自定义的字符串和角色转换器
        Converter roleConverter = new StringToRoleConverter();
        myConverter.add(roleConverter);
        //往转换服务类注册转换器
        fcsfb.getObject().addConverter(roleConverter);
        return myConverter;
    }
}
