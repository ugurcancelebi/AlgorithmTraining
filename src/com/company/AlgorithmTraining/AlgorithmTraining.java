package com.company.AlgorithmTraining;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class AlgorithmTraining {

    private boolean isPolyndrome(String word){
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < word.length();i++){
            int count = word.length();
            newWord.append(word.charAt(count - i - 1));
        }
        return word.equals(newWord.toString());
    }
    void checkPolyndrome(){
        String word;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a String");
        word = scanner.nextLine();
        if (isPolyndrome(word)){
            System.out.println("Polyndrome word");
        } else System.out.println("Non polyndrome word");
    }
    void digitTotal(){
        int num,first,second,third;
        Scanner in = new Scanner(System.in);
        System.out.println("Define a variable");
        num = in.nextInt();
        first = num%10;
        second = (num%100)/10;
        third = (num%1000)/100;
        System.out.println((first+second+third));
    }
    void star(){
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
    void factorial(){
        int result = 1;
        int number;
        System.out.println("Input an integer.");
        number = new Scanner(System.in).nextInt();
        for (int i = 1;i<=number;i++) {
            result *= i;
        }System.out.println(result);
    }
    private String parse(int number){
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
    private String getString(int first, String character) {
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
    void changeToString(){
        System.out.println("Please define a variable to parse..");
        int number = new Scanner(System.in).nextInt();
        System.out.println("Parsed value is : '"+ parse(number)+"' debug to see resutls.");
    }
    void convertToBinary(){
        int number = new Scanner(System.in).nextInt();
        StringBuilder decimalString = new StringBuilder();
        for(int i = number;i>0;i/=2){
            decimalString.append(number % 2);
        }System.out.println(decimalString);
    }
    void primeNumberList(){
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
    void fibonacciNumbers(){
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
    void decreaseAndIncrease(){
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
    void rockPaperScissors(){
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

    private int findGCF(int num,int num2,int num3){
        int biggest = 0;
        for (int i = 2; i <= num;i++){
            if (num%i==0 && num2%i==0 && num3%i==0){
                biggest = i;
            }
        }
        return biggest;
    }
    void askGCF(){
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
    private int caseMethod(int userChoice) {
        switch (userChoice){
            case 0: System.out.println("Rock"); break;
            case 1: System.out.println("Paper"); break;
            case 2: System.out.println("Scissors"); break;
        }
        return userChoice;
    }
    private void sortingAlgorithm(int[] num){
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
    void bubbleSort(){
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
    private int linearSearch(int[] array,int num){
       int n = array.length;
       for (int i = 0;i<n;i++){
            if (array[i] == num){
                return i;
            }
       } return -1;
    }
    void searchingAlgorithm(){
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
    void modCalculator(){
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
    void convertToMile(){
        System.out.println("Enter a variable to convert to mile : ");
        double number = new Scanner(System.in).nextInt();
        number *= 0.621;
        System.out.println("Converted value is : " + number);
    }
    private double findHypotenuse(double a,double b){
        return Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
    }
    void funcHypotenuse(){
        System.out.println("Please define first value of triangle");
        double first = new Scanner(System.in).nextDouble();
        System.out.println("Please define second value of triangle");
        double second = new Scanner(System.in).nextDouble();
        System.out.println("Hypotenuse of the triangle is : " + findHypotenuse(first,second));
    }
    private void removeDuplicates(int[] arr)
    {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int value : arr) set.add(value);
        System.out.print("Removed variables are : " + set+"\n");
    }
    void duplicationRemover(){
        System.out.println("How many integers will you add ? ");
        int count = new Scanner(System.in).nextInt();
        int[] arr = new int [count];
        for (int i = 0;i<count;i++){
            System.out.println("Enter the " +(i+1)+". variable you want to add");
            int num = new Scanner(System.in).nextInt();
            arr[i] = num;
        }removeDuplicates(arr);
    }
    void findRootByDiscriminant(){
        int a,b,c;
        System.out.println("Please define 3 integer variables in a row.");
        a = new Scanner(System.in).nextInt();
        b = new Scanner(System.in).nextInt();
        c = new Scanner(System.in).nextInt();
        double disc = returnDiscriminant(a,b,c);
        if (disc < 0){
            System.out.println("No root element found for variable : ");
        }else if (disc == 0){
            double x1 = returnFirstRootForDiscriminant(a,b,c);
            System.out.println("One root found! Value is :" + x1);
        }else {
            double x1 = returnFirstRootForDiscriminant(a,b,c);
            double x2 = returnSecondRootForDiscriminant(a,b,c);
            System.out.println("Two root found! Values are : "+ x1 + "\n" + x2);
        }
    }
    private double returnSecondRootForDiscriminant(int a, int b, int c) {
        return (b + Math.sqrt(returnDiscriminant(a,b,c)))/2*a;
    }
    private double returnFirstRootForDiscriminant(int a,int b,int c){
        return (b*-1 + Math.sqrt(returnDiscriminant(a,b,c)))/2*a;
    }
    private double returnDiscriminant(int a,int b,int c){
        return Math.pow(b,2)-(4*a*c);
    }
    void findGeometricAverage(){
        int number;
        List<Integer> integerList = new ArrayList<>();
        do {
            System.out.println("Enter variable to get Average (0 to Exit)");
            number = new Scanner(System.in).nextInt();
            integerList.add(number);
        } while (number != 0);
        System.out.println("Geometric average of the value is : " + getAverage(integerList));
    }
    private double getAverage(List<Integer> variables){
        int rawNumber = 1;
        for (int i =0; i<variables.size()-1;i++) {
            rawNumber *= variables.get(i);
        }
        return Math.pow(rawNumber,1/(((double)variables.size())-1));
    }
    private boolean isPrime(int number){
        for (int i = 2;i<number;i++){
            if (number%i==0){
                return false;
            }
        } return true;
    }
    void checkPrime(){
        System.out.println("Please define a number to see if prime : ");
        int number = new Scanner(System.in).nextInt();
        if (isPrime(number))
            System.out.println(number + " is Prime");
        else
            System.out.println(number + " not prime ");
    }
    void printNumberBackwards(){
        System.out.println("Put an integer to print backwards : ");
        int number = new Scanner(System.in).nextInt();
        while (number != 0){
            System.out.print(number%10);
            number /= 10;
        }
    }
    void calculatePermutation(){
        System.out.println("Define an 'n' integer : ");
        int n = new Scanner(System.in).nextInt();
        System.out.println("Define an 'r' integer : ");
        int r = new Scanner(System.in).nextInt();
        int nFact = 1;
        int rFact = 1;
        for (int i = 1;i<=n;i++){
            nFact*=i;
        }
        for (int i = 1;i<=(n-r);i++){
            rFact*=i;
        }
        System.out.println("Permutation of the integer = " + (nFact/rFact));
    }
}