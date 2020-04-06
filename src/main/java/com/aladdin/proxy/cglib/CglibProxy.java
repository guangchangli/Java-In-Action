package com.aladdin.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author lgc
 **/
public class CglibProxy {

    public static Object getProxy(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CglibInterceptor());
        return enhancer.create();
    }
}
