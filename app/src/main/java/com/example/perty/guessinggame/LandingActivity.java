package com.example.perty.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LandingActivity extends AppCompatActivity {


// VARIABLES CONSTANTS AND OBJECTS


    Button submit;
    TextView header;


// METHODS


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        locateViews();
        bindFunctionality();
    }

    // Identify necessary views
    private void locateViews() {
        submit = (Button) findViewById(R.id.submit_button);
        header = (TextView) findViewById(R.id.header);
    }

    // Apply functionality to views
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
