package com.ssmr.chapter02.intercept;

import com.ssmr.chapter02.proxy.HelloWorld;
import com.ssmr.chapter02.proxy.HelloWorldImpl;

public class TestInterceptor {

    public static void main(String[] args) {
        //testInterceptor();
        testChain();
    }

    //测试拦截器
    public static void testInterceptor(){
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),"com.ssmr.chapter02.intercept.MyInterceptor");
        proxy.sayHelloWorld();
        //结果
        /*
        【拦截器3】的before方法
        【拦截器2】的before方法
        【拦截器1】的before方法
         Hello World
        【拦截器1】的after方法
        【拦截器2】的after方法
        【拦截器3】的after方法*/
    }

    //测试责任链模式上的多拦截器
    public static void testChain(){
        HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(
                new HelloWorldImpl(), "com.ssmr.chapter02.intercept.InterceptorImpl1");
        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(
                proxy1, "com.ssmr.chapter02.intercept.InterceptorImpl2");
        HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(
                proxy2, "com.ssmr.chapter02.intercept.InterceptorImpl3");
        proxy3.sayHelloWorld();
    }


}
