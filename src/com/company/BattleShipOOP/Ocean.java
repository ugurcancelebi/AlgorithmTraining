package com.company.BattleShipOOP;

import java.util.Random;

public class Ocean {
    private final Ship[][] shipArray = new Ship[10][10];//ship array, will be used to fetch stored ship datas.
    private int totalHits = 0;//number of hits done by the user
    private int shotsFired = 0;//number of shots done by the user
    private int shipSunk = 0;//number of ships that been sunk by the user

    //this constructor creates an empty ocean, every value will be empty sea initially
    public Ocean(){
        for (int i = 0; i < 10;i++){
            for (int j = 0;j < 10;j++){
                EmptySea sea = new EmptySea();
                sea.placeShipAt(i,j,true,this);
            }
        }
    }
    //our initial empty ocean will be filled with ships in that method
    //this method is defined in order to place bigger ships (battleship,cruiser)
    //before in order to avoid finding empty space for the ocean
    public void placeAllShipsRandomly() {
        Ship[] ships = new Ship[10];
        for (int i = 0 ; i < 10; i++){
            switch (i){
                case 0:
                    ships[i] = new Battleship();
                    break;
                case 1:
                case 2:
                    ships[i] = new Cruiser();
                    break;
                case 3:
                case 4:
                case 5:
                    ships[i] = new Destroyer();
                default:
                    ships[i] = new Submarine();
                    break;
            }
        }
        //here we check if our ocean is able to have ship inside
        //if yes, will place ship at desired location given by x,y and isHorizontal params
        Random random = new Random();
        for (Ship ship : ships){
            do {
                int xAxis = random.nextInt(10);
                int yAxis = random.nextInt(10);
                boolean horizontal = random.nextBoolean();
                if (ship.okToPlaceShipAt(xAxis,yAxis,horizontal,this)){
                    ship.placeShipAt(xAxis,yAxis,horizontal,this);
                    break;
                }
            }while (true);
        }
    }
    //indicates that if our x,y location contains any ship inside.
    public boolean isOccupied(int xAxis, int yAxis){
        return !shipArray[xAxis][yAxis].getShipType().equals("empty");
    }

    //this method will return true if our desired x,y coordinates including any ship
    //this method will call our ship's shoot at function.
    public boolean shootAt(int xAxis, int yAxis){
        shotsFired++;
        if (isOccupied(xAxis,yAxis)){
            if (shipArray[xAxis][yAxis].shootAt(xAxis,yAxis)){
                if (shipArray[xAxis][yAxis].isSunk()){
                    shipSunk++;
                }
                totalHits++;
                return true;
            }
            return false;
        }else {
            shipArray[xAxis][yAxis].shootAt(xAxis,yAxis);
        }

        return false;
    }
    //if total sunk ship count is 10, finish game
    public boolean isGameOver(){
        return shipSunk == 10;
    }

    public Ship[][] getShipArray() {
        return shipArray;
    }
    //print entire ocean, 10 by 10 (10 row,10column as desired)
    //there will be an hardcoded implementations in order to have beautified design in our game map
    public void print() {
        System.out.print("  ");
        for (int i = 0;i < 10;i++){
            System.out.print(" " +i  );
        }
        System.out.println();

        for (int i = 0;i < 10;i++){
            System.out.print(i + " ");
            for (int j = 0; j< 10;j++){
                if (shipArray[i][j].wasShootAt(i,j)){
                    System.out.print(shipArray[i][j].toString());
                }else {
                    System.out.print(" -");
                }
            }
            System.out.println();
        }
    }

    //getters
    public int getShotsFired(){
        return shotsFired;
    }
    public int getHitCount(){
        return totalHits;
    }
    public int getShipsSunk(){
        return shipSunk;
    }
}
