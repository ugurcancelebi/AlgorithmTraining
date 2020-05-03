package com.company.HackerRankJavaQuestions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoDimensionalArray {
    static void hourglassSum(int[][] arr) {
        int[][] newArr = new int[arr.length-2][arr.length-2];
        int biggest = Integer.MIN_VALUE;
        for (int i = 0;i<arr.length-2;i++){
            for (int j = 0;j<arr.length-2;j++){
                System.out.println();
                newArr[i][j] = (arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] +
                        arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]);
                if (newArr[i][j] > biggest){
                    biggest = newArr[i][j];
                    System.out.print(newArr[i][j]+ " ");
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] a = {
                {0, -4 ,-6, 0, -7, -6},
                {-1, -2 ,-6, -8 ,-3, -1},
                {-8, -4 ,-2 ,-8 ,-8, -6},
                {-3, -1, -2 ,-5 ,-7, -4},
                {-3, -5, -3, -6, -6, -6},
                {3, -6, 0 ,-8, -6, -7}
        };
        hourglassSum(a);
       /* for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        } */

    }
}
