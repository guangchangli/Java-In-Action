package com.aladdin.lambda;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author lgc
 */
public class PredicateAction {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("c", "go", "c++", "java", "redis", "mongodb");
        System.out.println("-----test-----");
        filterAndOut(list, s -> s.length() > 3);
        System.out.println("-----negate-----");
        negateAction(list, s -> s.length() > 4);
        System.out.println("----or---");
        orAction(list, s -> s.length() < 3);
        System.out.println("----equals----");
        equalAction(list, Predicate.isEqual("redis"));
        System.out.println(Predicate.isEqual("ss").test("sss"));
        String[] s = {"1", "2", "3"};
        filterAndOut(Arrays.asList(s),(s1)->{
                    return false;
                }
        );
    }

    static void filterAndOut(List<String> list, Predicate<String> predicate) {
        list.stream().filter(predicate.and(s -> s.length() < 5)).forEach(System.out::println);
    }

    static void negateAction(List<String> list, Predicate<String> predicate) {
        list.stream().filter(predicate.negate()).forEach(System.out::println);
    }

    static void orAction(List<String> list, Predicate<String> predicate) {
        list.stream().filter(predicate.or(s -> s.length() > 4)).forEach(System.out::println);
    }

    static void equalAction(List<String> list, Predicate<String> predicate) {
        list.stream().filter(predicate).forEach(System.out::println);
    }
}
