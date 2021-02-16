package com.company.OOP.Example4;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PinguStreams {

    public static String path = "penguins.csv";

    public static Stream<String> lines() {
      return Stream.empty();
    }

    public static Stream<Penguin> penguins() {
        Stream<String> line1 = lines();
        return (Stream<Penguin>) line1.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
    }

    public static Stream<Penguin> filter(Stream<Penguin> stream, String field, String value) {
        return stream
                .filter(penguin -> penguin.get(field).equals(value))
                .sorted();
    }
    public static double getAverage(Stream<Penguin> stream, String field) {
        return stream
                .mapToDouble(penguin -> penguin.getDouble(field))
                .average()
                .orElse(0d);
    }

    public static Stream<String> getFeature(Stream<Penguin> stream, String field) {
        return stream.map(p -> p.get(field));
    }

    public static double getAverageOfSpecies(String species, String feature) {
        Stream<Penguin> penguins = filter(penguins(), "species", species);
        return getAverage(penguins, feature);
    }

    public static double distance(Penguin penguin, String species) {
        double avgBillLen = getAverageOfSpecies(species, "bill_length_mm");
        double avgFlipperLen = getAverageOfSpecies(species, "flipper_length_mm");
        double billLen = penguin.getDouble("bill_length_mm");
        double flipperLen = penguin.getDouble("flipper_length_mm");
        return (Math.abs(avgBillLen - billLen) + Math.abs(avgFlipperLen - flipperLen))/2;
    }

    public static String classifyPenguin(Penguin penguin) {
        double min = Double.MAX_VALUE;
        String classifiedSpecies = "";
        String[] ar = {"Adelie", "Gentoo", "Chinstrap"};
        for (String species: ar) {
            double d = distance(penguin, species);
            if (min > d) {
                min = d;
                classifiedSpecies = species;
            }
        }
        return classifiedSpecies;
    }

    public static void main(String[] args) {
        String[] pingu = "Chinstrap,Dream,50.9,17.9,196,3675,female,2009".split(",");
        System.out.println(classifyPenguin(new Penguin(pingu)));
        System.out.println(accuracy());
    }

    public static double accuracy() {
        return penguins()
                .filter(p -> !p.get("bill_length_mm").equals("NA") && !p.get("flipper_length_mm").equals("NA"))
                .map(p -> p.get("species").equals(classifyPenguin(p)))
                .mapToDouble(p -> p?1:0)
                .average()
                .orElse(0);
    }

}