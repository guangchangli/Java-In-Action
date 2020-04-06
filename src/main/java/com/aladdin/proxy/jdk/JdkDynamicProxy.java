package com.aladdin.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * 查询缓存是否代理过 concurrentMap weakCache
 * interface limit 65535
 */
public class JdkDynamicProxy{
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyInvocationHandler(target));
    }
}