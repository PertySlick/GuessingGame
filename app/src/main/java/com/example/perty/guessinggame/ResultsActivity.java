/* Name: Timothy Roush
 * Date: 10/07/17
 * Filename: ResultsActivity.java
 * Assignment: GuessingGame (#2)
 * Description: Displays the number of attempts it took the user to guess
 *              the randomly generated number while providing an
 *              opportunity to play again.
 */

package com.example.perty.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {


// FIELDS, CONSTANTS, AND OBJECTS


    String intentText;

    Button submit;
    TextView header;
    TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        locateViews();
        readIntents();
        bindFunctionality();
    }

    // Identify necessary views
    private void locateViews() {
        submit = (Button) findViewById(R.id.play_again_button);
        header = (TextView) findViewById(R.id.guess_count_text);
        count = (TextView) findViewById(R.id.guess_count_number);
    }

    // Read and utilize expected intents
    private void readIntents() {
        if (getIntent().hasExtra(GuessingActivity.intentTag)) {
            intentText = getIntent().getStringExtra(GuessingActivity.intentTag);
            count.setText(intentText);
        }
    }

    // Apply functionality to views
    private void bindFunctionality() {
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
                startActivity(intent);
            }

        });
    }
}
