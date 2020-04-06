package com.aladdin.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法拦截实现
 * 生成目标类的子类，通过调用父类（目标类）的方法实现，在调用父类方法时再代理中进行增强。
 * @author lgc
 **/
public class CglibInterceptor implements MethodInterceptor {
    /**
     *
     * @param o       代理人对象
     * @param method  拦截被代理的方法
     * @param objects 拦截参数
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("do something before cglib proxy");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("do something after cglib proxy");
        return result;
    }
}
