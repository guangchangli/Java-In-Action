package com.aladdin.basic;

/**
 * @author lgc
 */
public class StaticAtom {
    static {
        int x = 5;
    }

    static int x, y;

    public static void main(String[] args) {
        x--;
        test();
        System.out.println(x + y++ + x);
    }

    static void test() {
        y = x++ + ++x;
        // y=x + ++x
        // x++;
    }
}
