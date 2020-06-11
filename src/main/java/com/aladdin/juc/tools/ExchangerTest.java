package com.aladdin.juc.tools;

import java.util.concurrent.*;

/**
 * 如果一个线程没有执行exchange()方法 会一直等待
 * EXCHANGER.exchange(A);
 * EXCHANGER.exchange(A,10, TimeUnit.SECONDS); //最大等待时间
 * @author lgc
 */
public class ExchangerTest {
    private static final Exchanger<String> EXCHANGER = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            try {
                String A = "A call";
                EXCHANGER.exchange(A);
                EXCHANGER.exchange(A,10, TimeUnit.SECONDS);
            } catch (InterruptedException | TimeoutException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            try {
                String B = "A call";
                String A = EXCHANGER.exchange(B);
                System.out.println("data is equal:" + A.equals(B) + ",a is:" + A + ",And b is :" + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.shutdown();
    }
}
