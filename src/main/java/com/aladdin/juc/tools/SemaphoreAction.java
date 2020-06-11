package com.aladdin.juc.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 流量控制
 * aqs nonfair(default)
 *
 * @author lgc
 */
public class SemaphoreAction {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(1, true);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(() -> {
                try {
                    s.acquire();
//                s.acquireUninterruptibly();
                    System.out.println();
                    System.out.println("save data ");
                    System.out.println("available: " + s.availablePermits());
                    System.out.println("queue length: " + s.getQueueLength());
//                try {
//                    s.acquire(9);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                s.drainPermits();
                    s.release();
                    System.out.println("available: " + s.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }
}
