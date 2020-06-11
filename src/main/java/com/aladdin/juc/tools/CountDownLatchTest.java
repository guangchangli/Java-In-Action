package com.aladdin.juc.tools;

import java.util.concurrent.CountDownLatch;

/**
 * countDownLatch 不可能重新初始化或者修改 CountDownLatch 对象的内部计数器的值
 * 内部实现是 aqs shared
 * @author lgc
 */
public class CountDownLatchTest {
    //计数器 控制线程数量
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            countDownLatch.countDown();
            System.out.println(2);
//            countDownLatch.countDown();
        }).start();
        //await 阻塞当前线程直到 countDownLatch 计数变为0
        countDownLatch.await();
        System.out.println(3);
    }
}
