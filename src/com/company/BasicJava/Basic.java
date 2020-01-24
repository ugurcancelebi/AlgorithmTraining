package com.company.BasicJava;

import com.company.AlgorithmTraining.AlgorithmTraining;

public class Basic {
    /**
     * That is how to use javadoc
     * Javadoc is mostly used for documentation while programming
     * javadoc can be used with slash and two stars
     * @version 1.0.1_beta
     * @param args
     */
    static int abc;
    static int def;
    public static void main(String[] args) {
        System.out.println(calculateStaticVariable());
        //System.out.println("First parameter is : " + args[0]);
        //System.out.println("Second parameter is : " + args[1]);
        System.out.println(javadocFunction());
    }

    private static int calculateStaticVariable() {
        abc = 1;
        return ++abc;
    }

    /**
     *Method used by Classes in applications
     * @author Ugurcan Celebi (github.com/uurcan)
     * @return int
     */
    private static int javadocFunction() {
        try {
            return "Sout".length();
        } catch (Exception e){
            e.printStackTrace();
        }return  0;
    }
}

