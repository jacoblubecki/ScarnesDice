package com.ahn.scarnesdice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {
    TextView winnerText;
    Button playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Intent i = getIntent();
        String winner = i.getStringExtra("winner");
        winnerText = (TextView) findViewById(R.id.winner);
        playAgain = (Button) findViewById(R.id.play_again);
        winnerText.setText(winner + " won!");

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reset = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(reset);
                finish();
            }
        });
    }
}
