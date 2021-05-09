package com.company.HackerRankJavaQuestions;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    public static int sortedSum(List<Integer> a) {
        int totalSum = 0;
        a.sort((integer, t1) -> t1-integer);//asc
        System.out.println(a);
        for(int i = a.size(); i > 0 ;i--){
            int sumVal = 0;
            for (int j = 0;j < i ;j++){
                sumVal += ((1+j) * a.get(j));
            }
            totalSum += sumVal;
        }
        return totalSum;
    }
}
public class SortedSum {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Arrays.asList(4,3,2,1);
        System.out.println(Result.sortedSum(a));
        //for (int i = 0; i < aCount; i++) {
       //     int aItem = Integer.parseInt(bufferedReader.readLine().trim());
       //     a.add(aItem);
       // }

       // int result = Result.sortedSum(a);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

       // bufferedReader.close();
        //bufferedWriter.close();
    }
}
