package com.ahn.scarnesdice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button rollButton, holdButton, resetButton;
    TextView scoreText, compScoreText, storeText;
    ImageView dice;
    int score=0, compScore=0, random =0, points=0, x=0, compRandom = 0;
    Intent end = new Intent(getApplicationContext(), EndGame.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreText = (TextView) findViewById(R.id.score);
        compScoreText = (TextView) findViewById(R.id.comp_score);
        rollButton = (Button) findViewById(R.id.roll);
        holdButton = (Button) findViewById(R.id.hold);
        resetButton = (Button) findViewById(R.id.reset);
        dice = (ImageView) findViewById(R.id.dice);
        storeText = (TextView) findViewById(R.id.points);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                random = (int) ((Math.random()*6)+1);
                points+=random;
                switch(random) {
                    case 1:
                        random =0;
                        computerTurn();
                        points = 0;
                        storeText.setText("Points in store: " + points);
                        compScoreText.setText("Computer score: " + compScore);
                        dice.setImageResource(R.drawable.dice1);
                        break;
                    case 2:
                        dice.setImageResource(R.drawable.dice2);
                        break;
                    case 3:
                        dice.setImageResource(R.drawable.dice3);
                        break;
                    case 4:
                        dice.setImageResource(R.drawable.dice4);
                        break;
                    case 5:
                        dice.setImageResource(R.drawable.dice5);
                        break;
                    case 6:
                        dice.setImageResource(R.drawable.dice6);
                        break;
                }
                storeText.setText("Points in store: " + points);
                compScoreText.setText("Computer score: " + compScore);
            }
        });

        holdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += points;
                scoreText.setText("Your score: " + score);
                random = 0;
                points=0;
                computerTurn();
                storeText.setText("Points in store: "+points);
                compScoreText.setText("Computer score: " + compScore);

                if(score>=100){
                    end.putExtra("winner", "You");
                    startActivity(end);
                    finish();
                }

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 0;
                compScore = 0;
                points=0;
                random = 0;
                scoreText.setText("Your score: 0");
                compScoreText.setText("Computer score: 0");
                storeText.setText("Points in store: "+points);
            }
        });
    }

    public void computerTurn(){
        points = 0;
        x = 0;
        compRandom = (int) ((Math.random()*5)+1);
        while((random != 1) && (x<compRandom)){
            random = (int) ((Math.random()*6)+1);
            points += random;
            rollButton.setClickable(false);
            x++;
            if(random==1){
                points=0;
                Toast.makeText(getApplicationContext(), "Computer rolled a 1!", Toast.LENGTH_SHORT).show();
            }
        }

        if(compScore>=100){
            end.putExtra("winner", "Computer");
            startActivity(end);
            finish();
        }
        rollButton.setClickable(true);
        compScore+=points;
        points=0;
        storeText.setText("Points in store: " + points);
    }
}
