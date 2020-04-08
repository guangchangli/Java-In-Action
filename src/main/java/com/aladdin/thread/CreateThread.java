package com.aladdin.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lgc
 **/
public class CreateThread {
    /**
     * start run
     * start 会创建新的线程 状态转为 Runnable 获取到cpu执行 调用run() 不可以多次调用
     * run jvm 调用 可以多次调用
     */
    static class ExtendThread extends Thread {
        @Override
        public void run() {
            System.out.println("extend thread create thread");
        }
    }

    static class ImplementsThread implements Runnable {
        @Override
        public void run() {
            System.out.println("implements Runnable create thread");
        }
    }

    static class Implements implements Callable<String> {

        @Override
        public String call() {
            System.out.println("implements Callable create thread");
            return "success";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ExtendThread().start();
        new Thread(new ImplementsThread()).start();
        new Thread(new FutureTask<>(new Implements())).start();
        FutureTask<String> future = new FutureTask<>(() -> "hello");
        Thread thread = new Thread(future);
//        Thread thread = new Thread(new FutureTask<>(()->"hello future task"));
        thread.setName("myCallable001");
        thread.start();
        while (!future.isDone()) {
            try {
                System.out.println("myCallable001 is not done");
                //等待线程运行结束
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String result = future.get();
        System.out.println("result : " + result);

    }

}
