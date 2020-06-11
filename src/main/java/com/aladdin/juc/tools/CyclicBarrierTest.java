package com.aladdin.juc.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 所有线程 (construct @param parties) 调用 await() 到达屏障后阻塞
 * 直到最后一个到达后，继续执行
 *
 * @author lgc
 */
public class CyclicBarrierTest {

    static CyclicBarrier cyclicBarrier=new CyclicBarrier(3);

    public static void main(String[] args) {
        new Thread(()->{
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
