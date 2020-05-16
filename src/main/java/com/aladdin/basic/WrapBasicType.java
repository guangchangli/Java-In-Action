package com.aladdin.basic;

/**
 * @author lgc
 */
public class WrapBasicType {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE-1==Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1==Integer.MAX_VALUE);
        Integer i = 130;
        Integer j = new Integer(100);
        Integer x = 100;
        Integer z = 130;
        System.out.println((i == z) + "\n" + (x == j));
    }
}
