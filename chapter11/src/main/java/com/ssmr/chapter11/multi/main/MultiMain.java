package com.ssmr.chapter11.multi.main;

import com.ssmr.chapter11.multi.bean.MultiBean;
import com.ssmr.chapter11.multi.config.MultiConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 多切面是无序的，想要排序可以：
 *      1.Aspect切面类加上@Order(1)
 *      2.Aspect切面类实现org.springframework.core.Ordered接口
 *          @Aspect
            public class Aspect2 implements Ordered{
                @Override
                public int getOrder() {
                return 2;
            }
        3.XML方式
            <aop:aspect ref="Aspect3" order="3">
                ...
            </aop:aspect>
 */
public class MultiMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MultiConfig.class);
        MultiBean multiBean = ctx.getBean(MultiBean.class);
        multiBean.testMulti();
    }
}
