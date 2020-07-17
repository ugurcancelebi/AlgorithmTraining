package com.company.HackerRankJavaQuestions;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;


class SortedSum {

    /*
     * Complete the 'sortedSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int sortedSum(List<Integer> a) {
        int total  = 0;
        int subTotal = 0;

        for (int i = 1;i < a.size()+1 ;i++){
            if (a.get(i) != null) {
                if (a.get(i - 1) > a.get(i)) {
                    int temp = a.get(i - 1);
                    a.set(i - 1, a.get(i));
                    a.set(i, temp);
                }
            }
            for (int j = 1;j <= i; j++) {
                int number = a.get(j-1) * j;
                subTotal += number;
            }
            total += subTotal;
            subTotal=0;
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(9);
        integerList.add(5);
        integerList.add(8);
        System.out.println(sortedSum(integerList));
    }

}
