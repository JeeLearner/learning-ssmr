package com.ssmr.chapter16.config;

import com.ssmr.chapter16.converter.StringToRoleConverter;
import com.sun.tools.javac.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    /*
        创建ResourceBundleMessageSource实例
     */
    /*@Bean(name = "messageSource")
    public MessageSource initMessageSource() {
        ResourceBundleMessageSource msgSrc = new ResourceBundleMessageSource();
        msgSrc.setDefaultEncoding("UTF-8");
        msgSrc.setBasename("msg");
        return msgSrc;
    }*/

    /*
        创建ReloadableResourceBundleMessageSource实例
     */
    @Bean(name="messageSource")
    public MessageSource initMessageSource() {
        ReloadableResourceBundleMessageSource msgSrc =
                new ReloadableResourceBundleMessageSource();
        msgSrc.setDefaultEncoding("UTF-8");
        msgSrc.setBasename("classpath:msg");
        //缓存3 600秒,相当于1小时，然后重新刷新
        msgSrc.setCacheSeconds(3600);
        //缓存3 600×1 000毫秒，相当于1小时，然后重新刷新
        //msgSrc.setCacheMillis(3600*1000);
        return msgSrc;
    }

    /*
        创建CookieLocaleResolver对象
     */
	@Bean(name="localeResolver")
	public LocaleResolver initCookieLocaleResolver() {
		CookieLocaleResolver clr = new CookieLocaleResolver();
		//cookie名称
		clr.setCookieName("lang");
		//cookie超时秒数
		clr.setCookieMaxAge(1800);
		//默认使用简体中文
		clr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		return clr;
	}

    /*
           创建SessionLocaleResolver对象
    */
    @Bean(name="localeResolver")
    public LocaleResolver initSessionLocaleResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        //默认使用简体中文
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return slr;
    }
}
