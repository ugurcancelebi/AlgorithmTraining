package com.company.HackerRankJavaQuestions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArrayRotation {
    /*
    A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become .
        Sample Input
        5 4
        1 2 3 4 5
        Sample Output
        5 1 2 3 4
        Explanation
        When we perform  left rotations, the array undergoes the following sequence of changes:
     */

    static int[] rotLeft(int[] a, int d) {
        int size = a.length;
        int[] arr = new int[size];
        int index = 0;
        for (int i = d; i < size;i++){
            arr[i] = a[index];
            index++;
        }
        index = 0;
        int rotate = d+1;
        while (index<d){
            arr[index] = a[rotate];
            index++;
            rotate++;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        int[] arr = {1,2,3,4,5};
        int n = 2;
        int[] newArr = (rotLeft(arr,n));
        for (int a : newArr){
            System.out.println(a);
        }
    }
}
