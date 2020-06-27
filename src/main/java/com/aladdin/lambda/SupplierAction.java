package com.aladdin.lambda;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lgc
 */
public class SupplierAction {
    public static void main(String[] args) {
        System.out.println(supplierAction(SupplierAction::getString));
        System.out.println(supplierAction(() -> "sss"));
    }

    static String getString() {
        return Stream.iterate(0, i -> i + 2).limit(5).collect(Collectors.toList()).toString();
    }

    static String supplierAction(Supplier<String> supplier) {
        return supplier.get();
    }
}
