package com.company.Arrays;

public class FindSecondBiggestValue {
    private static int findSecondBiggest(int[] arr){
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int val : arr){
            if (val > first){
                second = first;
                first = val;
            } else if (val > second && val != first) {
                second = val;
            }
        }
        return second;
    }
    private static int findSecond(int[] arr){
        int first= 0;int second = 0;
        for (int i = 0;i< arr.length;i++){
            if (arr[i] > first){
                second = first;
                first = arr[i];
            }else if (arr[i] > second && arr[i] != first){
                second = arr[i];
            }
        }
        return second;
    }
    public static void main(String[] args){
        int[] arr = {1,3,4,15,15,2,8,0};
        System.out.println(findSecond(arr));
    }
}
