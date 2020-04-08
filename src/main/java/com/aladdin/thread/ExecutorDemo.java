package com.aladdin.thread;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * 线程池好处
 * 1。降低资源消耗 重复利用已经创建好的线程 降低创建消耗
 * 2。提高相应速度 任务到达 可以不用等待线程创建 直接执行
 * 3。可管理性 统一分配，可以监控调优
 * 避免this 逃逸 （在构造函数返回之前其他线程就持有该对象的引用. 调用尚未构造完全的对象的方法可能引发令人疑惑的错误）
 * Executors 创建线程 允许创建的线程数量为 Integer.MAX_VALUE 允许请求队列长度为 Integer.MAX_VALUE
 *
 * @author lgc
 **/
public class ExecutorDemo {

    private static final int corePoolSize = 5;
    private static final int maximumPoolSize = 10;
    private static final long keepAliceTime = 1L;
    private static final int queueCap = 30;

    /**
     * Executor
     * 1。任务（Runnable | Callable）
     * 2。任务的执行
     * 3。异步计算的结果
     */
    public static void main(String[] args) {

//        ExecutorService executorService = Executors.newCachedThreadPool();
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(queueCap);
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliceTime, TimeUnit.SECONDS, blockingQueue, new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 30; i++) {
            executor.execute(() -> System.out.println(Thread.currentThread().getName()+" : "+ LocalDateTime.now()));
        }
        executor.submit(()-> System.out.println(Thread.currentThread().getName()+" : "+ LocalDateTime.now()));
//        终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
