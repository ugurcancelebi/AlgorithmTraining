package com.company.DataStructures;

import java.util.*;

/*
 * Define an ArrayList that including Double variables into a project
 * Order variables by normal amount
 * Order variables by round amount
 * Use comparator interface
 */
class DoubleData extends Comparator<Double> {

    @Override
    public int compare(Object o, Object t1) {
        return 0;
    }
}
public class ComparatorExample {
    public static void main(String[] args) {
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(12.3);
        doubleList.add(0.9);
        doubleList.add(22.19);
        doubleList.add(10.2);
        Collections.sort(doubleList);
        for (Double num : doubleList){
            System.out.println(num);
        }
        doubleList.sort((java.util.Comparator<? super Double>) new DoubleData());
        for (Double aDouble : doubleList) System.out.println(aDouble);
    }
}
