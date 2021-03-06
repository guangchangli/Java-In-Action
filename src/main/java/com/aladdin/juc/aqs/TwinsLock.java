package com.aladdin.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 最多两个线程共享式访问
 *
 * @author lgc
 */
public class TwinsLock implements Lock {
    private final SyncTwins syncTwins = new SyncTwins(2);


    private static final class SyncTwins extends AbstractQueuedSynchronizer {
        SyncTwins(int count) {
            if (count <= 0) throw new IllegalArgumentException("count must large than zero");
            setState(count);
        }

        public int tryAcquireShared(int reduceCount) {
            for (; ; ) {
                int current = getState();
                int newCount = current - reduceCount;
                if (newCount < 0 || compareAndSetState(current, newCount)) return newCount;
            }
        }

        //释放需要保证安全释放 循环 cas
        public boolean tryReleaseShared(int returnCount) {
            for (; ; ) {
                int current = getState();
                int newCurrent = current + returnCount;
                if (compareAndSetState(current, newCurrent)) return true;
            }
        }
    }

    @Override
    public void lock() {
        syncTwins.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) {
        return false;
    }

    @Override
    public void unlock() {
        syncTwins.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
