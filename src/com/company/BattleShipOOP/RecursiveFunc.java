package com.company.BattleShipOOP;

import java.util.*;

public class RecursiveFunc {
    private static String killCommas(String s){
        //final case, after substring of the loop ended and our length is zero, return nothing
        if (s.length() == 0)
            return "";

        //if our first character is equal to comma, then recurse by its
        //1st character, means that we will ignore comma by that validation
        if (s.charAt(0) == ',')
        {
            return killCommas(s.substring(1));
        }

        //System.out.println(s.charAt(0) + killCommas(s.substring(1)));
        //return first value and recursion of next single value of our string
        return s.charAt(0) + killCommas(s.substring(1));
    }
    private static int sumDigits(int num){
        //if number is equal to zero, return itself
        if (num == 0) {
            return num;
        }
        //if not, then return number and recursion of our number subtract by one
        //method will be called until number is 0 and in every call, number will be added to itself
        //ex, number is 5, add (5 + 5-1) -> (9 + 4-1) -> (12 + 3-1) -> (14 + 2-1) -> (15 + 1-1) = 15;
        else {
            return num + sumDigits(num - 1);
        }
    }
    public static void findPowerSet(int[] arr)
    {
        List<Integer> integerList = new ArrayList<>();
        int size = 0;
        //When we reach at the end of element, will display all variations here.
        if (size == arr.length) {
            System.out.println(integerList);
            return;
        }

        //Recursion will increase until its size reaches to arr.length
        //here we store our data in our integer list.
        integerList.add(arr[++size]);
        findPowerSet(arr);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 10};
        System.out.println(killCommas("a,apple,c ,d"));
        System.out.println(sumDigits(5));
        findPowerSet(arr);
    }
}
