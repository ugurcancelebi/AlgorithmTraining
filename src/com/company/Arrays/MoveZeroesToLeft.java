package com.company.Arrays;

import java.util.Arrays;

public class MoveZeroesToLeft {
    /*
     * Given an integer array, move all elements containing '0' to the left while maintaining the order of
     * other elements in the array.
     * */
    /*
     * Runtime Complexity = Linear, O(n).
     * Memory Complexity = Constant, O(1).
     *
     * Step 1: Keep two markers (readIndex and writeIndex) and point them to the end of the array
     * Step 2: If readIndex < 0, skip
     * Step 3: Iterate through the array in reverse, & if current element points to non zero,
     *         update the array current element to readindex element & increment writeIndex
     * */
    private static int[] moveZeroesToLeft(int[] arr) {
        int zeroesIndex = 0;
        int size = arr.length;
        int[] newArray = new int[size];
        for (int value : arr) {
            if (value == 0) {
                newArray[zeroesIndex] = value;
                zeroesIndex++;
            }
        }
        for (int value : arr) {
            if (value != 0) {
                newArray[zeroesIndex] = value;
                zeroesIndex++;
            }
        }
        return newArray;
    }
    public static void main(String[] args) {
        int[] arr = {1, 10, 20, 0, 59, 63, 0, 88, 0};
        System.out.println(Arrays.toString(moveZeroesToLeft(arr)));
    }
}
