package com.aladdin.basic.reference;

/**
 * 1.强引用 默认 手动引用 null 才会被回收
 * 2.弱引用
 * 3.软引用 非必需但仍有用的对象，内存不够的时候才回收  java.lang.ref.SoftReference
 * 4.虚引用
 * @author lgc
 */
public class FourReferenceAction {
    public static void main(String[] args) {
        Refer refer = new Refer();
    }
    static class Refer{
        private String name;
    }
}
