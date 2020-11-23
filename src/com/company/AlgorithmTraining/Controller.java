package com.company.AlgorithmTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

// Controller of the hangman, this is where the implementations of evil hangman being called
public class Controller {
    private final int numOfLetter;
    private int numOfGuess;
    private ArrayList<String> wordList;
    private String output;
    private String finalAnswer;
    private final ArrayList<Character> guessed = new ArrayList<>();

    //Constructor to get letterNumber, guessNumber and dictionary data
    public Controller(int numOfLetter, int numOfGuess, ArrayList<String> dictionary) {
        this.numOfLetter = numOfLetter;
        this.numOfGuess = numOfGuess;
        wordList = new ArrayList<>();

        // Set initial output: "_" for all possible letter positions
        char[] outputArray = new char[numOfLetter];
        for (int i = 0; i < numOfLetter; i++) {
            outputArray[i] = '_';
        }

        output = new String(outputArray);

        // Simply adding all words in dictionary with appropriate length to our own word list.
        wordList.addAll(dictionary.stream().filter(word -> word.length() == numOfLetter).collect(Collectors.toList()));
    }


    public boolean play(char guess) {
        String temp = output;
        boolean guessRight;
        HashMap<String, ArrayList<String>> wordChoices = new HashMap<>();

        if (gameOver()) {
            System.out.println("Game Over");
            return playerWon();
        }

        // Parse all words in word list to create keys for the hash map
        for (String word : wordList) {
            char[] key = new char[numOfLetter];

            for (int index = 0; index < numOfLetter; index++) {
                if (word.charAt(index) == guess) {
                    key[index] = guess;
                } else {
                    key[index] = output.charAt(index);
                }
            }

            String keyString = new String(key);
            addWordChoice(keyString, word, wordChoices);
        }

        // Implementing the last guess situation as in write up
        if (numOfGuess == 1) {
            // if output is present in HashMap, then there are words available without the guessed letter
            if (wordChoices.containsKey(output)) {

                // Then simply do the update and return false. Game over!
                wordList = new ArrayList<>(wordChoices.get(output));
                numOfGuess--;
                finalAnswer = wordChoices.get(output).get(0);
                guessed.add(guess);
                return false;
            }
        }

        // If not in above situation:
        for (String keyString : wordChoices.keySet()) {
            if (!wordChoices.containsKey(temp)) {
                temp = keyString;
            }

            // Then go through all word families to find the one with the most possible words
            if (wordChoices.get(keyString).size() > wordChoices.get(temp).size()) {
                temp = keyString;
            }

        }

        // handle cases where the word list is empty (if case we change the dictionary)
        if (wordChoices.containsKey(temp)) {

            // Shallow copy of the max value in word choices
            wordList = new ArrayList<>(wordChoices.get(temp));
            guessRight = !temp.equals(output);

            if (!guessRight) numOfGuess--;

            output = temp;
            finalAnswer = wordChoices.get(output).get(0);
            guessed.add(guess);
            return guessRight;

        } else {
            // when word list is empty, just return false...
            wordList = new ArrayList<>();
            guessed.add(guess);
            return false;
        }

    }

    //return number of guess left
    public int getNumOfGuess() {
        return numOfGuess;
    }

    //check if game is over
    public boolean gameOver() {
        return numOfGuess == 0 || !output.contains("_") || wordList.isEmpty();
    }

    //show recent board with updated values
    public String showCurrentBoard() {
        char[] formattedOutput = output.toCharArray();
        return Arrays.toString(formattedOutput);
    }

    //append word to the hashmap, if key does not exists yet. create arraylist and append word
    private void addWordChoice(String key, String word, HashMap<String, ArrayList<String>> wordChoiceMap) {
        wordChoiceMap.computeIfAbsent(key, k -> new ArrayList<>());
        wordChoiceMap.get(key).add(word);
    }

    //check if player won
    public boolean playerWon() {
        if (!gameOver()) {
            System.out.println("Game not over");
            return false;
        } else {
            return !output.contains("_");
        }
    }

    //return guessed character
    public String printGuessedChar() {
        return guessed.toString();
    }

    //return final answer, only if game is over
    public String getFinalAnswer() {
        if (gameOver()) {
            return finalAnswer;
        } else {
            return null;
        }
    }
}