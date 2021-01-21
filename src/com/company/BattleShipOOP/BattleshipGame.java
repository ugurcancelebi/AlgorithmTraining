package com.company.BattleShipOOP;

import java.util.Scanner;

public class BattleshipGame {
    public static void main(String[] args) {
        //call scanner in order to take input, call ocean and place every ship randomly
        Scanner scanner = new Scanner(System.in);
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();

        do {
            //statistics
            printInfo(ocean);
            //print recent ocean.
            ocean.print();
            System.out.println("Please define x and y coordinates..");
            int xAxis = scanner.nextInt();
            int yAxis = scanner.nextInt();
            //check if shot location containing ship
            if (ocean.shootAt(xAxis, yAxis)) {
                System.out.println("HIT");
            } else {
                System.out.println("MISS");
            }
            //loop till our total sunk count is 10
        } while (!ocean.isGameOver());
    }

    private static void printInfo(Ocean ocean) {
        System.out.println(ocean.getShotsFired() + " Total Shots");
        System.out.println(ocean.getHitCount() + " Total hits");
        System.out.println(ocean.getShipsSunk() + " Total ship sunk");
    }
}
