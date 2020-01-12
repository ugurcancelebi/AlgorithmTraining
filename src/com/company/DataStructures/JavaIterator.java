package com.company.DataStructures;

import java.util.*;

public class JavaIterator {
    public static void main(String[] args) {
        listIterator();
        hashSetIterator();
        removeIterator();
    }
    private static void hashSetIterator(){
        Hashtable<Integer,String> hashtable = new Hashtable<>();
        hashtable.put((Integer)2,"Second");hashtable.put(3,"Third");
        hashtable.put(4,"Fourth");hashtable.put(1,"First");
        Set<Map.Entry<Integer,String>> set = hashtable.entrySet();
        for (Map.Entry<Integer, String> entry : set) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    private static void listIterator(){
        List<Integer> integerList = new ArrayList<>();
        ListIterator<Integer> listIterator;
        for (int i = 0; i<5;i++)
            integerList.add(i);
        listIterator = integerList.listIterator();
        while (listIterator.hasPrevious())
            System.out.println(listIterator.previous());
    }
    private static void removeIterator(){
        Integer[] numberList= {2,3,4,1,88,12,4,-3,5,11,8,6,34};
        Vector<Integer> integerVector = new Vector<>(Arrays.asList(numberList));
        Iterator iterator = integerVector.iterator();
        while (iterator.hasNext()){
            Integer count = (Integer)iterator.next();
            System.out.println(count);
            if (count > 0){
                iterator.remove();
            }
        }
        System.out.println("Updated Vector is :");
        System.out.println(integerVector);
    }
}
