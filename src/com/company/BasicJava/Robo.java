package com.company.BasicJava;
// Java program to demonstrate working of Robot
// class. This program is for Windoes. It opens
// notepad and types a message.
import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.Random;

public class Robo {
    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        /*
         * String command = "notepad.exe"; Runtime run = Runtime.getRuntime();
         * run.exec(command); try { Thread.sleep(2000); } catch (InterruptedException e)
         * { // TODO Auto-generated catch block e.printStackTrace(); }
         */
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        int rand_int2 = rand.nextInt(1000);
        boolean i = true;
        int counter = 0;
        // Create an instance of Robot class
        Robot robot = new Robot();
        while (i) {
            robot.mouseMove(rand_int1, rand_int2);
            counter += 1;
            Thread.sleep(5000);
            rand_int1 = rand.nextInt(1000);
            rand_int2 = rand.nextInt(1000);
            // if(counter>5000000) {break;}
        }
        /*
         * // Press keys using robot. A gap of // of 500 mili seconds is added after //
         * every key press robot.keyPress(KeyEvent.VK_H); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_E); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_L); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_L); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_O); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_SPACE); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_F); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_R); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_O); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_M); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_SPACE); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_G); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_E); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_E); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_K); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_S); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_F); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_O); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_R); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_G); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_E); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_E); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_K); Thread.sleep(500);
         * robot.keyPress(KeyEvent.VK_S);
         */
    }
}
