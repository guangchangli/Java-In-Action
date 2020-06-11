package com.aladdin.juc.threadpool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lgc
 */
public class CreateThreadPool {
    private ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS,
                    new SynchronousQueue<>(), null, null);

    public static void main(String[] args) {

    }
}
