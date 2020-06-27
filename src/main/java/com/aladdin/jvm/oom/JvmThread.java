package com.aladdin.jvm.oom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * heap oom 其他线程还是可以正常运行
 * 线程 oom 后 占用对象会被 gc，内存释放
 * @author lgc
 */
public class JvmThread {
    public static void main(String[] args) {
        new Thread(() -> {
            List<byte[]> list = new ArrayList<>();
            while (true) {
                System.out.println(new Date().toString() + Thread.currentThread() + "==");
                byte[] b = new byte[1024 * 1024 * 1];
                list.add(b);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 线程二
        new Thread(() -> {
            while (true) {
                System.out.println(new Date().toString() + Thread.currentThread() + "==");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
