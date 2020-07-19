package com.company.HackerRankJavaQuestions;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RotateArrayLeft {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        d = d % a.length;
        int [] b = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            // 0 -> a.length - d
            // 1 -> 1 + a.length - d
            int j = (i+a.length-d)%a.length;
            b[j] = a[i];
        }
        return b;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] a = {1,2,3,4,5};
        int[] neva = rotLeft(a,1);
        for (int ar:neva)
            System.out.println(ar);
    }
}
