package com.aladdin.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * CGLIB 动态代理是通过配置目标类信息，
 * 然后利用 ASM 字节码框架进行生成目标类的子类。
 * 当调用代理方法时，通过拦截方法的方式实现代理的操作。
 * JDK 动态代理利用接口实现代理，CGLIB 动态代理利用继承的方式实现代理。
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
