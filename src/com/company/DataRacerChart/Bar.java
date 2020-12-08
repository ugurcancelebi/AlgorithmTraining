package com.company.DataRacerChart;

public class Bar implements Comparable<Bar> {
    private final String name;
    private final int value;
    private final String category;

    public Bar(String name, int value, String category) {
        if (name == null) throw new IllegalArgumentException("Name is null");
        if (value < 0) throw new IllegalArgumentException("Value is negative");
        if(category == null) throw new IllegalArgumentException("category is null");

        this.name = name;
        this.value = value;
        this.category = category;

    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }

    public int compareTo(Bar that) {
        if (that == null) throw new NullPointerException("The input argument is null.");

        return Integer.compare(this.value, that.value);
    }

}