package com.company.OOP;

public class tempintempi {
    public static void main(String[] args) {
        int prev;
        int temp = 1;
        int total = 0;
        for (int i=0;i<10;i++){
           prev = temp;
           temp = prev;
           total += temp;
            System.out.println(total);
        }
    }
}
