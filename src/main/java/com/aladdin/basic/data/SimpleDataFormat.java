package com.aladdin.basic.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 解决方案
 * 1.加锁
 * 2.每次都创建新的
 * 3.ThreadLocal
 * 4.LocalDate DateTimeFormatter
 */
public class SimpleDataFormat {


    private static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        for (int i = 1; i < 31; i++) {
            int ii = i;
            new Thread(() -> {
                Date date;
                try {
                    String s = "2019-05-" + ii;
                    date = SDF.parse(s);
                    System.out.println("" + ii + ":" + date.getDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

