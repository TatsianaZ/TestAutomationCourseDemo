package org.example.java_lambda;

import java.util.function.Predicate;

public class PredicateLambda {
    public static void main(String[] args) {
        Predicate<String> predicate = (a) -> a.contains("a");
        System.out.println(predicate.test("mama"));
    }
}
