package com.company.JavaAdvanced.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
       unit1();
       unit2();
       unit3();
       unit4();
       unit5();
       unit6();
    }

    private static void unit6() {
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);

        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfListOfInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

        System.out.println("Before flattening" + listOfListOfInts);

        List<Integer> flattened = listOfListOfInts.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println(flattened);
        flattened.forEach(var -> System.out.print(" " + var));
    }

    private static void unit5() {
        List<String> list = Arrays.asList("Geeks", "GFG",
                "GeeksforGeeks", "gfg");
        list.stream().map(x -> x.charAt(2)).forEach(System.out::print);
        list.stream().flatMap(x -> Stream.of(x.charAt(2))).forEach(System.out::print);
    }

    private static void unit4() {
        List<String> houseGryffindor = Arrays.asList("Albus", "Harry", "Ron", "Hermione");
        List<String> houseHufflepuff = Arrays.asList("Bridget", "Cedric", "Nymphadora");
        List<String> houseRavenclaw = Arrays.asList("Luna", "Garrick", "Filius");
        List<String> houseSlytherin = Arrays.asList("Severus", "Tom", "Phineas");

        List<List<String>> hogwarts = new ArrayList<>();
        hogwarts.add(houseGryffindor);
        hogwarts.add(houseHufflepuff);
        hogwarts.add(houseRavenclaw);
        hogwarts.add(houseSlytherin);

        Set<String> set = hogwarts.stream().flatMap(x -> x.stream()).filter(x -> x.startsWith("A")).collect(Collectors.toSet());
        set.forEach(System.out::println);
    }

    private static void unit3() {
        Integer[] array = {1,2,3,4,5};
        List<Integer> streamArray = Arrays.asList(array);
        streamArray.forEach(System.out::print);
    }

    private static void unit2() {
        Student obj1 = new Student();
        obj1.setName("test");
        obj1.addBook("1");
        obj1.addBook("2");
        obj1.addBook("3");
        Student obj2 = new Student();
        obj2.setName("test2");
        obj2.addBook("4");
        obj2.addBook("5");
        obj2.addBook("6");

        List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);

        List<String> collected = list.stream()
                .map(x -> x.getBook())
                .flatMap(x -> x.stream())
                .distinct()
                .filter(x -> x.equals("5"))
                .collect(Collectors.toList());

        collected.forEach(System.out::print);
    }

    private static void unit1() {
        String[][] data = new String[][]{{"a","b"},{"c","d"},{"e","f"}};
        Stream<String> stream = Arrays.stream(data).flatMap(x -> Arrays.stream(x))
                .filter(x -> x.equals("a"));

        stream.forEach(System.out::println);
    }
}
class Student {

    private String name;
    private Set<String> book;

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }
    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBook() {
        return book;
    }

    public void setBook(Set<String> book) {
        this.book = book;
    }
}