package com.ssmr.chapter11.multi.config;

import com.ssmr.chapter11.multi.aspect.Aspect1;
import com.ssmr.chapter11.multi.aspect.Aspect2;
import com.ssmr.chapter11.multi.aspect.Aspect3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.ssmr.chapter11.multi")
public class MultiConfig {
    @Bean
    public Aspect1 getAspect1(){
        return new Aspect1();
    }

    @Bean
    public Aspect2 getAspect2(){
        return new Aspect2();
    }

    @Bean
    public Aspect3 getAspect3(){
        return new Aspect3();
    }
}
