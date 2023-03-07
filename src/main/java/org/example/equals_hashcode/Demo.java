package org.example.equals_hashcode;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
      /*  Map<Integer, String> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        map.put(1, "a");
        map.put(1, "b");

        set.add(1);
        set.add(1);*/

        Map<Person, String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();
        Person person1 = new Person("Alex", 18);
        Person person2 = new Person("Alex", 18);

        map.put(person1, "a");
        map.put(person2, "b");

       /* set.add(person1);
        set.add(person1);
*/
        System.out.println("map: " + map);
      //  System.out.println("set: " + set);
    }

    public static class Person {
        private String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
