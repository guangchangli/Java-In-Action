package com.aladdin.proxy;

import com.aladdin.proxy.cglib.CglibProxy;
import org.junit.Test;

/**
 * @author lgc
 **/
public class TestCglibProxy {
    @Test
    public void test(){
        Animal proxy = (Animal) CglibProxy.getProxy(Cat.class);
        proxy.call();
    }
}
