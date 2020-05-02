package com.company.Arrays;

import java.util.Arrays;

public class FindMissingNumberFromArray {
    /*
    * Find missing number from array:
    * Input : { 1,2,3,4,5,7,8,9 }
    * Output : 6
    */

    private static int findMissingNumber(int[] arr){
        int numberOfTerms = ((arr.length+1)*(arr.length+2))/2;
        for (int val : arr){
            numberOfTerms -= val;
        }
        return numberOfTerms;
    }

    private static int findMissingNumberFromArray(int[] arr){
        Arrays.sort(arr);
        int[] localArr = new int[arr.length];
        for (int i = 0;i<arr.length;i++){
            localArr[i] = i+1;
            if (arr[i] != localArr[i]){
                return localArr[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,8,9,10,11};
        System.out.println(findMissingNumber(arr));
        System.out.println(findMissingNumberFromArray(arr));
    }
}
