package com.ssmr.chapter02.observer;

import java.util.Observable;
import java.util.Observer;

public class JingdongObserver implements Observer {

    @Override
    public void update(Observable o, Object product) {
        String newProduct = (String)product;
        System.err.println("新产品【"+newProduct+"】同步到京东商城");
    }
}
