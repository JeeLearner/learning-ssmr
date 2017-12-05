package com.ssmr.chapter09.main;

import com.ssmr.chapter09.pojo.JuiceMaker;
import com.ssmr.chapter09.pojo.JuiceMaker2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        testIoc();
    }

    /**
     【DisposableBeanImpl】对象disposableBean开始实例化
     【DisposableBeanImpl】对象disposableBean实例化完成
     【Source】对象source开始实例化
     【Source】对象source实例化完成
     【JuiceMaker2】调用BeanNameAware接口的setBeanName方法
     【JuiceMaker2】调用BeanFactoryAware接口的setBeanFactory方法
     【JuiceMaker2】调用ApplicationContextAware接口的setApplicationContext方法
     【JuiceMaker2】对象juiceMaker2开始实例化
     【JuiceMaker2】调用InitializingBean接口的afterPropertiesSet方法
     【JuiceMaker2】执行自定义初始化方法
     【JuiceMaker2】对象juiceMaker2实例化完成
     这是一杯由贡茶饮品店，提供的大杯少糖橙汁
     十二月 04, 2017 3:56:12 下午 org.springframework.context.support.ClassPathXmlApplicationContext doClose
     信息: Closing org.springframework.context.support.ClassPathXmlApplicationContext@27fa135a: startup date [Mon Dec 04 15:56:12 CST 2017]; root of context hierarchy
     【JuiceMaker2】执行自定义销毁方法
     调用接口DisposableBean的destroy方法
     */
    public static void testIoc(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cfg.xml");
        JuiceMaker2 juiceMaker2 = (JuiceMaker2) ctx.getBean("juiceMaker2");
        System.out.println(juiceMaker2.makeJuice());
        ctx.close();
    }

    public static void testCommon() {
        JuiceMaker juiceMaker = new JuiceMaker();
        juiceMaker.setWater("矿泉水");
        juiceMaker.setFruit("橙子");
        juiceMaker.setSugar("少糖");
        System.out.println(juiceMaker.makeJuice());
    }
}
