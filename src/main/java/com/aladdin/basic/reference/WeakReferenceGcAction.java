package com.aladdin.basic.reference;

import java.lang.ref.WeakReference;

/**
 * gc 后 弱引用持有的对象 不可达才会被回收
 * 引用 只要存在就不会被回收
 * 引用(引用类型的数据存储的数值代表另外一块内存的起始地址，就代表是一个引用)是一个地址
 * @author lgc
 */
public class WeakReferenceGcAction {
    private static ThreadLocal<M> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        M m = new M();
        m.setName("m");
        WeakReference<M> mWeakReference = new WeakReference<>(m);
        //M m1 = mWeakReference.get();
        System.out.println(mWeakReference.get());
        m=null;
        System.gc();
        System.out.println(mWeakReference.get());

    }
}
