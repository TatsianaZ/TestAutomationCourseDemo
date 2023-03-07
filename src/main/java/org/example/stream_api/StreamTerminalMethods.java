package org.example.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class StreamTerminalMethods {
    public static void main(String[] args) {

        //findFirst - returns the first element of the stream, or an Optional if the stream is empty
        List<String> values = Arrays.asList("a1", "a11", "a2", "a1", "a4", "a5", "a111");

        String result = values.stream()
                .filter(value -> value.contains("4"))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        System.out.println(result);

        //findAny - returns the first element of the stream, or an Optional if the stream is empty
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        String findAnyResult = words.stream()
                .filter(w -> w.startsWith("c"))
                .findAny()
                .orElseThrow();
        System.out.println(findAnyResult);

        //collect - used to accumulate elements of a stream into a
        //collection or other data structure
        List<String> resultCollecting = values
                .stream()
                .filter(value -> value.contains("1"))
                .collect(Collectors.toList());

        //anyMatch - returns true if condition satisfies for at least one element
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean hasEvenNumber = numbers.stream()
                .anyMatch(n -> n % 2 == 0);
        System.out.println(hasEvenNumber);

        //nonMatch -  returns a boolean indicating whether
        //none of the elements in the stream match a given predicate
        List<Integer> numbers2 = Arrays.asList(1, 3, 5, 7, 9);
        boolean hasEvenNumber2 = numbers2.stream()
                .noneMatch(n -> n % 2 == 0);
        System.out.println(hasEvenNumber2);

        //allMatch - returns true if condition satisfies for all elements
        boolean allMatchResult = values
                .stream()
                .allMatch(value -> value.contains("a"));

        //min - returns min element of the stream
        List<Integer> numbers3 = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);
        int minResult = numbers.stream()
                .min(Integer::compareTo)
                .orElseThrow();
        System.out.println(minResult);

        //min - returns min element of the stream
        List<Integer> numbers4 = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);
        int maxResult = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow();
        System.out.println(maxResult);

        //forEach - applies function to each element of the stream -
        //the order in which the elements are processed is not guaranteed
        //to be the same as the order in which they appear in the stream.

        List<String> values1 = Arrays.asList("a1", "a11", "a2", "a1", "a4", "a5", "a111");
        //filter - Collect values which contain "1"
        values.stream()
                .filter(value -> value.contains("1"))
                .forEach(System.out::println);

        //forEachOrdered - processes the elements of the stream in the order
        //in which they appear in the stream. This means that the order of the elements is preserved,
        //even if the stream is processed in parallel.
        values.stream()
                .filter(value -> value.contains("1"))
                .forEachOrdered(System.out::println);

        //toArray - allows to convert the elements in a stream into an array
        List<Integer> numbers5 = Arrays.asList(3, 1, 4, 1, 5, 9);
        // Create an array of Integer objects
        Integer[] arr1 = numbers5.stream()
                .toArray(Integer[]::new);
    }
}
