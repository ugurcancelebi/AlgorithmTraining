package com.company.BasicJava;

public class NumToOrd {
    public static void main(String[] args) {
        System.out.println(numberToOrdinal(92));
    }
    public static String numberToOrdinal( Integer number ) {
        String[] suffix = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
        switch (number % 100) {
            case 11:
            case 12:
            case 13:
                return number + "th";
            default:
                return number + suffix[number % 10];
        }
    }
}
