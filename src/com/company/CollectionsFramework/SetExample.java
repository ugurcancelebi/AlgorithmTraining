package com.company.CollectionsFramework;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        initHashSet();
        initLinkedHashSet();
        initTreeSet();
    }

    private static void initTreeSet() {
        String[] arr = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        TreeSet<String> treeSet = new TreeSet<>(Arrays.asList(arr));
        treeSet.forEach(val -> System.out.print("->" + val));

        //for integer
        Integer[] array = {3,5,6,7,8,9,1};
        TreeSet<Integer> integers = new TreeSet<>(Arrays.asList(array));
        integers.forEach(num -> System.out.print("->" + num));
    }

    private static void initLinkedHashSet() {
        LinkedHashSet<String> gunler = new LinkedHashSet<>();
        gunler.add("Pazartesi");
        gunler.add("Salı");
        gunler.add("Çarşamba");
        gunler.add("Perşembe");
        gunler.add("Cuma");
        gunler.add("Cumartesi");
        gunler.add("Pazar");

        // Aynı elementten tekrar kaydediyoruz.
        // Tekrarlı element sıralamayı değiştirmeyecek.
        gunler.add("Pazartesi");

        System.out.print("LinkedHashSet -> ");
        gunler.forEach(gun -> System.out.print(gun + " "));
        System.out.println();
    }

    private static void initHashSet() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hello");
        hashSet.add("World");
        hashSet.add("I'm");
        hashSet.add("Programmer");
        hashSet.add(null);
        hashSet.add(null);

        hashSet.forEach(System.out::print);
    }
}
