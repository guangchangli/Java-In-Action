package com.aladdin.basic.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/** review java core
 * @author lgc
 */
public class JavaCore {
    /**
     * byte short int long 1 2 4 8  java 没有无符号数
     *
     * 数值转换
     *
     *     如果操作数值中有 float double long 另一个操作数也会转换为 相应的类型 ，否则都将被转换成 int 类型
     *
     *                     char
     *                      |
     *    byte -> short -> int  ->  long
     *                      |
     *                    float -> double
     *     精度缺失
     *      int  -> float
     *      long ->double
     *      long -> float
     *  运算符 && 优先级比 ｜｜ 高
     *  >>> 会用 0 填充高位  >> 符号位填充高位
     *  移位操作数要完成 模 32 运算 除非是 long类型（模64）默认是int 32位全部移出去 没意义
     *  只有字符串常量是共享的
     *  浮点数由于舍入误差可能得不到精确值
     *  大数值 bigInteger bigDecimal
     *      + -> add
     *      - -> subtract
     *      * -> multiply
     *      / ->divide
     *      valueIOf(long x,int scale) x/10^scale
     *      x.compareTo(y) x=y ->0 x>y =1 x<y =-1
     *  数组 copyOf copyOfRange sort binarySearch fill equals
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(10>>>2);
        System.out.println(10>>2);
        System.out.println(1<<35);
        System.out.println(1<<3);
        System.out.println(1<<8);
        BigInteger bigInteger = BigInteger.valueOf(1);
        BigDecimal bigDecimal = BigDecimal.valueOf(2);
        BigInteger add = bigInteger.add(new BigInteger(String.valueOf(2)));
        BigDecimal multiply = bigDecimal.multiply(BigDecimal.valueOf(2));
        System.out.println(multiply);
        System.out.println(add);
        // 1/10^2
        System.out.println(BigDecimal.valueOf(1,2));
        System.out.println(bigDecimal.compareTo(BigDecimal.valueOf(3)));
        //数组
//        int[] a;
        int[] a=new int[10];
        int b[]={4,2,3,5,6};
        int[] ints = Arrays.copyOf(b, b.length-1);
        int[] ints1 = Arrays.copyOfRange(b, 1, b.length);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        //快排
        Arrays.sort(ints);
        int i = Arrays.binarySearch(ints1, 1, ints1.length, 6);
        System.out.println("i="+i);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
