package com.company.OOP.Example5;

public class Person {
    String name;
    int birthYear;
    long licenseID;

    public Person(String name, int birthYear, long licenseID) {
        this.name = name;
        this.birthYear = birthYear;
        this.licenseID = licenseID;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public long getLicenseID() {
        return licenseID;
    }
}
