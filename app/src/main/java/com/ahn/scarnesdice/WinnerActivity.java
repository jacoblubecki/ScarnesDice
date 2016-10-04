package com.ahn.scarnesdice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Jacob on 10/3/16.
 */

public class WinnerActivity extends AppCompatActivity {

    TextView winnerText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        winnerText = (TextView) findViewById(R.id.winner_text);

        Intent startIntent = getIntent();
        String winnerString = startIntent.getStringExtra("WINNER");

        winnerText.setText("The winner was " + winnerString + "!");
    }
}
