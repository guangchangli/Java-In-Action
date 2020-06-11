package com.aladdin.juc.tools;

import java.util.Map;
import java.util.concurrent.*;

/**
 * ReentrantLock + Condition
 * 调用 await() 拦截线程数 +1 判断剩余拦截数是否是 初始值 parties 0
 * 如果不是进入等待队列
 * 如果是，执行 CyclicBarrier 的 run 方法，队列中线程进入等待队列 顺序执行
 * @author lgc
 */
public class CyclicBarrierAction implements Runnable {
    private CyclicBarrier c = new CyclicBarrier(4, this);
    private ExecutorService executor = Executors.newFixedThreadPool(4);
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    @Override
    public void run() {
        System.out.println("run");
        System.out.println("cyclic value: "+c.getParties());
        System.out.println("wait counts : "+c.getNumberWaiting());
        int count = 0;
        for (Map.Entry<String, Integer> stringIntegerEntry : sheetBankWaterCount.entrySet()) {
            count += stringIntegerEntry.getValue();
        }
        sheetBankWaterCount.put("result", count);
        System.out.println("count: "+count);
        System.out.println("cyclic value: "+c.getParties());
    }


    private void count() {
        System.out.println("count");
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                try {
                    c.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        CyclicBarrierAction cyclicBarrierAction = new CyclicBarrierAction();
        cyclicBarrierAction.count();
    }
}
