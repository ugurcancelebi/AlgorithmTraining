package com.company.OOP.Example10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class Person {
    private String name;

    public Person() {
    }
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "I am " + name;
    }
}

class Test
{
    public static void main(String[] args){
        ArrayList<Person> personList = new ArrayList<>();
        Person[] person = new Person[5];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                personList.add(new Person(line));
            }
            for (int i = 0 ; i < 5 ; i++){
                person[i] = personList.get(i);
                System.out.println(person[i].toString());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
