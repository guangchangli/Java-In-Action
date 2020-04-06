package com.aladdin.proxy;

import org.junit.Test;

/**
 * @author lgc
 **/
public class TestStaticProxy {

    @Test
    public void test(){
        new CatStaticProxy(new Cat()).call();
    }
}
