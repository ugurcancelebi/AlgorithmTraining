package com.company.BattleShipOOP;


import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {
    @Test
    public void testShips(){
        Ship ship = new Submarine();
        assertEquals("submarine",ship.getShipType());
        assertEquals(1,ship.getLength());

        Ship ship1 = new Battleship();
        assertEquals("battleship",ship1.getShipType());
        assertEquals(4,ship1.getLength());
    }
    @Test
    public void testOkToPlaceShip(){
        Ocean ocean = new Ocean();
        Ship ship = new Destroyer();
        assertTrue(ship.okToPlaceShipAt(5,5,true,ocean));
        assertTrue(ship.okToPlaceShipAt(7,7,false,ocean));
    }

    @Test
    public void testOcean(){
        Ocean ocean = new Ocean();
        for (int i = 0; i < 10; i++){
            for (int j = 0;j< 10; j++){
                String shipType = ocean.getShipArray()[i][j].getShipType();
                assertEquals("empty",shipType);
            }
        }
        assertEquals(0,ocean.getShotsFired());
        assertEquals(0,ocean.getShipsSunk());
        assertEquals(0,ocean.getHitCount());
    }
    @Test
    public void testIsSunk(){
        Ship ship = new Destroyer();
        Ocean ocean = new Ocean();
        ship.placeShipAt(2,2,false,ocean);
        for (int i = 0;i< 3;i++){
            ocean.shootAt(2,i);
        }
    }
    @Test
    public void testIsOccupied(){
        Ocean ocean = new Ocean();
        for (int i= 0;i<10;i++){
            for (int j=0;j<10;j++){
                assertFalse(ocean.isOccupied(i,j));
            }
        }
    }
    @Test
    public void testAllShipsRandomly(){
        int count = 0;
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        for (int i = 0;i<10;i++){
            for (int j=0;j<10;j++){
                if (!ocean.getShipArray()[i][j].getShipType().equals("empty")) {
                    count++;
                }
            }
        }
        assertEquals(17,count);
    }

    @Test
    public void TestShootAt(){
        Ship ship = new Submarine();
        Ocean ocean = new Ocean();
        ship.placeShipAt(4,4,true,ocean);
        ocean.shootAt(4,4);
        ocean.shootAt(0,2);
        ocean.shootAt(1,2);
        assertEquals(1,ocean.getShipsSunk());
        assertEquals(3,ocean.getShotsFired());
        assertEquals(1,ocean.getHitCount());
    }

    @Test
    public void TestShipInstances(){
        Ship submarine = new Submarine();
        Ship destroyer = new Destroyer();
        Ship battleShip = new Battleship();

        assertTrue(submarine instanceof Submarine);
        assertTrue(destroyer instanceof Destroyer);
        assertTrue(battleShip instanceof Battleship);
    }
}
