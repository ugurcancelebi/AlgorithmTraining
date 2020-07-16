package com.company.BasicJava;
import java.util.*;
import java.util.Scanner;

// Write your code here. DO NOT use an access modifier in your class declaration.
class Hangman {
    public static boolean isBalanced(String text){
        
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(isBalanced(in.next()));
        }

        in.close();
    }
}
