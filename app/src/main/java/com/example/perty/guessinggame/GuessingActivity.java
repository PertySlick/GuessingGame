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

public class GuessingActivity extends AppCompatActivity {


// FIELDS, CONSTANTS, AND OBJECTS


    protected static String intentTag = "count";
    private TextView header;
    private EditText input;
    private Button submit;
    private NumberGuess game;


// METHODS


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);
        locateViews();
        initiateSubroutines();
        bindFunctionality();
    }

    // Identify necessary views
    private void locateViews() {
        submit = (Button) findViewById(R.id.guess_submit);
        header = (TextView) findViewById(R.id.header);
        input = (EditText) findViewById(R.id.guess_input);
    }

    // Initiates the NumberGuess subroutine
    private void initiateSubroutines() {
        game = new NumberGuess();

        int min = game.getMin();
        int max = game.getMax();
        String headerText = getString(R.string.guessing_header, min, max);

        header.setText(headerText);
    }

    // Apply functionality to views
    private void bindFunctionality() {
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

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
        });
    }

    // Reuseable Toast maker
    private void errorToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        input.setText("");
    }
}
