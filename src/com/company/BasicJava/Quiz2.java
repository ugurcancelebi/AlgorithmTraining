package com.company.BasicJava;

import java.util.Scanner;

public class Quiz2 {
    public static void main(String[] args) {
        System.out.println("0. exit \n1. add \n2. multiply");
        int[] arr = new int[3];
        int value;
        int result;
        do {
            System.out.println("Your choice");
            result  = new Scanner(System.in).nextInt();
            switch (result){
                case 1:
                    read(arr);
                    value = add(arr);
                    display(value);
                    break;
                case 2:
                    read(arr);
                    value = multiply(arr);
                    display(value);
                    break;
            }
        }while (result != 0);
        System.out.println("Exit..");
    }

    private static int add(int[] arr) {
        int number = 0;
        for (int i= 0;i<3;i++){
           number += arr[i];
        }
        return number;
    }

    private static int multiply(int[] arr) {
        int number = 1;
        for (int i= 0;i<3;i++){
            number *= arr[i];
        }
        return number;
    }

    private static void read(int[] arr) {
        System.out.println("Enter 3 numbers");
        for (int i= 0;i<3;i++) {
            arr[i] = new Scanner(System.in).nextInt();
        }
    }

    private static void display(int value) {
        System.out.println(value);
    }
}
