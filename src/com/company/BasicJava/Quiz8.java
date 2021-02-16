package com.company.BasicJava;

import static com.company.BasicJava.MiniJava.*;
public class Quiz8 {

    public static void main(String[] args) {
        int n,i,a;
        n = readInt();
        i = 1;
        a = 0;
        while (i<=(n+1)){
            if ((a%2)==0){
                a=a+(i*n);
            } else {
                a = -1;
            }
            i = i+1;
        }
        print(a/i);
    }
}
