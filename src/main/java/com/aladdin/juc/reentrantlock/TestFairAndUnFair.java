package com.aladdin.juc.reentrantlock;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author lgc
 */
public class TestFairAndUnFair {
    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unFairLock = new ReentrantLock2(false);

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        public void run() {
            lock.lock();
            ReentrantLock2 current= (ReentrantLock2) lock;
            List<String> collect = current.getQueuedThreads().stream().map(Thread::getName).collect(Collectors.toList());
            Collections.reverse(collect);
            //Lists.reverse(collect); doesn`t work
            Lists.reverse(collect);
            System.out.println("Lock by [ " + Thread.currentThread().getName() + " ], Waiting by " + collect);
            lock.unlock();
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
           return super.getQueuedThreads();
        }
    }

    @SneakyThrows
    static void testLock(Lock lock) {
        for (int i = 0; i < 5; i++) {
            Job job = new Job(lock);
            job.setName(Integer.toString(i));
            job.start();
        }
    }

    public static void main(String[] args) {
//        testLock(fairLock);
        testLock(unFairLock);
    }
}
