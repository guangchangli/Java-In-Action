package com.aladdin.basic.data;

import java.lang.reflect.Field;

/**
 * @author lgc
 */
public class Client {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Final test = new Final();
        Class mClass = test.getClass();
        // 获取NAME变量进行修改
        Field field = mClass.getDeclaredField("NAME");
        if (field != null) {
            field.setAccessible(true);
            System.out.println("modify before " + field.get(test));
            // 进行修改
            field.set(test, "钢丝");
            System.out.println("modify after " + field.get(test));
            System.out.println("getName = " + test.getName());
        }
    }
}
