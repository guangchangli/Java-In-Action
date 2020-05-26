package com.aladdin.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁 in Java
 * 1.乐观锁/悲观锁
 * 2.独享锁/共享锁
 * 3.互斥锁/读写锁
 * 4.可重入锁
 * 5.公平锁/非公平锁
 * 6.分段锁
 * 7.偏向锁/轻量级锁/重量级锁
 * 8.自选锁
 * 9.分布式锁
 *
 * @author lgc
 **/
public class LockDemo {
    public static void main(String[] args) {
        //lock 获取锁写在 try 里面 抛出异常会无故释放锁
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
        } finally {
            lock.unlock();
        }
        /**
         * lock 锁 具备的 sync 不具备的特性
         * 1.尝试非阻塞的获取锁
         *   当前线程尝试获取锁 如果这一时刻没有被其他线程获取到，则成功获取并持有锁
         * 2.能被中断地获取锁
         *   与 synchronized 不同，获取到锁的线程能够相应中断
         *   当获取到锁的线程被中断时，中断异常将会被抛出，同时锁会被释放
         * 3.超时获取锁
         *   在指定的截止时间之前获取锁，如果截止时间到了仍然无法获取锁，则返回
         */
    }
}
