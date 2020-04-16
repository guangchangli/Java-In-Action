package com.aladdin.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author lgc
 **/
public class ObjectOut {
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
    }
}
