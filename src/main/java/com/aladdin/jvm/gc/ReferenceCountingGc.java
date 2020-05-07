package com.aladdin.jvm.gc;

/**
 * @author lgc
 */
public class ReferenceCountingGc {
    public Object instance = null;
    public static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGc() {
        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }

    public static void main(String[] args) {
        testGc();
    }
}
