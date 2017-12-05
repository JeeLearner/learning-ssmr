package com.ssmr.chapter10.el.main;

import com.ssmr.chapter10.el.config.ElConfig;
import com.ssmr.chapter10.el.pojo.ElBean;
import com.ssmr.chapter10.el.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

public class ElMain {
    public static void main(String[] args) {
        //test01();
        //test02();
        //test03();
        test04();
    }

    /**
     * 举例说明Spring EL的使用
     */
    private static void test01(){
        //表达式解析器
        ExpressionParser parser = new SpelExpressionParser();
        //设置表达式
        Expression exp = parser.parseExpression("'hello world'");
        String str = (String) exp.getValue();
        System.out.println(str); //hello world
        //通过EL访问普通方法
        exp = parser.parseExpression("'hello world'.charAt(0)");
        char ch = (Character) exp.getValue();
        System.out.println(ch); //h
        //通过EL访问的getter方法
        exp = parser.parseExpression("'hello world'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        System.out.println(bytes); //[B@46daef40
        //通过EL访问属性，相当于"hello world".getBytes().length
        exp = parser.parseExpression("'hello world'.bytes.length");
        int length = (Integer)exp.getValue();
        System.out.println(length); //11
        exp = parser.parseExpression("new String('abc')");
        String abc = (String)exp.getValue();
        System.out.println(abc);  //abc

        //创建角色对象
        Role role = new Role(1L, "role_name", "note");
        exp = parser.parseExpression("note");
        //相当于从role中获取备注信息
        String note = (String) exp.getValue(role);
        System.out.println(note); //note

        //变量环境类，并且将角色对象role作为其根节点
        EvaluationContext ctx = new StandardEvaluationContext(role);
        //变量环境类操作根节点
        parser.parseExpression("note").setValue(ctx, "new_note");
        //获取备注，这里的String.class指明，我们希望返回的是一个字符串
        note = parser.parseExpression("note").getValue(ctx, String.class);
        System.out.println(note); //new_note
        //调用getRoleName方法
        String roleName = parser.parseExpression("getRoleName()").getValue(ctx, String.class);
        System.out.println(roleName); //role_name

        //新增环境变量
        List<String> list = new ArrayList<String>();
        list.add("value1");
        list.add("value2");
        //给变量环境增加变量
        ctx.setVariable("list", list);
        //通过表达式去读写环境变量的值
        parser.parseExpression("#list[1]").setValue(ctx, "update_value2");
        System.out.println(parser.parseExpression("#list[1]").getValue(ctx)); //update_value2
    }

    /**
     * Bean的属性和方法
     */
    private static void test02(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ElConfig.class);
        ElBean elBean = ctx.getBean(ElBean.class);
        System.out.println(elBean.getId() + "\t" + elBean.getRole().getRoleName() + "\t" + elBean.getNote());
    }

    /**
     * 使用类的静态常量和方法
     */
    private static void test03(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ElConfig.class);
        ElBean elBean = ctx.getBean(ElBean.class);
        System.out.println(elBean.getPi() + "\t" + elBean.getRandom());
    }

    /**
     * Spring EL运算
     */
    private static void test04(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ElConfig.class);
        ElBean elBean = ctx.getBean(ElBean.class);
        System.out.println(elBean.getNum() + "\t" + elBean.getStr());
        System.out.println(elBean.isEqualNum() + "\t" + elBean.isEqualString() + "\t" + elBean.isGreater() + "\t" + elBean.isLess());
        System.out.println(elBean.getMax() + "\t" + elBean.getDefaultString());
    }
}
