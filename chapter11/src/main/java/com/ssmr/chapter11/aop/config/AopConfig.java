package com.ssmr.chapter11.aop.config;

import com.ssmr.chapter11.aop.aspect.RoleAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.ssmr.chapter11.aop")
public class AopConfig {

    //生成一个切面实例
    @Bean
    public RoleAspect getRoleAspect(){
        return new RoleAspect();
    }
}
