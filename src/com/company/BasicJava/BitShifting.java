package com.company.BasicJava;

public class BitShifting {

    public static void main(String[] args) {
        int x = 0XFAEF;
        int y = 0xF8E9;
        System.out.println("x & y  = " + (x & y));
        System.out.println("x & y  = " + (x | y));
        System.out.println("x & y  = " + (x ^ y));
        System.out.println("x & y  = " + (x << y));
        System.out.println("x & y  = " + (x >> y));
        System.out.println("x & y  = " + (x >>> y));
        System.out.println(x + " " + y);
    }
}
