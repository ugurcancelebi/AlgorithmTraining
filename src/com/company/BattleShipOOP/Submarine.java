package com.company.BattleShipOOP;

import java.util.Arrays;

public class Submarine extends Ship{
    //final value for ship size.
    private static final int SHIP_SIZE = 1;

    //set size of the ship, set hit array for ship and fill every
    //single value to false (initial)
    public Submarine(){

        this.setLength(SHIP_SIZE);
        this.setHit(new boolean[SHIP_SIZE]);
        Arrays.fill(this.getHit(), false);
    }


    @Override
    public String getShipType() {
        return "submarine";
    }
}
