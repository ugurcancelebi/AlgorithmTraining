package com.company.HackerRankJavaQuestions;

import java.util.*;

/*
 * Define an ArrayList that including Double variables into a project
 * Order variables by normal amount
 * Order variables by round amount
 * Use comparator interface
 */
class DoubleData implements Comparator<Double>{
    @Override
    public int compare(Double aDouble, Double t1) {
        Double double1 = aDouble - aDouble.intValue();
        Double double2 = t1 - t1.intValue();
        return double1.compareTo(double2);
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
        doubleList.sort(new DoubleData());
        for (Double aDouble : doubleList) System.out.println(aDouble);
    }
}
