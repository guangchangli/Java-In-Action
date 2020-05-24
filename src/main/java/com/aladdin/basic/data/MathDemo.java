package com.aladdin.basic.data;

import static java.lang.Math.*;

/**
 * math 方法
 * @author lgc
 */
public class MathDemo {
    public static void main(String[] args) {
        /**
         * 1.取整
         */
        //floor 向下取整
        System.out.println(floor(2.3));
        //round 四舍五入
        System.out.println(round(2.49));
        //ceil 不小于最小整数
        System.out.println(ceil(2.1));
        System.out.println((int)ceil(2));
        //(int)去掉小数点
        System.out.println((int)1.2);
        /**
         * 取绝对值 abs
         */
        System.out.println(abs(-20.5));
        System.out.println(abs(20.5));
        /**
         * 随机数 random
         */
        System.out.println((int)(100*random()));
        /**
         * 幂函数 pow x^y
         */
        System.out.println(pow(2,2));
        /**
         * 开根号 sqrt
         */
        System.out.println(sqrt(pow(4,2)));
    }
}
