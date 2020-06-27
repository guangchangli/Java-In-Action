package com.aladdin.basic.reference;

import java.io.IOException;

/**
 * 强引用
 * @author lgc
 */
public class NormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m=null;
        //垃圾回收是单独的线程
        System.gc();
        System.in.read();
    }
}
