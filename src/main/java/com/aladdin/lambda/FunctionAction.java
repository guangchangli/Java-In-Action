package com.aladdin.lambda;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lgc
 */
public class FunctionAction {
    public static void main(String[] args) {
        String input="Apache Dubbo";
        String collect = Stream.of(input).
                map(FunctionAction::lowerToUpperFunction).collect(Collectors.joining());
        System.out.println(collect);
    }
    static String lowerToUpperFunction(String input){
        return input.toUpperCase();
    }
}
