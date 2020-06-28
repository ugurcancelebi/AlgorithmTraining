package com.company.HackerRankJavaQuestions;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class LaptopBatteryLife {

    /*
     * Complete the 'getBattery' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY events as parameter.
     */

    public static int getBattery(List<Integer> events) {
        int batteryLife = 50;
        for (Integer event : events) {
            batteryLife += event;
            if (batteryLife > 100){
                batteryLife = 100;
            }else if (batteryLife < 0){
                batteryLife = 0;
            }
        }
        return batteryLife;
    }
    public static void main(String[] args) throws IOException {
        List<Integer> batteryPercentages = new ArrayList<>();
        batteryPercentages.add(80);
        batteryPercentages.add(-20);
        batteryPercentages.add(50);
        batteryPercentages.add(300);
        System.out.println(getBattery(batteryPercentages));
    }
}

