package org.example.stream_api;

import org.example.model.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPITask {
    private static List<Person> initPersons() {
        return Arrays.asList(
                new Person("Alex", 18, ""),
                new Person("Oleg", 16, "Lida"),
                new Person("Kate", 25, "Vilnus"),
                new Person("Mike", 45, "Berlin"),
                new Person("Liza", 29, "Grodno"));
    }

    public static void main(String[] args) {
        List<Person> peoples = initPersons();
        //Вернуть отсортированный по возрасту спикок Person
        List<Person> sortedByEdgePersons = peoples.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        System.out.println(sortedByEdgePersons);

        //Сортировка списка по нескольким свойствам: age, name, address.
        List<Person> sortedPersons = peoples.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getName)
                        .thenComparing(Person::getAddress))
                .collect(Collectors.toList());
        System.out.println(sortedPersons);

        //Вернуть самого молодого Person
        Person person1 = peoples.stream()
                .min(Comparator.comparing(Person::getAge))
                .orElseThrow();
        System.out.println(person1);

        //Вернуть совершеннолетних Person
        List<Person> adultPersons = peoples.stream()
                .filter(person -> person.getAge()>=18)
                .collect(Collectors.toList());
        System.out.println(adultPersons);

        //Вывести имена всех Person на консоль
        peoples.stream().forEach(person -> System.out.println(person.getName()));

        //Собрать адреса всех Person в отдельную коллекцию
        List<String> addresses = peoples.stream()
                .map(Person::getAddress)
                .collect(Collectors.toList());
        System.out.println(addresses);

        //В адрес каждого Person добавить приставку _city
        peoples
                .stream()
                .forEach(person -> person.setAddress(person.getAddress().concat("_city")));
        System.out.println(peoples);

        //option2
        List<Person> updatedPersons = peoples.stream()
                .map(person -> new Person(person.getName(), person.getAge(), person.getAddress().concat("_city")))
                .collect(Collectors.toList());
        System.out.println(updatedPersons);

        //Вывести имена несовершеннолетних людей
        List<String> yangPersons = peoples.stream()
                .filter(person -> person.getAge()<18)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(yangPersons);

        //Узнать количество совершеннолетних людей
        long adultPersonsCount = peoples
                .stream()
                .filter(person -> person.getAge()>=18)
                .count();
        System.out.println(adultPersonsCount);

        boolean isAddressHasEachPerson = peoples.stream()
                .allMatch(person -> !person.getAddress().equals("") && !person.getAddress().equals(null));
        System.out.println(isAddressHasEachPerson);

        //Вывести трех последних людей
        peoples.stream().skip(2).forEach(System.out::println);

        //Вывести двоих людей
        peoples.stream().limit(2).forEach(System.out::println);
    }
}
