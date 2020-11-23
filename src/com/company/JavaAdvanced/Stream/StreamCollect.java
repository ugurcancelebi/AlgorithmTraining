package com.company.JavaAdvanced.Stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCollect {
    public static void main(String[] args) {
        collectorsInit();
        mapInit();
        reduceStream();
    }

    private static void reduceStream() {
        int result = IntStream.rangeClosed(1,5)
                .reduce(1,(prev,next) -> {
                    System.out.format("%d - %d %n",prev,next);
                   return prev + next;
                });
        System.out.println(result);

        //lambda
        System.out.println(IntStream.of(1,2,3,4,5,6).reduce(1,(prev,next) -> prev * next));

        //method reference
        System.out.println(IntStream.of(1,2,3,4,5).reduce(1,Math::multiplyExact));
    }

    private static void mapInit() {
        //For Strings
        List<String> list = Arrays.asList("Ali","Veli","Murat","Ahmet");
        Stream uppercase = list.stream().map(name -> name.toUpperCase());
        uppercase.forEach(System.out::println);

        //For Integers
        IntStream.rangeClosed(1,5).map(n -> n*n).forEach(System.out::println);
    }

    private static void collectorsInit() {
        List names = Arrays.asList("Ali", "Veli", "Selami", "Veli", "Selami", "Can", "Hüseyin");

        List list = (List) names.stream().collect(Collectors.toList());

        Set set = (Set) names.stream().collect(Collectors.toSet());

        Long count = (Long) names.stream().collect(Collectors.counting());

        String collect = (String) names.stream().collect(Collectors.joining(" / "));

        //Map<Integer, List> integerListMap = names.stream().collect(Collectors.groupingBy(name -> name.length()));

        list.forEach(System.out::println);
        System.out.println(count);
        System.out.println(collect);
        set.forEach(System.out::print);
    }
}
