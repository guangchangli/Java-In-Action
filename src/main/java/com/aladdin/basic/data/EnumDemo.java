package com.aladdin.basic.data;

import java.util.Arrays;

/**
 * @author lgc
 */
public enum EnumDemo {
    ENUM_DEMO("ed0"),
    ENUM_DEMO1("ed1")
    ;
    private String name;

    EnumDemo(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        EnumDemo[] values = EnumDemo.values();
        for (EnumDemo value : values) {
            System.out.println(value+":"+value.name);
        }
        System.out.println(Arrays.asList(values));
        System.out.println(Enum.valueOf(EnumDemo.class,"ENUM_DEMO"));
        System.out.println(ENUM_DEMO1.ordinal());
    }
}
