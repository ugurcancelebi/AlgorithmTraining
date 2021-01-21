package com.company.BattleShipOOP;

import java.util.Arrays;
//this class represents every other value except the ships.
//the entire field except the ship is being called in our empty sea class
public class EmptySea extends Ship{
    //final value for ship size.
    private static final int SHIP_SIZE = 1;
    //set size of the ship, set hit array for ship and fill every
    //single value to false (initial)
    public EmptySea(){
        setLength(SHIP_SIZE);
        setHit(new boolean[SHIP_SIZE]);
        Arrays.fill(this.getHit(), false);
    }
    @Override
    public String getShipType() {
        return "empty";
    }

    //will return false initially because empty sea can not be sunk
    @Override
    public boolean isSunk() {
        return false;
    }

    //this will be used to print our map
    @Override
    public String toString() {
        return this.getHit()[0] ? " X" : " O";
    }
}
