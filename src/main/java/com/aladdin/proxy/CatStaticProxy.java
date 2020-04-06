package com.aladdin.proxy;

/**
 * @author lgc
 **/
public class CatStaticProxy implements Animal {

    Cat cat;

    public CatStaticProxy(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void call() {
        System.out.println("cat static proxy do something");
        cat.call();
    }
}
