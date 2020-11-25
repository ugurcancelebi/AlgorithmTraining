package com.company.BasicJava;

import java.util.*;
class Rating{
    private int points;
    private String review;

    public Rating(int points, String review) {
        this.points = points;
        this.review = review;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
public class PaperSheet {
    public static void main(String[] args) {
        initReduce1();
        initReduce2();
        initReduce3();
        initReduce4();
        initReduce5();
    }

    private static void initReduce5() {
        
    }

    private static void initReduce4() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int divider = 2;
        int result = numbers.stream().reduce(0, (a,b) ->{
            try {
                System.out.format("%d %d %n",a ,b);
                System.out.println(a/divider + b/divider);
                return a/divider + b/divider;
            }catch (ArithmeticException e){
                e.printStackTrace();
            }
            return 0;
        });
        System.out.println(result);
    }

    private static void initReduce3() {
        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35),new User("Ab",23));
        int result = users.stream()
                .reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);

        System.out.println(users.stream().mapToInt(user -> user.getAge()).sum());
        System.out.println(result);
    }

    private static void initReduce2() {
        List<String> values = Arrays.asList("Abc","Def","Ghj","Ikl");
        String concat = values.stream()
                .reduce("T" ,(before,after)-> {
                    System.out.println("-->" + before + " " + after);
                    return before + after;
        });
        System.out.println(concat);
    }

    private static void initReduce1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = numbers
                .stream()
                .reduce(1, (subtotal, element) -> {
                    System.out.format("%d %d %n", subtotal, element);
                    return subtotal * element;
                });
        System.out.println(result);
    }

    private static void removeDuplicates() {
        Integer[] arr1 = new Integer[] { 1, 9, 8, 7, 7, 8, 9 };
        List<Integer> listDup = Arrays.asList(arr1);
        listDup.stream().distinct().sorted().forEach(System.out::print);
    }

    private static void sortArrayAndConvertToStream() {
        Integer[] arr = {2,3,1,3,4,2,5,6};
        List<Integer> integerList = Arrays.asList(arr);
        Collections.sort(integerList);
        integerList.stream().forEach(val -> System.out.print("->" + val));
    }

    private static void initFlatMap() {
        List<List<String>> list = Arrays.asList(
                 Arrays.asList("Mehmet","Surur")
                ,Arrays.asList("Ugurcan","Celebi")
                ,Arrays.asList("Rabia","Celebi"));

        list.stream().flatMap(name -> name.stream())
                .map(String::toUpperCase)
                .filter(name -> name.startsWith("C"))
                .forEach(System.out::println);
    }

    private static void initFilter() {
        //Write a Java 8 program to square the
        //list of numbers and then filter out the numbers greater
        //than 100 and then find the average of the remaining numbers?
        List<Integer> list = Arrays.asList(100,50,25,10,2,7);
        list.stream().mapToInt(i -> i).filter(i-> i < 100).forEach(System.out::print);
    }

    private static void printSum() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(1);
        list.add(0);
        int number = list.stream().mapToInt(i -> i).sum();
        System.out.println(number);
    }

    private static void printRandomNumbers() {
        Random random = new Random();
        random.ints().limit(5).sorted().forEach(System.out::println);
    }

    private static void initArray() {
        String[] arr = {"asd","xcz","fed","rtd"};
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        Collections.sort(list);
        list.forEach(var -> System.out.print("->" + var));

        System.out.println();
        Collections.reverse(list);
        list.forEach(var -> System.out.print("->" + var));
    }
}
