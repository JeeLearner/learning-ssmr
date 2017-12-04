package com.ssmr.chapter11.aop.aspect;

import com.ssmr.chapter11.aop.verifier.RoleVerifier;
import com.ssmr.chapter11.aop.verifier.impl.RoleVerifierImpl;
import com.ssmr.chapter11.game.pojo.Role;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 定义切面
 */
@Aspect
public class RoleAspect {

    //加入RoleVerifier到切面中
    /*
        value表示对那个类进行增强
        defaultImpl代表默认的实现类
     */
    @DeclareParents(value = "com.ssmr.chapter11.aop.service.impl.RoleServiceImpl+", defaultImpl = RoleVerifierImpl.class)
    public RoleVerifier roleVerifier;

    //引入切点
    @Pointcut("execution(* com.ssmr.chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void print(){
    }

    //@Before("execution(* com.ssmr.chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
    //@Before("execution(* com.ssmr.chapter11.*.*.*.*.printRole(..))"  && within(com.ssmr.chapter11.aop.service.impl.*)")
    @Before("print()")
    public void before(){
        System.out.println("before...");
    }

    //@After("execution(* com.ssmr.chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
    @After("print()")
    public void after() {
        System.out.println("after ....");
    }

    //@AfterReturning("execution(* com.ssmr.chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
    @AfterReturning("print()")
    public void afterReturning() {
        System.out.println("afterReturning ....");
    }

    //@AfterThrowing("execution(* com.ssmr.chapter11.aop.service.impl.RoleServiceImpl.printRole(..))")
    @AfterThrowing("print()")
    public void afterThrowing() {
        System.out.println("afterThrowing ....");
    }

    @Around("print()")
    public void around(ProceedingJoinPoint jp){
        System.out.println("around before ....");
        try {
            jp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("around after ....");
    }

    //给通知传递参数
    @Before("execution(* com.ssmr.chapter11.aop.service.impl.RoleServiceImpl.printRole(..)) " + "&& args(role, sort)")
    public void before(Role role, int sort) {
        System.out.println("before(给通知传参) ....");
    }
}
