package com.company.JavaAdvanced.Stream;

import java.util.Arrays;
import java.util.List;

public class StreamMapReduce {
    public static void main(String[] args) {
        Person p1 = new Person("Ahmet", 12);
        Person p2 = new Person("Ali", 20);
        Person p3 = new Person("Ayşe", 30);
        Person p4 = new Person("Murat", 51);
        Person p5 = new Person("Zeynep", 60);

        List personList = Arrays.asList(p1, p2, p3, p4, p5);

        /*personList
                .stream()
                .map(p -> p.getAge())
                .map(Double::valueOf)
                .reduce(0, (a, b) -> (a + b)/2);
*/
    }
}
class Person{
    String name;
    Integer number;

    public Person(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}