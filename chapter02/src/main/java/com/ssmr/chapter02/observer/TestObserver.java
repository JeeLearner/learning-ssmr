package com.ssmr.chapter02.observer;

public class TestObserver {
    public static void main(String[] args) {
        JingdongObserver jdObserver = new JingdongObserver();
        TaobaoObserver tbObserver = new TaobaoObserver();
        ProductList observable = ProductList.getInstance();
        //设置观察者
        observable.addObserver(jdObserver);
        observable.addObserver(tbObserver);
        //新增产品测试
        observable.addProduct("新增产品1");
    }
}
