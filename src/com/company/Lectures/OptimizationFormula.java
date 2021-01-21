package com.company.Lectures;

import java.util.Scanner;

public class OptimizationFormula {
    //density = p
    //width = w
    //height = h
    //Wbeam = p.L.h.w
    private static double getMinimum(int width,int height){
        return 0.07065 * width * height;
    }
    private static double getN(int width,int height,int density){
        if (getG1X(width,height) && getG2X(width,height)) {
            return (density *
                    Math.pow(10, 9) *
                    9000 *
                    width *
                    height);
        }
        return 0.0;
    }
    private static boolean getG1X(int width,int height){
        return 1000.0 / (width * height) + 36000000 / Math.pow(height,2) * width <= 350;
    }
    private static boolean getG2X(int width,int height){
        return  3 * width <= height;
    }
    private static double returnI(int width,int height){
        return (width*Math.pow(height,3)/12);
    }
    public static void main(String[] args) {
        System.out.println("Define width and height inputs..");
        int width = new Scanner(System.in).nextInt();
        int height = new Scanner(System.in).nextInt();
        int density = 350;

        if (getN(width,height,350) != 0.0)
            System.out.println(getN(width,height,density));
        else
            System.out.println("Invalid variables, please redefine width and height");
    }
}
