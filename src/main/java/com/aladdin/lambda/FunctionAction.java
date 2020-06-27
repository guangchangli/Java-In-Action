package com.aladdin.lambda;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lgc
 */
public class FunctionAction {
    public static void main(String[] args) {
        String input = "Apache Dubbo";
        String collect = Stream.of(input).
                map(FunctionAction::lowerToUpperFunction).collect(Collectors.joining());
        System.out.println(collect);
        functionAction(FunctionAction::lowerToUpperFunction, "MeiTuan");
        System.out.println(composedAction(s -> s + " end", "COMPOSE"));
    }

    static String lowerToUpperFunction(String input) {
        System.out.println(input.toUpperCase());
        return input.toUpperCase();
    }

    static String toLowerFunction(String input) {
        System.out.println(input.toLowerCase());
        return input.toLowerCase();
    }

    static String functionAction(Function<String, String> function, String s) {
        return function.andThen(FunctionAction::toLowerFunction).apply(s);
    }

    static String composedAction(Function<String, String> function, String s) {
        return function.compose(FunctionAction::toLowerFunction).apply(s);
    }
}
