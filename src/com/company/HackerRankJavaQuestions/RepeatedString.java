package com.company.HackerRankJavaQuestions;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long numOfChar = 0 ;
        int numOfA = 0;
        int stringLength = s.length();
        if(stringLength > 0){
            for(int i=0;i<stringLength;i++){
                if(s.charAt(i)=='a'){
                    numOfA++;
                }
            }
            long division = n / stringLength;
            long mod = n % stringLength;
            numOfChar = division * numOfA;
            for(int i=0;i<mod;i++){
                if(s.charAt(i)=='a'){
                    numOfChar++;
                }
            }
        } return numOfChar;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = "acaba";
        BigInteger n = new BigInteger("1000000000000");
        System.out.println(repeatedString(s, n.intValue()));
    }
}
