package org.example.java_lambda;

import java.util.function.Function;

public class FunctionLambda {
    public static void main(String[] args) {
        Function<String, Integer> stringToInteger = (a) -> Integer.parseInt(a);
        Integer result = stringToInteger.apply("2");
        System.out.println("result: " + result);
    }
}
