package com.company.AlgorithmTraining;

import java.util.Scanner;

public class PharantesisBalance {

    static boolean checkParenthesis(String s) {
        int buffer = 0;//buffer count, her ( geldiğinde artacak , her ) geldiğinde azalacak
        //eğer buffer 0 ise zaten eşittir ve true döner
        //eğer sıfırdan eksi ise sağ parantez fazladır ve eşit olması mümkün değildir.
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                buffer++;
            }
            else if(s.charAt(i)==')'){
                if(buffer>0) buffer--;
                else return false;
            }
        }
        return buffer == 0;
    }
    public static void main(String[] args) {
        for (int i= 0;i<3;i++) {
            System.out.print("Enter a string : ");
            String str = new Scanner(System.in).next();
            if (checkParenthesis(str)) {
                System.out.println("The string is parenthesis balanced");
            } else {
                System.out.println("The string is non parenthesis balanced");
            }
        }
    }
}
