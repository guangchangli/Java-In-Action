package com.aladdin.basic;

import org.omg.CORBA.IntHolder;

/**
 * 包装器 构造后不允许更改值
 * 包装器可以为 null 自动装箱可能会  npe
 * 装箱和拆箱是编译器认可的 在生成字节码时插入必要方法调用
 * org.omg.CORBA holder
 * @author lgc
 */
public class WrapBasicType {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE-1==Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1==Integer.MAX_VALUE);
        int i = 130;
        Integer j = new Integer(100);
        Integer x = 100;
        Integer z = 130;
        System.out.println((i == z) + "\n" + (x == j));
        //拆箱 ++ 装箱
        Integer n=3;
        n++;
        IntHolder intHolder = new IntHolder(n);
        triple(intHolder);
        System.out.println(intHolder.value);
        System.out.println(n);
        int i1 = Integer.parseInt("1");
        Integer integer = Integer.valueOf("1");
    }

    static void triple(IntHolder intHolder){
        intHolder.value=3*intHolder.value;
    }
}
