package com.aladdin.basic.data;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

/**
 * final JVM 优化 ，局部参数改变值
 *
 * @author lgc
 */
public class FinalAction {
    static final String s;
    static final String SS = "ss";

    static {
        s = "final initialValue";
    }

    static void finalParamChange(final int i, final Long l,
                                 final int[] arr, final Integer[] arg,
                                 final FinalInner finalInner,
                                 final String s
    ) throws NoSuchMethodException {
        Class<FinalAction> finalActionClass = FinalAction.class;
        Method[] methods = finalActionClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Method finalParamChange = finalActionClass.getDeclaredMethod("finalParamChange", int.class, Long.class, int[].class, Integer[].class, FinalInner.class, String.class);
        finalParamChange.setAccessible(true);
        Parameter[] parameters = finalParamChange.getParameters();
        for (Parameter parameter : parameters) {
            Type parameterizedType = parameter.getParameterizedType();
            System.out.println(parameterizedType);
        }
        Parameter parameter = parameters[1];
        int modifiers = parameter.getModifiers();
        System.out.println("in: "+modifiers);
        modifiers++;
        System.out.println("mod: "+modifiers);
        System.out.println(l);
        //todo modifier ？
    }

    static class FinalInner {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "FinalInner{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        finalParamChange(1, 1L, new int[]{1, 2}, new Integer[]{1, 2}, new FinalInner(), "S");
    }

}
