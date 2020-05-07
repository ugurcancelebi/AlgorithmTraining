package com.company.Arrays;

public class FindSmallestCommonNumber {
    public static void main(String[] args){
        int[] arr1 = {6, 7, 10, 25, -1, 63, 64};
        int[] arr2 = {0, 4, 5, 2, 7, 8, -1};
        int[] arr3 = {-1, 6, 10, 14};
        System.out.println(findSmallestCommonNumber(arr1, arr2, arr3));
    }

    private static int findSmallestCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
        for (int i = 0;i<arr1.length;i++){
            for (int j = 0;j<arr2.length;j++){
                for (int k = 0;k<arr3.length;k++){
                    if ((arr1[i] == arr2[j])&& (arr2[j] == arr3[k])){
                        return arr1[i];
                    }
                }
            }
        }
        throw new IllegalArgumentException("No data found");
    }
}
