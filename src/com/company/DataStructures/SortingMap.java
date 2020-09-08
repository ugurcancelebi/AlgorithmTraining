package com.company.DataStructures;

import java.util.*;

class Compare1 extends Comparator<Number> {
    private Map<String,Double> map;
    Compare1(Map<String,Double> map1) {
        this.map = map1;
    }
    @Override
    public int compare(Object o, Object t1) {
        return map.get(o).compareTo(map.get(t1));
    }
}
public class SortingMap {
    public static void main(String[] args) {
        HashMap<String ,Double> hashMap = new HashMap<>();
        Compare1 comparator = new Compare1(hashMap);
        hashMap.put("FirstVal",1.0);
        hashMap.put("ThirdVal",3.0);
        hashMap.put("SecondVal",2.0);
        System.out.println("Unordered MAP : ");
        for (String key : hashMap.keySet()){
            System.out.print("Key : " + hashMap.get(key) + " Val : " + key);
        }
        TreeMap<String,Double> sortingTree = new TreeMap<String ,Double>((java.util.Comparator<? super String>) comparator);
        sortingTree.putAll(hashMap);
        System.out.println("\n Ordered MAP :");
        for (String key : sortingTree.keySet()){
            System.out.print("Key : "+ sortingTree.get(key) + " Val : " + key);
        }
    }
}