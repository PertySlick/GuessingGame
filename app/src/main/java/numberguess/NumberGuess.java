package numberguess;

import java.util.Random;

/**
 * Created by Perty on 10/8/2017.
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
    }


    /**
     * Returns the current number of guess for this game
     * @return int number of guesses
     */
    public int getGuessCount() {
        return guessCount;
    }
}
