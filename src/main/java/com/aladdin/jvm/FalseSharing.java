package com.aladdin.jvm;

/**
 * @author lgc
 */
public class FalseSharing implements Runnable {
    public static int NUM_THREADS = 4;
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private final int arrayIndex;
    private static VolatileLong[] longs;
    public static long SUM_TIME = 0l;

    public FalseSharing(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public static void main( String[] args) throws Exception {
        for (int j = 0; j < 10; j++) {
            System.out.println(j);
            longs = new VolatileLong[NUM_THREADS];
            for (int i = 0; i < longs.length; i++) {
                longs[i] = new VolatileLong();
            }
            final long start = System.currentTimeMillis();
            runTest();
            final long end = System.currentTimeMillis();
            SUM_TIME += end - start;
        }
        System.out.println("平均耗时：" + SUM_TIME / 10000);
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharing(i));
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }

    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndex].value = i;
        }
    }

    public final static class VolatileLong {
        //缓存行填充  3s
//        public long p1, p2, p3, p4, p5, p6, p7;
        public volatile long value = 0L;
//        public long p8, p9, p10, p11, p12, p13, p14;
    }
}