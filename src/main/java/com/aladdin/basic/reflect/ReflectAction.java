package com.aladdin.basic.reflect;

/**
 * @see TestReflect
 * @author lgc
 */
public class ReflectAction {
    static {
        System.out.println(ReflectAction.class.getName()+":static block load");
    }


    public ReflectAction() {
        System.out.println("init");
    }
}
