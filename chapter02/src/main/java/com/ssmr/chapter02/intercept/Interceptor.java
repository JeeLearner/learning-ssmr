package com.ssmr.chapter02.intercept;

import java.lang.reflect.Method;

public interface Interceptor {

    public boolean before(Object proxy, Object target, Method method, Object[] args);

    public void around(Object proxy, Object target, Method method, Object[] args);

    public void after(Object proxy, Object target, Method method, Object[] args);
}
