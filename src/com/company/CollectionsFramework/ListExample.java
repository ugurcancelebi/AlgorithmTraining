package com.company.CollectionsFramework;

import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        initArrayList();
        initLinkedList();
        initVector();

    }

    private static void initVector() {
        Double[] array = {3.2,2.5,4.2,0.8};
        Vector<Double> vector = new Vector<>(Arrays.asList(array));
        for (Double aDouble : vector) {
            System.out.println(aDouble);
        }
    }

    private static void initLinkedList() {
        LinkedList<String> filmler = new LinkedList<>();
        filmler.add("Person of Interest");
        filmler.add("Black Books");
        filmler.add("Seinfeld");
        filmler.add("Fargo");

        // İstediğimiz index'e eleman ekliyoruz.C
        filmler.add(4, "Akasya Durağı");
        
        System.out.print("LinkedList -> ");
        filmler.forEach(film -> System.out.print(film + " "));
    }

    private static void initArrayList() {
        String[] listArray = {"Apple","Banana","Strawberry","Kiwi","Pineapple"};
        ArrayList<String> arrList = new ArrayList<>(Arrays.asList(listArray));
        arrList.add(3,"Pineapple");
        arrList.add("Pear");
        arrList.remove(0);
        arrList.forEach(val -> System.out.print("->" + val));
    }
}
