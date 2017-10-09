/* Name: Timothy Roush
 * Date: 10/07/17
 * Filename: GuessingActivity.java
 * Assignment: GuessingGame (#2)
 * Description: Provides the actual gameplay portion of this app where the user
 *              attempts to guess the randomly generated number in as few tries
 *              as possible.
 */

package com.example.perty.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.perty.numberguess.NumberGuess;

import static android.widget.Toast.LENGTH_SHORT;


/**
 * Initiates and displays the guessing activity
 */
public class GuessingActivity extends AppCompatActivity {


// FIELDS, CONSTANTS, AND OBJECTS


    protected static String intentTag = "count";
    private TextView header;
    private EditText input;
    private Button submit;
    private NumberGuess game;


// METHODS


    /**
     * Initiate output during onCeate stage
     * @param savedInstanceState saved instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);
        locateViews();
        initiateSubroutines();
        bindFunctionality();
    }

    /**
     * Identify necessary views
     */
    private void locateViews() {
        submit = (Button) findViewById(R.id.guess_submit);
        header = (TextView) findViewById(R.id.header);
        input = (EditText) findViewById(R.id.guess_input);
    }


    /**
     * Initiates the NumberGuess subroutine while displaying a prompt to the
     * user explaining the game's current value range.
     */
    private void initiateSubroutines() {
        game = new NumberGuess();

        int min = game.getMin();
        int max = game.getMax();
        String headerText = getString(R.string.guessing_header, min, max);

        header.setText(headerText);
    }


    /**
     * Apply functionality to views
     */
    private void bindFunctionality() {
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                evaluateGuess();
            }
        });
    }


    /**
     * Validates that a guess was submitted.  If it was, the value is evaluated
     * and a toast message is presented accordingly.  If guess matches games
     * target, user is redirected to ResultsActivity
     */
    private void evaluateGuess() {
        if (input.getText().toString().trim().length() == 0) {
            errorToast(getString(R.string.guessing_error_empty));
        } else {
            int guess = Integer.parseInt(input.getText().toString());
            int result = game.checkGuess(guess);

            if (result < 0) {
                errorToast(getString(R.string.guessing_result_low, guess));
            } else if (result > 0) {
                errorToast(getString(R.string.guessing_result_high, guess));
            } else {
                Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                intent.putExtra(intentTag, String.valueOf(game.getGuessCount()));
                startActivity(intent);
            }
        }
    }

    // Reuseable Toast maker
    private void errorToast(String message) {
        Toast.makeText(getApplicationContext(), message, LENGTH_SHORT).show();
        input.setText("");
    }
}
