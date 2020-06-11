package com.aladdin.basic.data;

/**
 * 进制
 * @author lgc
 */
public class Base {
    public static void main(String[] args) {
        System.out.println(0b10);
        System.out.println(010);
        System.out.println(10);
        System.out.println(0x10);
        //十进制转二进制
        System.out.println(Integer.toBinaryString(10));
        //十进制转八进制
        System.out.println(Integer.toOctalString(10));
        //十进制转十六进制
        System.out.println(Integer.toHexString(10));
    }
}
