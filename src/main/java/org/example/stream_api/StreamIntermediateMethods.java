package org.example.stream_api;

import org.example.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamIntermediateMethods {
    public static void main(String[] args) {
        List<String> values = Arrays.asList("a1", "a11", "a2", "a1", "a4", "a5", "a111");

        //filter - Collect values which contain "1"
        List<String> resultFilter = values
                .stream()
                .filter(value -> value.contains("1"))
                .collect(Collectors.toList());
        System.out.println(resultFilter);

        //skip - list that contains all the strings in the original list except the first two
        List<String> resultSkip = values.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(resultSkip);

        //distinct - returns unique values
        List<String> resultDistinct = values.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(resultDistinct);

        //map - updates each element of the stream - adding "_1" to each value example
        List<String> resultMap = values.stream()
                .map(value -> value.concat("_1"))
                .collect(Collectors.toList());
        System.out.println(resultMap);

        //peek()
        //does not modify the original stream, but instead allows you
        //to perform some side effect on each element of the stream
        //without changing the stream itself

        List<String> newList = values.stream()
                .peek(System.out::println)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        //limit - allows you to limit the size of the stream to a specified
        // number of elements
        List<String> resultLimit = values.stream()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(resultLimit);

        //sorted - sorts elements
        List<String> resultSorted = values.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(resultSorted);

        //mapToInt, //mapToDouble, //mapToLong
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        DoubleStream intStream = strings.stream()
                .mapToDouble(Double::parseDouble);
        intStream.forEach(System.out::println);

        //flatMap - allows to flatten a stream of collections or arrays
        //into a single stream
        //Before flattening 	: [[1, 2, 3], [4, 5], [6, 7, 8]]
        //After flattening 	: [1, 2, 3, 4, 5, 6, 7, 8]

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(collection -> collection.stream())
                .collect(Collectors.toList());
        System.out.println(flattenedList);

        // Creating a List of Strings
        List<String> list = Arrays.asList("Geeks", "GFG",
                "GeeksforGeeks", "gfg");

        // Using Stream flatMap(Function mapper)
        List<Character> resultFlatMap = list.stream()
                .flatMap(str -> Stream.of(str.charAt(2)))
                .collect(Collectors.toList());
        System.out.println(resultFlatMap);
    }
}
