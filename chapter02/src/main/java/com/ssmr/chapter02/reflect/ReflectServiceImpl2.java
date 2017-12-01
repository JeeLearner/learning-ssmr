package com.ssmr.chapter02.reflect;

public class ReflectServiceImpl2 {
    private String name;

    public ReflectServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHello(String name){
        System.out.println("Hello "+name);
    }
}
