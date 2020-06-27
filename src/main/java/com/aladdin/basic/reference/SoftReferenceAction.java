package com.aladdin.basic.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用在内存不够的时候被回收 缓存队列 浏览器
 * @author lgc
 */
public class SoftReferenceAction {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());
        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println(m.get());
    }
}
