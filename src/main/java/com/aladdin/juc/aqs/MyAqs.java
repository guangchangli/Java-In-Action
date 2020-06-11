package com.aladdin.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class MyAqs implements Lock {

    /**
     * 线程1占用
     * 队列中存在线程等待
     * 等待线程数量：1
     * 等待第一个线程thread2:
     * 线程1两秒倒计时
     * 队列中存在线程等待
     * 线程1占用
     * 线程1释放占用
     * 线程2占用成功
     * 队列中不存在线程等待
     * 等待线程数量：0
     * 线程2两秒倒计时
     * 队列中不存在线程等待
     * 线程2占用成功
     * 线程2释放占用
     */

    public static void main(String[] args) throws InterruptedException {
        /**
         * 会自动释放
         * 线程1占用
         * 线程1两秒倒计时
         * 线程2占用失败    占用失败直接进入等待队列
         * 线程2两秒倒计时
         * 线程1释放占用
         * 线程2释放占用
         */
        Sync sync = new Sync();
        Thread thread = new Thread(() -> {
            try {
                sync.acquire(1);
                System.out.println(sync.isHeldExclusively() ? "线程1占用" : "线程1占用失败");
                System.out.println(sync.hasQueuedThreads() ? "队列中存在线程等待" : "队列中不存在线程等待");
                Thread firstQueuedThread = sync.getFirstQueuedThread();
                int queueLength = sync.getQueueLength();
                System.out.println("等待线程数量：" + queueLength);
                System.out.println("等待第一个线程" + firstQueuedThread.getName());
                System.out.println("线程1两秒倒计时");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(sync.hasQueuedThreads() ? "队列中存在线程等待" : "队列中不存在线程等待");
                System.out.println(sync.isHeldExclusively() ? "线程1占用" : "线程1占用失败");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (sync.isHeldExclusively()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(sync.release(0) ? "线程1释放占用" : "线程1释放失败");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread1 = new Thread(() -> {
            try {
                sync.acquire(1);
                System.out.println(sync.isHeldExclusively() ? "线程2占用成功" : "线程2占用失败");
                System.out.println(sync.hasQueuedThreads() ? "队列中存在线程等待" : "队列中不存在线程等待");
                int queueLength = sync.getQueueLength();
                System.out.println("等待线程数量：" + queueLength);
                System.out.println("线程2两秒倒计时");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(sync.hasQueuedThreads() ? "队列中存在线程等待" : "队列中不存在线程等待");
                System.out.println(sync.isHeldExclusively() ? "线程2占用成功" : "线程2占用失败");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (sync.isHeldExclusively()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(sync.release(0) ? "线程2释放占用" : "线程2释放失败");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("thread1:");
        thread1.setName("thread2:");
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }

    // 静态内部类，自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer {
        // 是否处于占用状态
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // 当状态为0的时候获取锁
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, acquires)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 释放锁，将状态设置为0
        protected boolean tryRelease(int releases) {
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 返回一个Condition，每个condition都包含了一个condition队列
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    // 将操作代理到Sync上即可
    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }
}