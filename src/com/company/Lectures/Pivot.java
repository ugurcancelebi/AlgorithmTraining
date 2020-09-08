package com.company.Lectures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pivot {
    static int[] numbers;
    public static void main(String[] args) {
        reader();
        System.out.println("Pivot number is : " + pivotReader());
    }
    private static void reader(){
        numbers = new int[5];
        int index = 0;
        File file = new File("input1.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner != null) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    numbers[index] = scanner.nextInt();
                    index++;
                } else {
                    scanner.next();
                }
            }
        }
    }
    private static int pivotReader(){
        Scanner scanner = new Scanner(System.in);
        int pivot = scanner.nextInt();
        System.out.println("Number of occurences is " + count(pivot));
        return pivot;
    }
    static int count(int pivot){
        int counter = 0;
        for (int number : numbers) {
            if (number == pivot) {
                counter++;
            }
        }
        return counter;
    }
}
