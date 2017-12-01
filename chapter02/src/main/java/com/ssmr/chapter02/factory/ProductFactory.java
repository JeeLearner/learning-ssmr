package com.ssmr.chapter02.factory;

/**
 * 抽象工厂模式
 *      每个工厂分工不同
 *      调用者不用知道调用的哪个工厂，甚至不知道里面的规则
 */
public class ProductFactory implements IProductFactory {
    @Override
    public IProduct createProduct(String productNo) {
        char ch = productNo.charAt(0);
        IProductFactory factory = null;
        if (ch == '1'){
            factory = new ProductFactory1();
        }else if (ch == '2'){
            factory = new ProductFactory2();
        }else if (ch == '3'){
            factory = new ProductFactory3();
        }
        if (factory != null){
            return factory.createProduct(productNo);
        }
        return null;
    }
}
