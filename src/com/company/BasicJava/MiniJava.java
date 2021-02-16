package com.company.BasicJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiniJava {
    public static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
    public static void write(String x){
        System.out.println(""+x);
    }
    public static void write(int x){write(""+x);}
    public static String readString(){
        try {
            return in.readLine();
        } catch (IOException e){
            throw new RuntimeException("Input error");
        }
    }
    public static void print(Object o){
        System.out.println(o);
    }
    public static int readInt(){
        return Integer.parseInt(readString().trim());
    }
}
