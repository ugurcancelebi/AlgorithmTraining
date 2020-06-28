package com.company.HackerRankJavaQuestions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagram {
    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        List<Integer> integerList = new ArrayList<>();
        int count = 0;
        for (String s : query) {
            for (String value : dictionary) {
                char[] queryArr = s.toCharArray();
                char[] dictArr = value.toCharArray();
                Arrays.sort(dictArr);
                Arrays.sort(queryArr);
                if (Arrays.equals(dictArr, queryArr)) {
                    count++;
                }
            }
            integerList.add(count);
            count = 0;
        }
        return integerList;
    }
    public static void main(String[] args){
        List<String> dictionary = new ArrayList<>();
        dictionary.add("listen");
        dictionary.add("tow");
        dictionary.add("lisent");
        dictionary.add("two");
        dictionary.add("abc");
        dictionary.add("no");
        dictionary.add("on");

        List<String> query = new ArrayList<>();
        query.add("two");
        query.add("bca");
        query.add("no");
        query.add("listen");


        List<Integer> integerList = stringAnagram(dictionary,query);

        for (int i : integerList){
            System.out.println(i);
        }

    }

}
