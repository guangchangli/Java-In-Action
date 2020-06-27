package com.aladdin.basic.data;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

/**
 * final JVM 优化 ，局部参数改变值
 *
 * @author lgc
 */
public class FinalAction {
    final String s;
    final int i = 0;
    final Integer INTEGER = 1;
    final int[] arr = {1, 2, 3};
    final Integer[] arg = {1, 2, 3};
    final FinalInner FINAL_INNER;

    {
        s = "final initialValue";
        FinalInner finalInner = new FinalInner();
        finalInner.setName("FINAL_INNER");
        FINAL_INNER = finalInner;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        //finalParamChange(1, 1L, new int[]{1, 2}, new Integer[]{1, 2}, new FinalInner(), "S");
        FinalAction finalAction = new FinalAction();
        Class<FinalAction> finalActionClass = FinalAction.class;
        /**
         * change String fail
         */
        Field s = finalActionClass.getDeclaredField("s");
        System.out.println("before modify s: " + s.get(finalAction));
        s.setAccessible(true);
        s.set(finalAction, "s");
        System.out.println("after modify s：" + s.get(finalAction));
        /**
         * change int fail
         */
        Field i = finalActionClass.getDeclaredField("i");
        System.out.println("before modify i: " + i.get("i"));
        i.setAccessible(true);
        //i.set(finalAction,1);
        System.out.println("after modify i：" + i.get("i"));
        /**
         * change int_arr
         */
        Field arr = finalActionClass.getDeclaredField("arr");
        System.out.println("before modify arr: " + arr.get("arr"));
        arr.setAccessible(true);
        int[] arr1 = (int[]) arr.get("arr");
        arr1[0] = 5;
        arr.set(finalAction, arr1);
        System.out.println("after modify arr: " + arr.get("arr"));
        /**
         * change Integer_arr
         */
        Field arg = finalActionClass.getDeclaredField("arg");
        System.out.println("before modify arg: " + arg.get("arg"));
        arg.setAccessible(true);
        arg.set(finalAction, new Integer[]{1, 2, 3, 4});
        System.out.println("after modify arg: " + arg.get("arg"));
    }

    void finalParamChange(final int i, final Long l,
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
        System.out.println("in: " + modifiers);
        modifiers++;
        System.out.println("mod: " + modifiers);
        System.out.println(l);
        //todo modifier ？
    }

    class FinalInner {
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

    public  String getS() {
        return s;
    }

    public int getI() {
        return i;
    }

    public Integer getINTEGER() {
        return INTEGER;
    }

    public int[] getArr() {
        return arr;
    }

    public Integer[] getArg() {
        return arg;
    }

    public FinalInner getFinalInner() {
        return FINAL_INNER;
    }
}
