package com.ssmr.chapter15.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 交易验证器
 */
public class TransactionValidator implements Validator{

    /**
     * 判断当前验证器是否用于检验Clazz类型的POJO
     * @param clazz  --POJO类型
     * @return true启动检验，false则不再检验
     */
    @Override
    public boolean supports(Class<?> clazz) {
        //判断验证是否为Transaction，如果是则进行判断[修改为：验证]
        return Transaction.class.equals(clazz);
    }

    /**
     * 检验POJO的合法性
     * @param target POJO请求对象
     * @param errors 错误信息
     */
    @Override
    public void validate(Object target, Errors errors) {
        Transaction trans = (Transaction) target;
        double dis = trans.getAmount() - (trans.getPrice() * trans.getQuantity());
        //如果差额大于0.01，则认为业务错误
        if (Math.abs(dis) > 0.01){
            errors.rejectValue("amount", null, "交易金额和购买数量与价格不匹配");
        }
    }
}
