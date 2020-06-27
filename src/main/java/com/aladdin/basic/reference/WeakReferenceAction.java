package com.aladdin.basic.reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用遭到gc就会被回收 弱的一批
 *
 * @author lgc
 */
public class WeakReferenceAction {
    public static void main(String[] args) {
        WeakReference<M> w = new WeakReference<>(new M());
        System.out.println(w.get());
        System.gc();
        System.out.println(w.get());
        /**
         *  threadLocal 内部 Entry extends WeakReference
         *  threadLocal 对象回收的时候 Entry key 是 threadLocal 对象 为空  value 没办法回收
         *  需要调用 remove 删除 Entry
         */
        ThreadLocal<M> tl = new ThreadLocal<>();
        M m = new M();
        M m1 = new M();
        m.setName("1");
        m1.setName("2");
        tl.set(m);
        tl.set(m1);
        System.out.println("---");
        System.out.println(tl.get().getName());
        System.out.println("====");
        tl.remove();
    }
}
