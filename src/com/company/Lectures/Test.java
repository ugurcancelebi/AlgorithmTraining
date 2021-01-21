package com.company.Lectures;

import java.io.*;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        if (true == false) { //Some basic trick in JAVA \u000a\u007d\u007b
            System.out.println("true is false!");
        }
    }















    static int[] mArray;
    static int[] tArray;
    static int totalMSum;
    static int totalTSum;
    private static void readVal() throws FileNotFoundException {
        int index = 0;
        File file = new File("input1.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()){
                if (scanner.hasNextInt()){
                    mArray[index] = scanner.nextInt();
                    mArray[index+1] = scanner.nextInt();
                    valueM(mArray[index],mArray[index+1]);
                }else {
                    tArray[index] = scanner.nextInt();
                    valueT(tArray[index]);
                }
            }
        }
    }

    private static int valueM(int first,int second){
        int mCountIndex = 0;
        for (int i = 0;i<mArray.length/2;i++){
            if (mArray[i] % 2 == 0){
                first = mArray[i];
            }else {
                second = mArray[i];
            }
            totalMSum += first*second;
            mCountIndex += 1;
        }
        System.out.println("Number of meta Lines : " + mCountIndex);
        return mCountIndex;
    }

    private static int valueT(int val){
        int tIndex = 0;
        for (int i =0;i<tArray.length;i++){
            val = tArray[i];
            tIndex += 1;
        }
        totalTSum += val;
        System.out.println("Number of teta Lines : " + tIndex);
        return tIndex;
    }

    private static int sumAllValues(){
        return totalTSum + totalTSum;
    }

}
