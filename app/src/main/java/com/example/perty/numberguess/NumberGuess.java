package com.example.perty.numberguess;

import java.util.Random;

/**
 * Constructs and manages an instance of the Number Guessing game.
 * @author Timothy Roush
 * @version 1.0
 */

public class NumberGuess {


// FIELDS, CONSTANTS, AND OBJECTS

    private static final int DEFAULT_MIN = 0;
    private static final int DEFAULT_MAX = 20;

    private int min;
    private int max;
    private int targetNumber;
    private int guessCount = 0;

    private Random rg = new Random();


// CONSTRUCTORS


    public NumberGuess() {
        this.min = DEFAULT_MIN;
        this.max = DEFAULT_MAX;
        setTarget();
    }

    public NumberGuess(int min, int max) {
        this.min = min;
        this.max = max;
        setTarget();
    }


// METHODS


    // Sets the target number to a random int value
    private void setTarget() {
        targetNumber = rg.nextInt((max - min) + 1) + min;
        System.out.println("Target Number = " + targetNumber);
    }

    /**
     * Checks supplied value against the target value.  Return the difference
     * between the two values as an indicator of too high, too low, or correct.
     * Also increments the guess counter in the process.
     * @param guess int value entered by player
     * @return int negative value indicates too low, positive value indicates
     *         too high, and 0 indicates a match to target.
     */
    public int checkGuess(int guess) {
        guessCount++;
        return guess - targetNumber;
    }


    /**
     * Returns the current number of guess for this game
     * @return int number of guesses
     */
    public int getGuessCount() {
        return guessCount;
    }


    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
