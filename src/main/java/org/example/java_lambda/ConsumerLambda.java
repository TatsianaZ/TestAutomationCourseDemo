package org.example.java_lambda;

import java.util.function.Consumer;

public class ConsumerLambda {
    public static void main(String[] args) {
        Consumer<String> consumer = (a) -> System.out.println(a.toUpperCase());
        consumer.accept("a");
    }
}
