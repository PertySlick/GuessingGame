/* Name: Timothy Roush
 * Date: 10/07/17
 * Filename: LandingActivity.java
 * Assignment: GuessingGame (#2)
 * Description: Displays a landing page that directs user to the actual gamplay
 *              portion of the app.
 */

package com.example.perty.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Initiates and displays the landing page activity.
 */
public class LandingActivity extends AppCompatActivity {


// FIELDS CONSTANTS AND OBJECTS


    private Button submit;


// METHODS


    /**
     * Initiate output during onCeate stage
     * @param savedInstanceState saved instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        locateViews();
        bindFunctionality();
    }

    /**
     * Identify necessary views
     */
    private void locateViews() {
        submit = (Button) findViewById(R.id.submit_button);
    }


    /**
     * Apply functionality to views
     */
    private void bindFunctionality() {
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GuessingActivity.class);
                startActivity(intent);
            }

        });
    }
}
