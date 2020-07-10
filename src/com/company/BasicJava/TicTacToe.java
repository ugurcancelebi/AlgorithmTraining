package com.company.BasicJava;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static char[] arr = {'1','2','3','4','5','6', '7','8','9'};
    static boolean gameOver = false;
    static boolean userTurn = true;
    static int userInput;
    static int gameCount;

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
            if (userTurn){
                userInput = scanner.nextInt() - 1;
            }
            if (arr[cpuInput] != arr[userInput]) {
                if (arr[cpuInput] != 'O' && arr[cpuInput] != 'X') {
                    if (userInput < 9) {
                        if (arr[userInput] != 'O' && arr[userInput] != 'X') {
                            arr[userInput] = 'X';
                            arr[cpuInput] = 'O';
                            userTurn = true;
                            System.out.println("--------");
                            initArray();
                            gameCount++;
                        } else {
                            System.out.println("Place already taken ..");
                            userTurn = true;
                        }
                    } else {
                        System.out.println("Please define input between 1-9");
                    }
                } else {
                    userTurn = false;
                }
            } else {
                if (gameCount>=5){
                    checkResults();
                } else {
                    userTurn = false;
                }
            } checkResults();
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
                System.out.println("\nYou Won !");
                gameOver = true;
                break;
            } else if (result.equals("OOO")){
                System.out.println("\nComputer Won");
                gameOver = true;
                break;
            } else if(gameCount>=5){
                System.out.println("Game Draw !");
                gameOver = true;
                break;
            }
        }
    }

    public static void main(String[] args) {
        initGame();
    }
}

