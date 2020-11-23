package com.company.JavaAdvanced.Stream;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamObject {
    public static void main(String[] args) {
        getStreamObject();
        otherStreamTypes();
        streamForEach();
        filterStream();
        distinctStream();
        limitStream();
    }

    private static void limitStream() {
        LongStream range = LongStream.range(1, 10000);
        //limit range data, fetch only parameterized amount of values
        range
                .limit(100)
                .forEach(System.out::println);
    }

    private static void distinctStream() {
        //Pick distinct values from stream
        IntStream stream = IntStream.of(1, 1, 2, 3, 5, 8, 13, 13, 8);
        stream.distinct().forEach(System.out::println);
    }

    private static void filterStream() {
        IntStream stream = IntStream.of(1,100,12,85,4,36);

        IntPredicate predicate = number -> number < (50);

        IntStream filtered = stream.filter(predicate);
        //Print every integer in stream which smaller than 50
        filtered.forEach(num -> {
            System.out.println(num);
        });

        //for the single usage ->
        List<Integer> integerList = Arrays.asList(1,10,12,64,3,55,123);
        integerList.stream()
                .filter(number -> number > 50)
                .forEach(System.out::println);

    }

    private static void streamForEach() {
        List names = Arrays.asList("Apple","Microsoft","Google","Amazon");
        Stream stream = names.stream();

        //Out every values in stream of names, foreach returns consumer parameter.
        stream.forEach(object -> {
            System.out.println(object);
        });
    }

    private static void otherStreamTypes() {
        IntStream intStream = IntStream.of(1,2,3); //IntStream object including 1,2,3 data
        IntStream intRange = IntStream.range(1,10); //IntStream object including data between range 1-10

        DoubleStream doubleStream = DoubleStream.of(1.0,3.5,6.6);//DoubleStream object including values
        LongStream longStream = LongStream.range(1,100);//LongStream object including data between range 1-100

        longStream.forEach(val -> {
            System.out.println(val);
        });
    }

    private static void getStreamObject() {
        //Step 1 : get a stream object.
        List names = Arrays.asList("Apple","Microsoft","Google","Amazon");
        Stream stream = names.stream();
        Stream parallelStream = names.parallelStream();
    }
}
