package com.company.BasicJava;
import java.util.Stack;

public class ReversePolishNotation {

    public static double evaluate(String expr) {
        Stack<Double> stack = new Stack<>();
        if (expr.isEmpty()) return 0;

        for(int i = 0; i< expr.length(); i++){
            if (expr.charAt(i) != ' '){
                char c = expr.charAt(i);

                if(Character.isDigit(c)){
                    double d = c - '0';
                    stack.push(d);
                }

                else {
                    double pre = stack.pop();
                    double post = stack.pop();

                    switch(c){
                        case '+':
                            stack.push(post + pre);
                            break;

                        case '-':
                            stack.push(post - pre);
                            break;

                        case '*':
                            stack.push(post * pre);
                            break;

                        case '/':
                            stack.push(post / pre);
                            break;
                    }
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("1 2 3"));
    }
}