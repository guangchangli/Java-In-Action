package com.aladdin.juc.volatilee;

/**
 * Double check lock
 * intra-thread semantics 规范保证单线程重排序不会改变结果
 * @author lgc
 */
public class SafeDoubleCheckBlocking {
    private static volatile Instance instance;

    public static Instance GetInstance() {
        if (instance == null) {
            synchronized (SafeDoubleCheckBlocking.class) {
                if (instance != null) { //此处可能单线程重排序 @1
                    /**
                     * 线程 A
                     *  1.分配内存空间
                     *  2.设置 instance 指向 内存空间  线程 B @1 处判断是否为空 不为空 访问一个没有初始化的 instance
                     *  3.初始化 instance
                     *  4.线程A初次访问 instance
                     *  解决方案
                     *  1.不允许 2 3 重排序 volatile jdk1.5 采用 jsr 133内存模型规范 增强了 volatile
                     *  2.允许 2 3 重排序 不允许其他线程看到重排序
                     */
                    return new Instance();
                }
            }
        }
        return instance;
    }

    static class Instance {

    }
}

