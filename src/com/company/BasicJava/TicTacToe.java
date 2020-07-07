package com.company.BasicJava;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static char[] arr = {'1','2','3','4','5','6', '7','8','9'};
    static boolean gameOver = false;

    private static void initArray(){
        for (int i = 0;i<9;i++){
            if (i%3 == 0 && i!= 0){
                System.out.print("\n");
            }
            System.out.print(arr[i]+" ");
        }
    }

    private static void initGame() {
        initArray();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (!gameOver) {
            int cpuInput = random.nextInt(9);
            int userInput = scanner.nextInt() - 1;
            if (arr[cpuInput] != arr[userInput]) {
                if (arr[cpuInput] != 'O' && arr[cpuInput] != 'X') {
                    if (userInput < 9) {
                        if (arr[userInput] != 'O' && arr[userInput] != 'X') {
                            arr[userInput] = 'X';
                            arr[cpuInput] = 'O';
                            System.out.println("--------");
                            initArray();
                        } else {
                            System.out.println("Place already taken ..");
                        }
                    } else {
                        System.out.println("Please define input between 1-9");
                    }
                }
            }
            checkResults();
        }
    }

    private static void checkResults() {
        String[] resultSet = {
                arr[0] + String.valueOf(arr[1]) + arr[2],
                arr[3] + String.valueOf(arr[4]) + arr[5],
                arr[6] + String.valueOf(arr[7]) + arr[8],
                arr[0] + String.valueOf(arr[3]) + arr[6],
                arr[1] + String.valueOf(arr[4]) + arr[7],
                arr[2] + String.valueOf(arr[5]) + arr[8],
                arr[0] + String.valueOf(arr[4]) + arr[8],
                arr[2] + String.valueOf(arr[4]) + arr[6]
        };

        for (String result : resultSet){
            if (result.equals("XXX")){
                System.out.println("You Won !");
                gameOver = true;
            } else if (result.equals("OOO")){
                System.out.println("Computer Won");
                gameOver = true;
            }
        }
    }

    public static void main(String[] args) {
        initGame();
    }
}

