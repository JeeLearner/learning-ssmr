package com.ssmr.chapter02.factory;

public class ProductFactory3 implements IProductFactory {
    @Override
    public IProduct createProduct(String productNo) {
        IProduct product = null; //工厂3生产产品对象规则，可以是一类产品的规则,这里是伪代码
        return product;
    }
}
