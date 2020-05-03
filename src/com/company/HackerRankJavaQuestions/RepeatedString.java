package com.company.HackerRankJavaQuestions;

import java.io.*;
import java.util.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        StringBuilder builder = new StringBuilder().append(s);
        int in = 0;
        int loc = 0;
        long aCount = 0;
        long size = s.length();
        while (in < (n-size)){
            loc++;
            builder.append(s.charAt(loc));
            if (loc >= 4){
                loc = 0;
            } in++;
        }
        String string = builder.toString();
        char[] ch = string.toCharArray();
        for (char chr : ch){
            if (chr == 'a')
                aCount++;
        }
        return aCount;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = "acaba";
        long n = 1000000;
        System.out.println(repeatedString(s, n));
    }
}
