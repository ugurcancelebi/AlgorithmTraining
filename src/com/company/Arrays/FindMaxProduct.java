package com.company.Arrays;

import java.util.Arrays;

public class FindMaxProduct {
    /*
     *  Find the n numbers in an array that produce the max product
     *  Input: {10, 3, 5, 6, 20}
     *  Output: 1200
     *
     * 1. Compare array[0] & array[1]
     * 2. If array[0] < array [1] swap it.
     * 3. Compare array[1] & array[2]
     * 4. If array[1] < array[2] swap it.
     * ...
     * 5. Compare array[n-1] & array[n]
     * 6. if [n-1] < array[n] then swap it.
     * */
    private static int findMaxProduct(int[] arr,int n){
        for (int i = 0;i<arr.length;i++){
            for (int j = 0; j<arr.length-i-1;j++){
                if (arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        int total = 1;
        for (int i = 0;i<n;i++){
            total*=arr[i];
        }
        return total;
    }
    /*
    * Using with java libraries:
    * */
    private static int findMaxProductJava(int[] arr,int n){
        Arrays.sort(arr);
        return Math.max(arr[0] * arr[1] * arr[n - 1],
                arr[n - 1] * arr[n - 2] * arr[n - 3]);
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(findMaxProduct(arr,3));
        System.out.println(findMaxProductJava(arr,arr.length));
    }
}
