package com.company.OOP.Example6;

import java.time.LocalDate;

public class MeansOfMovement {
    public static void main(String[] args) {

    }
}
class Airplane extends MeansOfMovement implements Comparable{
    public LocalDate localDate;

    public LocalDate getLocalDate() {
        return localDate.plusMonths(3);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
class Ship extends MeansOfMovement implements Comparable{
    public LocalDate localDate;

    public LocalDate getLocalDate() {
        return localDate.plusWeeks(1);
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
