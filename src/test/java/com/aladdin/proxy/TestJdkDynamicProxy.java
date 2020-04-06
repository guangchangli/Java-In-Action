package com.aladdin.proxy;

import com.aladdin.proxy.jdk.JdkDynamicProxy;
import org.junit.Test;

/**
 * @author lgc
 **/
public class TestJdkDynamicProxy {
    @Test
    public void testJdkDynamicProxy(){
        Animal proxy = (Animal) JdkDynamicProxy.getProxy(new Cat());
        proxy.call();
    }
}
