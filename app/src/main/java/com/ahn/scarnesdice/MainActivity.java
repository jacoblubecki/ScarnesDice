package com.ahn.scarnesdice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // region Constants

    /**
     * The number of faces on the die.
     */
    private static final int FACES = 6;

    /**
     * The score that will decide the winning player.
     */
    private static final int WINNING_SCORE = 100;

    // endregion

    // region Game Variables

    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    /**
     * The accumulated score for the current player's turn.
     */
    private int currentScore = 0;

    /**
     * True if it is the human player's turn. False if the computer is playing its turn.
     */
    private boolean isHumanTurn = true;

    // endregion

    // region UI Elements

    private ImageView diceImage;
    private TextView playerOneScoreText;
    private TextView playerTwoScoreText;
    private TextView currentScoreText;

    // endregion

    // region Life Cycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceImage = (ImageView) findViewById(R.id.dice_image);
        playerOneScoreText = (TextView) findViewById(R.id.player_1_score);
        playerTwoScoreText = (TextView) findViewById(R.id.player_2_score);
        currentScoreText = (TextView) findViewById(R.id.current_score);
    }

    // endregion

    // region Button Clicks

    /**
     * Rolls the die. Any number except one is added to the currentScore variable. If a one is
     * rolled, current score becomes zero and the player's turn ends.
     *
     * @param view the view that was pressed.
     */
    public void roll(View view) {
        int rolledNumber = (int) (Math.random() * FACES) + 1;

        switch (rolledNumber) {
            case 1:
                diceImage.setImageResource(R.drawable.dice1);
                break;
            case 2:
                diceImage.setImageResource(R.drawable.dice2);
                break;
            case 3:
                diceImage.setImageResource(R.drawable.dice3);
                break;
            case 4:
                diceImage.setImageResource(R.drawable.dice4);
                break;
            case 5:
                diceImage.setImageResource(R.drawable.dice5);
                break;
            case 6:
                diceImage.setImageResource(R.drawable.dice6);
                break;
        }

        if(rolledNumber == 1) {
            currentScore = 0;
            isHumanTurn = !isHumanTurn;

            if(!isHumanTurn) {
                runComputerPlayer();
            }
        } else {
            currentScore += rolledNumber;
        }

        updateUI();
    }

    /**
     * Adds currentScore to the current player's score. The player's turn then ends.
     *
     * @param view the view that was clicked.
     */
    public void hold(View view) {
        if(isHumanTurn) {
            playerOneScore += currentScore;
        } else {
            playerTwoScore += currentScore;
        }

        isHumanTurn = !isHumanTurn;
        currentScore = 0;

        boolean playerOneWinner = playerOneScore >= WINNING_SCORE;
        boolean playerTwoWinner = playerTwoScore >= WINNING_SCORE;

        if(playerOneWinner || playerTwoWinner) {
            if (playerOneWinner) {
                showWinner("Player 1");
                reset(null);
            } else if (playerTwoWinner) {
                showWinner("Player 2");
                reset(null);
            }
        } else {
            if(!isHumanTurn) {
                runComputerPlayer();
            }
        }

        updateUI();
    }

    /**
     * Resets the current game.
     *
     * @param view the view that was clicked.
     */
    public void reset(View view) {
        currentScore = 0;
        playerOneScore = 0;
        playerTwoScore = 0;

        updateUI();
    }

    // endregion

    // region Helper

    /**
     * Make the UI display updated information.
     */
    private void updateUI() {
        playerOneScoreText.setText("Player 1: " + playerOneScore);
        playerTwoScoreText.setText("Player 2: " + playerTwoScore);
        currentScoreText.setText(String.valueOf(currentScore));
    }

    /**
     * Let the computer take its turn.
     */
    private void runComputerPlayer() {
        int numberOfRolls = (int) (Math.random() * 5) + 1; // 1 to 5 inclusive

        while(!isHumanTurn && numberOfRolls >= 0) {
            roll(null); // only changes turn if a 1 is rolled

            numberOfRolls--;
        }

        if(!isHumanTurn) {
            hold(null); // always changes turn
        }

        updateUI();
    }

    /**
     * Show the winner!
     */
    private void showWinner(String winner) {
        Intent newIntent = new Intent(getApplicationContext(), WinnerActivity.class);
        newIntent.putExtra("WINNER", winner);
        startActivity(newIntent);
    }

    // endregion
}
