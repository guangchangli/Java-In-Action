package com.aladdin.juc.thread;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
    public static final void second(long seconds) throws InterruptedException {
            TimeUnit.SECONDS.sleep(seconds);
    }
}
