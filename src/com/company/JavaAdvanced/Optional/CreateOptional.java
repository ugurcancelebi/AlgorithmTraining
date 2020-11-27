package com.company.JavaAdvanced.Optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateOptional {
    public static void main(String[] args) {
        initOptionalList();
        initOptionalWithStream();
    }

    private static void initOptionalWithStream() {
        List<Optional<String>> data = Arrays.asList(Optional.ofNullable(null)
                ,Optional.empty()
                ,Optional.of("ABDC")
                ,Optional.of("DEFG")
                ,Optional.of("AAA")
                ,Optional.of("DEFG"));

        List<String> val = data.stream()
                .filter(Optional::isPresent)
                .flatMap(x -> x.map(Stream::of).orElseGet(Stream::empty))
                .collect(Collectors.toList());
        val.forEach(System.out::println);
    }

    private static void initOptionalList() {
        List<Optional<Integer>> optionalList = Arrays.asList(Optional.of(1),
                Optional.of(2),
                Optional.of(3),
                Optional.ofNullable(null),
                Optional.empty(),Optional.of(3));

        Set<Integer> set  = optionalList
                .stream()
                .filter(number -> number.isPresent())
                .flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty))
                .collect(Collectors.toSet());

        set.forEach(System.out::print);
    }

    private static void initIfPresent() {
        Integer num = null;
        Optional<Integer> optionalInteger = Optional.ofNullable(num);

        optionalInteger.ifPresent(number -> {
            double square = Math.pow(number,2);
            System.out.println("Result : " + square);
        });
    }

    private static void initOptional() {
        Optional<Double> empty = Optional.empty();
        Optional<String> stringOptional = Optional.of("Hello");
        //Optional<String> ofNull = Optional.of(null); //will throw exception
        Optional<String> ofNotNull = Optional.ofNullable(null); //this can take null parameter
    }
}
