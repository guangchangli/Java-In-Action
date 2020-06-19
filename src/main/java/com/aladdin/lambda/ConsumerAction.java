package com.aladdin.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author lgc
 */
public class ConsumerAction {
    public static void main(String[] args) {
        String string = "redis";
//        acceptAction(string, (s) -> System.out.println(new StringBuffer(s).reverse()));
        andThenAction(string, a -> System.out.println(a.toUpperCase()), b -> System.out.println(b.toLowerCase()));
        List<String> strings = Arrays.asList("1", "2");
        strings.add("2");
        System.out.println(strings);
    }

    static void acceptAction(String string, Consumer<String> consumer) {
        consumer.accept(string);
    }

    static void andThenAction(String s, Consumer<String> s1, Consumer<String> s2) {
//      s1.accept(s);
//      s2.accept(s);
        s1.andThen(s2).accept(s);
    }

    static void test(final int a, final String s, final Bac bac, final Long l, final int[] arr, final Integer[] arg){
        //do something
    }

    static class Bac {
        String name;
    }

}
