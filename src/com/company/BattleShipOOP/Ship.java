package com.company.BattleShipOOP;

//abstraction reason for this class is there will not be any ship class,
//every class we initialized will be called from Ship, therefore ship class will not be called.
public abstract class Ship {

    private int globalRow;//global row variable for access values between 0-9
    private int globalColumn;//global column variable for access values between 0-9
    private int length;//size taken by ship, every length defined its in own class
    private boolean horizontal;//define if ship is horizontal
    boolean[] hit;//hit array for the ships, size defined for submarine = 1, destroyer = 3 and so on.

    //initializer, will be used in our method do assign to our global variables
    private void setParamValues(int xAxis, int yAxis, boolean isHorizontal){
        globalRow = xAxis;
        globalColumn = yAxis;
        horizontal = isHorizontal;
    }
    //getters and setters
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean[] getHit() {
        return hit;
    }

    public void setHit(boolean[] hit) {
        this.hit = hit;
    }
    //will return 0 ship has been sunk, if not, will insert ?. means that
    //ship has been hit, but not been sunk yet..
    @Override
    public String toString() {
        return isSunk() ? " O" : " ?";
    }
    //return ship type
    public abstract String getShipType();

    //boolean method to check if our ship is able to being put in our ocean
    //in this method all validations being checked if our ship has been overlapped by the other

    public boolean okToPlaceShipAt(int row,int column,boolean horizontal,Ocean ocean){
        if (!horizontal){
            if (getLength() + row > 10){
                return false;
            }
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = column - 1; j < column + getLength() + 1; j++) {
                    try {
                        if (!ocean.getShipArray()[i][j].getShipType().equals("empty")) {
                            return false;
                        }
                    } catch (Exception ignored) {}
                }
            }
        } else {
            if (column + getLength() > 10)
                return false;

            for (int i = row - 1; i <= row + 1 ; i++){
                for (int j = column - 1; j < getLength() + column + 1; j++) {
                    try {
                        if (!ocean.getShipArray()[i][j].getShipType().equals("empty"))
                            return false;
                    } catch (Exception ignored) {}
                }
            }
        }
        return true;
    }

    //method to put ship at the ocean,

    /*
     * @param row
     * @param column
     * @param isHorizontal
     * @param ocean
     * set row and column values and insert our ship("this") class inside our ocean.
     * if its horizontal, then put it through the x axis,
     * if its vertical then put it through the y axis
     */
    public void placeShipAt(int row, int column, boolean isHorizontal, Ocean ocean){
        setParamValues(row,column,isHorizontal);

        if (isHorizontal) {
            for (int j = column; j < column + getLength(); j++) {
                ocean.getShipArray()[row][j] = this;
            }
        } else {
            for (int i = row; i < row + getLength(); i++) {
                ocean.getShipArray()[i][column] = this;
            }
        }
    }
    //method to check if every part of the ship has been shot
    public boolean isSunk(){
        for (boolean isHit : hit){
            if (!isHit)
                return false;
        }
        return true;
    }

    //method to check ship has been shoot at the desired locations.
    public boolean wasShootAt(int row, int col){
        return horizontal ? hit[col - globalColumn]  : hit[row - globalRow];
    }

    //if any part of the ship is being occupied by the given x,y values..
    //and if ship has been sunk. define ship as hit. and return true, if not. return false
    public boolean shootAt(int xAxis,int yAxis){
        if (isSunk())
            return false;

        else {
            if (!horizontal){
                if (xAxis < globalRow + length && xAxis == globalColumn) {
                    hit[xAxis - this.globalRow] = true;
                    return true;
                }
            } else {
                if (yAxis < globalColumn + length && xAxis == globalRow ) {
                    hit[yAxis - globalColumn] = true;
                    return true;
                }
            }
        }
        return false;
    }
}
