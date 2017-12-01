package com.ssmr.chapter02.observer;

import java.util.Observable;
import java.util.Observer;

public class TaobaoObserver implements Observer {
    @Override
    public void update(Observable o, Object product) {
        String newProduct = (String) product;
        System.err.println("新产品【"+newProduct+"】同步到淘宝商城");
    }
}
