package com.ssmr.chapter01.reflect;

import java.lang.reflect.InvocationTargetException;

public class ReflectServiceImpl2 {
    private String name;

    public ReflectServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHello(String name){
        System.out.println("Hello "+name);
    }
}
