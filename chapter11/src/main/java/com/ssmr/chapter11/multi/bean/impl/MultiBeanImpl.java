package com.ssmr.chapter11.multi.bean.impl;

import com.ssmr.chapter11.multi.bean.MultiBean;
import org.springframework.stereotype.Component;

@Component
public class MultiBeanImpl implements MultiBean {
    @Override
    public void testMulti() {
        System.out.println("test multi aspects!");
    }
}
