package com.company.AlgorithmTraining;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class AlgorithmTraining {

    private static boolean isPolyndrome(String word){
        StringBuilder newWord = new StringBuilder();

        for (int i = 0; i < word.length();i++){
            int count = word.length();
            newWord.append(word.charAt(count - i - 1));
        }
        return word.equals(newWord.toString());
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
    private static void factorial(){
        int result = 1;
        int number;
        System.out.println("Input an integer.");
        number = new Scanner(System.in).nextInt();
        for (int i = 1;i<=number;i++) {
            result *= i;
        }System.out.println(result);
    }
    private static String parse(int number){
        int first,second,third;
        String firstChar = "",secondChar= "",thirdChar = "";
        first = number%10;
        second = (number%100)/10;
        third = (number%1000)/100;
        firstChar = getString(first, firstChar);
        secondChar = getString(second, secondChar);
        thirdChar = getString(third, thirdChar);
        return thirdChar+secondChar+firstChar;
    }
    private static String getString(int first, String character) {
        switch (first){
            case 1: character = "1"; break;
            case 2: character = "2"; break;
            case 3: character = "3"; break;
            case 4: character = "4"; break;
            case 5: character = "5"; break;
            case 6: character = "6"; break;
            case 7: character = "7"; break;
            case 8: character = "8"; break;
            case 9: character = "9"; break;
            case 0: character = "0"; break;
        }
        return character;
    }
    private static void changeToString(){
        System.out.println("Please define a variable to parse..");
        int number = new Scanner(System.in).nextInt();
        System.out.println("Parsed value is : '"+ parse(number)+"' debug to see resutls.");
    }
    private static void convertToBinary(){
        int number = new Scanner(System.in).nextInt();
        StringBuilder decimalString = new StringBuilder();
        for(int i = number;i>0;i/=2){
            decimalString.append(number % 2);
        }System.out.println(decimalString);
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
                    break;
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
    private static void fibonacciNumbers(){
        int temp=0,total,last = 0; 
        System.out.println("How many fibonacci numbers you want to see ?");
        int range = new Scanner(System.in).nextInt();
        for(int i = 1;i<=range;i++){
            if (i == 2){
                temp++;
            }
            total = temp+last;
            last = temp;
            temp = total;
            System.out.println(i+". fibonacci number is :"+total);
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
    private static void rockPaperScissors(){
        int userCount = 0,computerCount=0;
        System.out.println("Best out of ? : ");
        int bestOutOf = new Scanner(System.in).nextInt();
        while (true) {
            System.out.println("Please select your option : \n 1.)Rock \n 2.)Paper \n 3.)Scissors \n");
            int userChoice = new Scanner(System.in).nextInt() - 1;
            caseMethod(userChoice);
            try {
                for (int i = 3; i > 0; i--) {
                    Thread.sleep(1000);
                    System.out.println("Please wait for " + i + " seconds for computer's choice ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int randomComputerChoice = (int) (Math.random() * 3);
            caseMethod(randomComputerChoice);
            if (caseMethod(userChoice) == caseMethod(randomComputerChoice)) {
                System.out.println("Draw Your Score : "+userCount+" Computer's Score : "+computerCount);
            } else if ((caseMethod(userChoice) - caseMethod(randomComputerChoice) == 1)
                    || (caseMethod(userChoice) - caseMethod(randomComputerChoice) == -2)) {
                userCount++;
                System.out.println("You Win ! Your Score : "+userCount+" Computer's Score : "+computerCount);
            } else {
                computerCount++;
                System.out.println("Computer Wins ! Your Score : "+userCount+" Computer's Score : "+computerCount);
            }
            if (userCount==bestOutOf) { System.out.println("You Win !"); break; }
            else if (computerCount == bestOutOf) { System.out.println("Computer Wins ! "); break; }
        }
    }

    private static int findGCF(int num,int num2,int num3){
        int biggest = 0;
        for (int i = 2; i <= num;i++){
            if (num%i==0 && num2%i==0 && num3%i==0){
                biggest = i;
            }
        }
        return biggest;
    }
    private static void askGCF(){
        System.out.println("Please input your first integer");
        int firstNumber = new Scanner(System.in).nextInt();
        System.out.println("Please input your second integer");
        int secondNumber = new Scanner(System.in).nextInt();
        System.out.println("Please input your third integer");
        int thirdNumber = new Scanner(System.in).nextInt();
        int greatestCommonDivisor = findGCF(firstNumber,secondNumber,thirdNumber);
        if (findGCF(firstNumber,secondNumber,thirdNumber)==0){
            System.out.println("Could not find common divisor.. \n");
        }else {
            System.out.println("Greatest Common Divisor of 3 Variables is : " + greatestCommonDivisor + "\n");
        }
    }
    private static int caseMethod(int userChoice) {
        switch (userChoice){
            case 0: System.out.println("Rock"); break;
            case 1: System.out.println("Paper"); break;
            case 2: System.out.println("Scissors"); break;
        }
        return userChoice;
    }
    private static void sortingAlgorithm(int[] num){
        int n = num.length;
        for (int i = 0;i<n-1;i++){
            for(int j = 0;j<n-i-1;j++){
                if (num[j]>num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
    }
    private static void bubbleSort(){
        System.out.println("How many integers will you sort ?");
        int scanCount = new Scanner(System.in).nextInt();
        int[] array = new int[scanCount];
        for (int i = 0;i<scanCount;i++){
            System.out.println("Define the "+ (i+1) +". integer you want to sort in : ");
            int num = new Scanner(System.in).nextInt();
            array[i] = num;
        }
        System.out.println("Values before sorting :");
        for (int value : array) {
            System.out.print(" "+value);
        }
        System.out.println("\nValues after sorting :");
        sortingAlgorithm(array);
        for (int value : array){
            System.out.print(" "+value);
        }
        System.out.println("\n");
    }
    private static int linearSearch(int[] array,int num){
       int n = array.length;
       for (int i = 0;i<n;i++){
            if (array[i] == num){
                return i;
            }
       } return -1;
    }
    private static void searchingAlgorithm(){
        System.out.println("How many integers you want to add ? ");
        int count = new Scanner(System.in).nextInt();
        int[] array = new int[count];
        for (int i = 0;i<count;i++){
            System.out.println("Define the "+ (i+1) +". integer you want to search in : ");
            int num = new Scanner(System.in).nextInt();
            array[i] = num;
        }
        System.out.println("What number are you searching for ? ");
        int number = new Scanner(System.in).nextInt();
        for (int value : array){
            System.out.print(" "+value);
        }
        System.out.println("\n The number that you're searching is at : " + (linearSearch(array,number)+1) + ". value");
    }
    private static void modCalculator(){
        System.out.println("What is the number that you want to take mod ?");
        int total = new Scanner(System.in).nextInt();
        System.out.println("What is your mod ?");
        int param = new Scanner(System.in).nextInt();
        for (int i = total;i>param;i-=param){
            if ((i-param)<param){
                System.out.println(i-param);
            }else if ((i-param)==param){
                System.out.println(0);
            }
        }
    }
    private static void removeDuplicates(int[] arr)
    {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int value : arr) set.add(value);
        System.out.print("Removed variables are : " + set+"\n");
    }
    private static void duplicationRemover(){
        System.out.println("How many integers will you add ? ");
        int count = new Scanner(System.in).nextInt();
        int[] arr = new int [count];
        for (int i = 0;i<count;i++){
            System.out.println("Enter the " +(i+1)+". variable you want to add");
            int num = new Scanner(System.in).nextInt();
            arr[i] = num;
        }removeDuplicates(arr);
    }
    public static void main(String[] args){
       int choice;
        do {
            System.out.println("Algorithm Console \n Please Select the operation you want to use \n" +
                    " 1.)Check Polyndrome \n 2.)Total digit of number \n 3.)Star Application \n 4.)Increase and Decrease" + " \n " +
                    "5.)Prime Number List \n 6.)Factorial \n 7.)Parse \n 8.)Convert to Binary \n " +
                    "9.)Fibonacci Numbers \n 10.)Find Greatest Common Divisor \n 11.)Rock Paper & Scissors \n" +
                    " 12.)Sorting Algorithm \n 13.)Searching Algorithm \n 14.)Mod Calculator \n 16.)Duplication Remover \n 15.)Exit ");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1: checkPolyndrome(); break;
                case 2: digitTotal(); break;
                case 3: star(); break;
                case 4: decreaseAndIncrease(); break;
                case 5: primeNumberList(); break;
                case 6: factorial(); break;
                case 7: changeToString(); break;
                case 8: convertToBinary(); break;
                case 9: fibonacciNumbers(); break;
                case 10: askGCF(); break;
                case 11: rockPaperScissors(); break;
                case 12: bubbleSort(); break;
                case 13: searchingAlgorithm(); break;
                case 14: modCalculator(); break;
                case 15: duplicationRemover(); break;
                case 16: System.out.println("So long!"); System.exit(0); break;
            }
        } while (choice >= 1 && choice <= 16);
    }
}