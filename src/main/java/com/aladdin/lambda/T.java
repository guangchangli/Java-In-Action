package com.aladdin.lambda;

/**
 * @author lgc
 */
public class T {
    public static void startRunnable(Runnable runnable){
        new Thread(runnable).start();
    }

    public static void main(String[] args) {
        startRunnable(Thread::new);
        startRunnable(()->{

        });
    }
}
