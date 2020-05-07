package com.company.Arrays;

public class LowHighIndex {
    /*
     * Given a sorted array of integers, return the low and high index of the given key.
     * Return -1 if not found. The array length can be in millions with lots of duplicates.
     * */


    /*
     * Linear search might be inefficient if the arr length exceeds a millions elements
     * so we can use a modified version of binary search
     * */

    /*
     * Since we are using binary search the runtime complexity is Logarithmic, O(logn).
     * Memory Complexity = O(1)
     * */
    private static int[] findLowestHighestIndex(int[] arr,int num){
        int size = arr.length;
        int[] newArr = new int[2];
        for (int i = 0; i < size-1; i++) {
            if (arr[i] == num) {
                newArr[0] = i;
                break;
            }
        }
        for (int i = size-1;i>0 ;i--){
            if (arr[i] == num){
                newArr[1] = i;
                break;
            }
        }
        return newArr;
    }
    public static void main (String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,2,1,2,3};
        int[] newArr = findLowestHighestIndex(arr,2);
        System.out.print(newArr[0] + " " + newArr[1]);
    }
}
