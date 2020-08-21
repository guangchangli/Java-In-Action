package com.aladdin.basic.data;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 高并发下统计
 * @author lgc
 **/
public class LongAdderDemo {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        AtomicLong atomicLong = new AtomicLong();
//        Lock lock = new Lock();
    }
}
