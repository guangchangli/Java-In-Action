package com.aladdin.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * 查询缓存是否代理过 concurrentMap weakCache
 * interface limit 65535
 * JDK 动态代理是通过实现目标类的接口，
 * 然后将目标类在构造动态代理时作为参数传入，
 * 使代理对象持有目标对象，
 * 再通过代理对象的 InvocationHandler 实现动态代理的操作。
 * @author lgc
 */
public class JdkDynamicProxy{
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyInvocationHandler(target));
    }
}