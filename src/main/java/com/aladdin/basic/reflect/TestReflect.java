package com.aladdin.basic.reflect;

import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.Set;

/**
 * class.forName  init class
 * classLoad      only load class
 * @author lgc
 */
public class TestReflect {
    @SneakyThrows
    public static void main(String[] args) {
        String className = "com.aladdin.basic.reflect.ReflectAction";
        Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass(className);
        System.out.println("classLoad load over");
        Class<?> aClass1 = Class.forName(className);
        System.out.println(aClass==aClass1); //true
        System.out.println(aClass.equals(aClass1));//true
        Class<Integer> integerClass = int.class;
        System.out.println(int.class.getName());//int

        //instance
        Object o = aClass.newInstance();
        Constructor<?> constructor = aClass.getConstructor();
        Object o1 = constructor.newInstance();
        System.out.println(o==o1);//false
        System.out.println(o.equals(o1));//false
        AccessibleObject.setAccessible(aClass.getFields(),true);
        constructor.setAccessible(true);
        Class<?> declaringClass = constructor.getDeclaringClass();
        Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
        /**
         * Field Method Constructor
         * getName
         * getModifiers ( volatile  synchronized)
         * getFields getMethods getConstructs 返回+超类 public 域 、方法、构造器
         * getDeclarerMethods 返回全部 域、方法、构造器 不包括超类
         *
         */
        System.out.println("---arr---");
        String[] arr=new String[]{"1"};
        String[] arr1=new String[2];
        if (!arr.getClass().isArray()){
            return;
        }
        Class<? extends String[]> aClass2 = arr.getClass();
        Class componentType = aClass2.getComponentType();
        //exceed 256
        Object o2 =  Array.newInstance(componentType, 2);
        System.arraycopy(arr,0,arr1,0, Math.min(arr.length,2));
        System.out.println(o2);
        Set<Object> singleton = Collections.singleton(o2);
        System.out.println(singleton);
    }
}
