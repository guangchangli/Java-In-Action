package com.aladdin.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * 指针压缩
 * 对象头 12B 数组+4 空数组+0
 * 不压缩
 * 对象头16 数组 8
 *
 * @author lgc
 **/
public class ObjectSize {
    Long[] longs = new Long[8];
    long[] arr = new long[8];


    public static void main(String[] args) {
        ObjectSize objectSize = new ObjectSize();
        objectSize.longs = new Long[]{1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l};
        objectSize.arr = new long[]{1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l};
        //12+4(longs)+ 4(arr)+4(padding)
        System.out.println(ClassLayout.parseInstance(objectSize).toPrintable());
        System.out.println("包含非基本类型属性的对象大小");
        //12+4 int
        System.out.println(ClassLayout.parseInstance(new A()).toPrintable());
        System.out.println("包含非基本类型属性的对象大小");
        //12+4
        System.out.println(ClassLayout.parseInstance(new B()).toPrintable());
        System.out.println("基本类型数组对象的大小");
        //12+4+0+0
        System.out.println(ClassLayout.parseInstance(new int[0]).toPrintable());
        //12+4+4+4
        System.out.println(ClassLayout.parseInstance(new int[1]).toPrintable());
        System.out.println("非基本类型数组对象的大小");
        //16+0+0
        System.out.println(ClassLayout.parseInstance(new A[0]).toPrintable());
        //16+4+4
        System.out.println(ClassLayout.parseInstance(new A[1]).toPrintable());
        System.out.println(ClassLayout.parseInstance(new B[0]).toPrintable());
        System.out.println(ClassLayout.parseInstance(new B[1]).toPrintable());
    }
}

class A {
    //基本类型
    int a = 0;
}

class B {
    //引用类型
    Integer b = 0;
}