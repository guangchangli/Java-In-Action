package com.aladdin.juc.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author lgc
 */
public class AqsImpl extends AbstractQueuedSynchronizer {

    /**
     * 独占式获取同步状态
     * 实现该方法 需要查询当前状态并判断同步状态是否符合预期
     * 然后在进行 cas 设置同步状态
     */
    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    /**
     * 独占式释放同步锁状态
     * 等待获取同步状态的线程将有机会获取同步状态
     */
    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    /**
     * 共享式获取同步状态
     * 返回大于等于0的值
     * 表示获取成功 反之 获取失败
     * @param arg
     * @return
     */
    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    /**
     * 共享式释放同步状态
     */
    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    /**
     * 当前同步器是否在独占模式下被线程占用
     * 一般该方法表示是否被当前线程所独占
     */
    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}
