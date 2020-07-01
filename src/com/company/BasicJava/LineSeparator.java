package com.company.BasicJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LineSeparator {

    public static void main(String[] args) throws IOException {
        InputStreamReader inStream = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(inStream);

        String line = buffer.readLine();;
        System.out.println("in ('" + line+"',");
        while (line != null){
            if (!line.equals("")) {
                line = buffer.readLine();
                System.out.println("'" + line + "',");
            }else {
                System.out.println(");");
                break;
            }
        }
    }
}