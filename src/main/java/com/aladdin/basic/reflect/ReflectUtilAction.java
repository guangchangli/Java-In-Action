package com.aladdin.basic.reflect;

import org.springframework.util.ClassUtils;

/**
 * @author lgc
 */
public class ReflectUtilAction {
    public static void main(String[] args) {
        Class<?>[] allInterfacesForClass = ClassUtils.getAllInterfacesForClass(Cl.class);
        for (Class<?> interfacesForClass : allInterfacesForClass) {
            System.out.println(interfacesForClass.getName());
        }
    }
    interface InnerInter{
        void in();
    }
    interface InnerAnoInter{
        void in2();
    }
    class Cl implements InnerAnoInter,InnerInter{

        @Override
        public void in() {

        }

        @Override
        public void in2() {

        }
    }
}
