package com.aladdin.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lgc
 **/
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do something before jdk proxy invoke ");
        Object result = method.invoke(target, args);
        System.out.println("do something after jdk proxy invoke ");
        return result;
    }
}
