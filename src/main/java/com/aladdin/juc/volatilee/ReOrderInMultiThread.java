package com.aladdin.juc.volatilee;

/**
 * @author lgc
 */
public class ReOrderInMultiThread {
    static int a = 0;
    static boolean flag = false;

    public static void main(String[] args) {
        int i = 0;
        try {
            for (; ; i++) {
                a = 0;
                flag = false;

                Thread thread = new Thread(() -> {
                    a = 1;
                    flag = true;
                });
                Thread thread1 = new Thread(() -> {
                    if (flag) {
                        a /= a;
                    }
                });

                thread.start();
                thread1.start();
                thread.join();
                thread1.join();
            }
        } catch (RuntimeException | InterruptedException e) {
            System.out.println(i);
            e.printStackTrace();
        }
    }
}
