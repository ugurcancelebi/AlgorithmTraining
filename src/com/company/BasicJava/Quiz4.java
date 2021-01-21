package com.company.BasicJava;

import java.util.Scanner;

public class Quiz4 {
    private static void read(int[] array){
        int lowerBound = 10;
        int upperBound = 20;

        System.out.println("Enter five numbers below:");
        for (int i = 0;i<5;i++){
            System.out.print("Number [ " + i + " ] " +  "=>" );
            array[i] = new Scanner(System.in).nextInt();
        }

        find(array,lowerBound,upperBound);
    }

    private static void find(int[] numberList, int lowerBound, int upperBound){
        System.out.print("Numbers : { ");
        for (int value : numberList) {
            display(value,0);
        }
        System.out.print(" } \n");

        System.out.print("Numbers within [" + lowerBound + " - " + upperBound + "] {  ");
        for (int value : numberList) {
            if (value >= lowerBound && value <= upperBound) {
                display(value,1);
            }
        }
        System.out.print(" } \n");
    }
    private static void display(int number,int operation){
        switch (operation){
            case 0:
                System.out.print(number+" , ");
                break;
            case 1:
                System.out.print(number+" - ");
                break;
        }
    }

    public static void main(String[] args) {
        int[] numberList = new int[5];
        read(numberList);
    }
}