package com.aladdin.thread;

import java.util.Date;

/**
 * @author lgc
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {

        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.set(new Date());
        objectThreadLocal.set("q");
        Object o = objectThreadLocal.get();
        System.out.println(o);
    }
}
