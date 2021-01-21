package com.company.BattleShipOOP;

import java.util.Arrays;

public class Cruiser extends Ship{
    //final value for ship size.
    private static final int SHIP_SIZE = 3;

    //set size of the ship, set hit array for ship and fill every
    //single value to false (initial)
    public Cruiser(){
        setLength(SHIP_SIZE);
        setHit(new boolean[SHIP_SIZE]);
        Arrays.fill(this.getHit(), false);
    }


    @Override
    public String getShipType() {
        return "cruiser";
    }
}
