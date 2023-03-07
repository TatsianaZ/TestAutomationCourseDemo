package org.example.stream_api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) throws IOException {

        //Создание потока из коллекции
        List<String> values = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        Stream<String> streamFromCollection = values.stream();

        //Создание потока из значений
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");

        //Создание потока из массива
        String[] array = {"a1", "a2", "a3"};
        Stream<String> streamFromArray = Arrays.stream(array);

        //Создание потока из файла
        Stream<String> streamFromFile = Files.lines(Paths.get("file.txt"));

        //Создание стрима из строки
        IntStream streamFromString = "123".chars();
    }
}
