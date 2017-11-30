package com.ssmr.chapter01.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    //反射生成对象
    public com.ssmr.chapter01.reflect.ReflectServiceImpl getInstance(){
        com.ssmr.chapter01.reflect.ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.ssmr.chapter01.reflect.ReflectServiceImpl").newInstance();
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            ex.printStackTrace();
        }
        return object;
    }

    //反射生成带有参数的构建方法
    public ReflectServiceImpl2 getInstance2() {
        ReflectServiceImpl2 object = null;
        try {
            object = (ReflectServiceImpl2) Class.forName("com.ssmr.chapter01.reflect.ReflectServiceImpl2")
                    .getConstructor(String.class).newInstance("张三");
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | NoSuchMethodException
                | SecurityException | IllegalArgumentException
                | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return object;

    }

    //获取和反射方法
    public Object reflectMethod(){
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello",String.class);
            returnObj = method.invoke(target,"张三");
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return returnObj;
    }

    //反射生成对象和反射调度方法
    public Object reflect(){
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.ssmr.chapter01.reflect.ReflectServiceImpl").newInstance();
            Method method = object.getClass().getMethod("sayHello", String.class);
            method.invoke(object,"张三");
        }catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
            ex.printStackTrace();
        }
        return object;
    }
}
