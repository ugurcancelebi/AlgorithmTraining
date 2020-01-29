package com.company.AlgorithmTraining;

import java.util.Scanner;

class AlgorithmConsoleOptions {
    public static void main(String[] args){
        AlgorithmTraining algorithmTraining = new AlgorithmTraining();
        int choice;
        do {
            System.out.println(getAlgorithmOptions());
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1: algorithmTraining.checkPolyndrome(); break;
                case 2: algorithmTraining.digitTotal(); break;
                case 3: algorithmTraining.star(); break;
                case 4: algorithmTraining.decreaseAndIncrease(); break;
                case 5: algorithmTraining.primeNumberList(); break;
                case 6: algorithmTraining.factorial(); break;
                case 7: algorithmTraining.changeToString(); break;
                case 8: algorithmTraining.convertToBinary(); break;
                case 9: algorithmTraining.fibonacciNumbers(); break;
                case 10: algorithmTraining.askGCF(); break;
                case 11: algorithmTraining.rockPaperScissors(); break;
                case 12: algorithmTraining.bubbleSort(); break;
                case 13: algorithmTraining.searchingAlgorithm(); break;
                case 14: algorithmTraining.modCalculator(); break;
                case 15: algorithmTraining.duplicationRemover(); break;
                case 16: algorithmTraining.convertToMile(); break;
                case 17: algorithmTraining.funcHypotenuse(); break;
                case 18: algorithmTraining.findRootByDiscriminant(); break;
                case 19: algorithmTraining.findGeometricAverage(); break;
                case 20: algorithmTraining.checkPrime(); break;
                case 21: algorithmTraining.printNumberBackwards(); break;
                case 22: algorithmTraining.calculatePermutation(); break;
                case 23: System.out.println("So long!"); System.exit(0); break;
            }
        } while (choice >= 1 && choice <= 23);
    }
     private static String getAlgorithmOptions() {
         return (" Algorithm Console \n" +
                 " Please Select the operation you want to use \n" +
                 " 1.)Check Polyndrome \n" +
                 " 2.)Total digit of number \n" +
                 " 3.)Star Application \n" +
                 " 4.)Increase and Decrease \n" +
                 " 5.)Prime Number List \n" +
                 " 6.)Factorial \n" +
                 " 7.)Parse \n" +
                 " 8.)Convert to Binary \n" +
                 " 9.)Fibonacci Numbers \n" +
                 " 10.)Find Greatest Common Divisor \n" +
                 " 11.)Rock Paper & Scissors \n" +
                 " 12.)Sorting Algorithm \n" +
                 " 13.)Searching Algorithm \n" +
                 " 14.)Mod Calculator \n" +
                 " 15.)Duplication Remover \n" +
                 " 16.)Convert KM to Mile \n" +
                 " 17.)Find Hypotenuse of Triangle \n" +
                 " 18.)Find Root by Discriminant \n" +
                 " 19.)Find Geometric Average \n" +
                 " 20.)Check Prime \n" +
                 " 21.)Print number backwards \n" +
                 " 22.)Calculate Permutation \n" +
                 " 23.)Exit \n");
     }
}
