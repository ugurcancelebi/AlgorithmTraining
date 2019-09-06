package com.company;

import java.util.Scanner;

public class Main {
    private static boolean isPolyndrome(String word){
        String newWord = "";

        for (int i = 0; i < word.length();i++){
            int count = word.length();
            newWord += word.charAt(count-i-1);
        }
        return word.equals(newWord);
    }

    private  static void checkPolyndrome(){
        String word;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a String");
        word = scanner.nextLine();
        if (isPolyndrome(word)){
            System.out.println("Polyndrome word");
        } else System.out.println("Non polyndrome word");
    }

    private static void digitTotal(){
        int num,first,second,third;
        Scanner in = new Scanner(System.in);
        System.out.println("Define a variable");
        num = in.nextInt();
        first = num%10;
        second = (num%100)/10;
        third = (num%1000)/100;
        System.out.println((first+second+third));
    }
    private static void star(){
        int num;
        Scanner in = new Scanner(System.in);
        System.out.println("Define a variable");
        num = in.nextInt();
        for (int i = 0;i<num;i++){
            for (int j = 0 ;j <i+1;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    private static void decreaseAndIncrease(){
        int num = new Scanner(System.in).nextInt();
        for (int i = num;i>0;i--){
            System.out.print(i);
            for (int j=i-1 ;j>0;j--){
                System.out.print(j);
            }
            for (int k=2 ;k<=i;k++){
                System.out.print(k);
            }
            System.out.print("\n");
        }
    }
    private static void primeNumberList(){
        int count;
        int sayi = 0;
        System.out.println("How many prime numbers do you want to see ? ");
        count = new Scanner(System.in).nextInt();
        int num = 2;
        while (sayi < count) {
            boolean isPrime = true;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime){
                sayi++;
                if (sayi % 10 == 0){
                    System.out.print("\n");
                }else System.out.print(num+ " ");
            }
            num++;
        }
    }
    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("Algorithm Console \n Please Select the operation you want to use \n" +
                    " 1.)Check Polyndrome \n 2.)Total digit of number \n 3.)Star Application \n 4.)Increase and Decrease" +
                    " \n 5.) Prime Number List \n 6.)Exit ");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    checkPolyndrome();
                    break;
                case 2:
                    digitTotal();
                    break;
                case 3:
                    star();
                    break;
                case 4:
                    decreaseAndIncrease();
                    break;
                case 5:
                    primeNumberList();
                    break;
                case 6:
                    System.out.println("So long!");
                    System.exit(0);
                    break;
            }
        }while (choice>=1 && choice<=6);
    }
}
