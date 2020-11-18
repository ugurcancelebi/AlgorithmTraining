package com.company.BasicJava;

import java.util.Scanner;

public class Quiz1 {
    public static void main(String[] args) {
        int i = 0;
        while(i<10){
            System.out.println((i+1)+"*");
            i++;
        }
        for (int j = 2;j<11;j= j+2){
            System.out.println((j-1)+"*");
        }

        int x = -6;
        int y = 7;
        if (x < 0){
            x *= -1;
        }
        if(x < 10){
            x+=y;
        }
        System.out.println(x);*/
        String word = "defgh";
        word.replace("e","x");
        System.out.println(word);
        int x = 42;
        System.out.println(--x == x++);
        for (int i = 0;i<10;i+=2){
            if (i == 4){
                continue;
            }
            System.out.println(i+" ");
        }
    }
}
