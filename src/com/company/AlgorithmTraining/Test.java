package com.company.AlgorithmTraining;

import java.io.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class Test {
    // Then get the day of week from the Date based on specific locale.
    private static String findDay(int month, int day, int year) {
        int intYear = Integer.parseInt(String.valueOf(year));
        int intDay = Integer.parseInt(String.valueOf(day));
        int intMonth = Integer.parseInt(String.valueOf(month));
        String dateString = String.format("%d-%d-%d", intYear, intMonth, intDay);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-M-d").parse(dateString);
        }
        catch(ParseException ref){
            ref.printStackTrace();
        }
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
        return dayOfWeek.toUpperCase();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int month = Integer.parseInt(firstMultipleInput[0]);
        int day = Integer.parseInt(firstMultipleInput[1]);
        int year = Integer.parseInt(firstMultipleInput[2]);
        String res = Test.findDay(month, day, year);
        bufferedWriter.write(res);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }private static void checkpolyndrome(){
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        for (int i = A.length()-1;i>=1;i--){
            String reversed = "";
            reversed += A.charAt(i);
        }
    }
}
