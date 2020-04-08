package com.aladdin.thread;

/**
 * 第5006168次 ( x= 0 y= 0 a= 1 b= 1)
 * @author lgc
 **/
public class PcDisOrder {
    private static int x = 0, y = 0, a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; i++) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread two = new Thread(() -> {
                b = 1;
                y = a;
            });
            one.start();
            two.start();
            one.join();
            two.join();
            String result = "第" + i + "次 (" + " x= " + x + " y= " + y + " a= " + a + " b= " + b + ")";
            if (x == 0 && y == 0) {
                System.out.println(result);
                break;
            }
        }
    }
}
