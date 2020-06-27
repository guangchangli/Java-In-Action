package com.aladdin.basic.reference;


import java.util.concurrent.TimeUnit;

/**
 * @author lgc
 */
public class ThreadLocalAction {
//    volatile static Person p = new Person();
    static ThreadLocal<Person> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }).start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(new Person());
//            p.name = "ppp";
        }).start();
    }
}

class Person {
    static String name = "person";
}
