package com.company.AlgorithmTraining;

import java.util.*;

public class test {
    public static int minDiff(List<Integer> arr) {
        int totalSum = 0;
        Map<Integer,Integer> counts = new HashMap<>();
        Collections.sort(arr);
        Set keys = counts.keySet();
        for (int i = 0;i<arr.size()-1;i++){
            counts.put(arr.get(i),arr.get(i+1));
        }
        for (Iterator<Integer> it = keys.iterator(); it.hasNext(); ) {
            Integer f = it.next();
            for (int num : counts.keySet()){
                totalSum += f - num;
            }
        }
        return totalSum;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(1);
        arr.add(4);
        arr.add(7);
        arr.add(3);
        System.out.println(minDiff(arr));
    }
}
