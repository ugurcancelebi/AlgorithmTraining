package com.company.AlgorithmTraining;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// This class is the main class of the Hangman
// This is where user input is being called, and then parameters will be passed into Controller.java
public class PlayHangman {

    private static final int GUESS_LEFT = 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char guess;
        int numOfLetter;
        String fileReaderIndex;
        ArrayList<String> wordList = new ArrayList<>();
        ArrayList<Integer> wordLength = new ArrayList<>();

        //Throw an error if short_list.txt has not found
        try(Scanner fileReader = new Scanner(new File("short_list.txt"))){
            while(fileReader.hasNextLine()){
                fileReaderIndex = fileReader.nextLine();
                wordList.add(fileReaderIndex);
                wordLength.add(fileReaderIndex.length());
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

        numOfLetter = wordLength.get(new Random().nextInt(wordLength.size()));
        //Pass parameters into Controller.java
        Controller game = new Controller(numOfLetter, GUESS_LEFT, wordList);

        System.out.println("Welcome to Hangman! \nYour hidden word is down below.. ");
        System.out.println(game.showCurrentBoard());

        //This loop is infinite unless game is over
        //Loop keeps turning and providing data until game is over
        while(!game.gameOver()){
            System.out.println("Please enter a letter: ");
            guess = getLetterInput(sc);
            if(game.play(guess)){
                System.out.println("Your guess was right!");
            }else{
                System.out.println("Wrong letter!");
            }

            System.out.println("------------------------");
            System.out.println(game.showCurrentBoard());

            System.out.println("Number of guesses left: "+ game.getNumOfGuess());

            System.out.println("These letters already guessed.. ");
            System.out.println(game.printGuessedChar());
        }

        if (game.playerWon()){
            System.out.println("You won");
        }else{
            System.out.println("You lost.");
        }

        //Get the final answer, end of the loop, end of the game.
        System.out.println("Final answer is: ");
        System.out.println(game.getFinalAnswer());

        sc.close();
    }

    //Get every character from system as an input
    private static char getLetterInput(Scanner sc){
        while(true){
            if (sc.hasNext()){
                String temp = sc.next();
                if (temp.length()==1 && Character.isLetter(temp.charAt(0))){
                    System.out.println("Your letter is: " + temp.charAt(0));
                    return temp.charAt(0);
                }
            }
            System.out.println("Input is invalid. Please enter one letter: ");
        }
    }
}
