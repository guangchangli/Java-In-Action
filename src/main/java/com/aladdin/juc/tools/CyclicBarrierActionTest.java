package com.aladdin.juc.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lgc
 */
public class CyclicBarrierActionTest {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new A());

    static class A implements Runnable {

        @Override
        public void run() {
            System.out.println(3);
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }

}
