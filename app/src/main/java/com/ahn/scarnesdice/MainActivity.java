package com.ahn.scarnesdice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // UI Elements
    ImageView diceImage;

    TextView playerOneScoreText;
    TextView playerTwoScoreText;
    TextView currentScoreText;

    ScarnesDice game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceImage = (ImageView) findViewById(R.id.dice_image);
        playerOneScoreText = (TextView) findViewById(R.id.player_1_score);
        playerTwoScoreText = (TextView) findViewById(R.id.player_2_score);
        currentScoreText = (TextView) findViewById(R.id.current_score);

        game = new ScarnesDice();
    }

    public void roll(View view) {
        int rolledNumber = game.roll();

        switch (rolledNumber) {
            case 1: diceImage.setImageResource(R.drawable.dice1);
                break;
            case 2: diceImage.setImageResource(R.drawable.dice2);
                break;
            case 3: diceImage.setImageResource(R.drawable.dice3);
                break;
            case 4: diceImage.setImageResource(R.drawable.dice4);
                break;
            case 5: diceImage.setImageResource(R.drawable.dice5);
                break;
            case 6: diceImage.setImageResource(R.drawable.dice6);
                break;
        }
    }

    public void hold(View view) {

    }

    public void reset(View view) {

    }
}
