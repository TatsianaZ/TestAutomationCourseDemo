package org.example.java_lambda;

import java.util.function.Supplier;

public class SupplierLambda {
    public static void main(String[] args) {
        Supplier<Double> supplier = () -> Math.random();
        System.out.println(supplier.get());
    }

}
