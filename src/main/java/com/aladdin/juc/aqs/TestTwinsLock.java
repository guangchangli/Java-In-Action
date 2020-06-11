package com.aladdin.juc.aqs;

import com.aladdin.juc.thread.SleepUtils;
import lombok.SneakyThrows;

/**
 * 两个线程 sout
 * @author lgc
 */
public class TestTwinsLock {
    public static void main(String[] args) throws InterruptedException {
        final TwinsLock lock = new TwinsLock();
        class Worker extends Thread {
            @SneakyThrows
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
