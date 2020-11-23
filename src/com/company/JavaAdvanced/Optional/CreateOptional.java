package com.company.JavaAdvanced.Optional;

import java.util.Optional;

public class CreateOptional {
    public static void main(String[] args) {
        initOptional();
        initIfPresent();
        initMap();
    }

    private static void initMap() {
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
