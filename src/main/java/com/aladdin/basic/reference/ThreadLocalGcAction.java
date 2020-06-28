package com.aladdin.basic.reference;

import java.util.concurrent.TimeUnit;

/**
 * -Xmx 15m
 * 不同线程持有一个变量 修改 value 影响所有 tl
 * @author lgc
 */
public class ThreadLocalGcAction {
    private static ThreadLocal<M> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        M m = new M();
        m.setName("m");
        tl.set(m);
        System.out.println("gc 之前" + tl.get());
        System.out.println("mock gc");
        System.gc();
        System.out.println("mock gc out");
        // 另外一个线程修改m
        new Thread(()->{
            tl.set(m);
            m.setName("mm");
            M m1 = tl.get();
            System.out.println(m1);
        }).start();
        TimeUnit.SECONDS.toSeconds(1);
        System.out.println("gc 之后" + tl.get());
    }
}
