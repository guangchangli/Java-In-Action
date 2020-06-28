package com.aladdin.basic.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * 无法通过虚引用来获取对象的实例，虚引用不会对其生存时间构成影响
 *
 * 管理堆外内存(正常是资源数据在操作系统内存，拷贝到 JVM 内存中通过 JVM 管理内存)
 * DirectByteBuffer 操作系统管理 直接引用内存 (io netty) 应用
 *
 * DirectByteBuffer BIO
 * 如果读取 os 网卡进来缓冲区的数据 需要从 OS 内存缓冲区拷贝一份到 JVM 内存
 * 往外发数据也要从 JVM 内存拷贝到 OS 缓冲区 通过网卡发出去 效率比较低
 *
 * DirectByteBuffer 可以让对象 直接指向 OS 数据内存地址
 * 只需要监测一个队列 当对象被回收了 GC线程区回收 os 内存 (否则就会内存泄漏 忘记回收 导致直接内存溢出)
 *
 * 当对象被回收时，通过 QUEUE 可以监测到，然后清理堆外内存
 * @author lgc
 */
public class PhantomReferenceAction {
    private static final List<Object> LIST = new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {
        PhantomReference<M> phantomReference = new PhantomReference<>(new M(), QUEUE);
        new Thread(() -> {
            while (true) {
                LIST.add(new byte[1024 * 1024 ]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(phantomReference.get());
            }
        }).start();
        new Thread(() -> {
            while (true) {
                Reference<? extends M> poll = QUEUE.poll();
                if (poll != null) {
                    System.out.println("虚引用对象被jvm回收了---" + poll);
                }
            }
        }).start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
