package com.ahn.scarnesdice;

/**
 * Created by Jacob on 9/26/16.
 */

public class ScarnesDice {

    final int PLAYER_ONE = 1;
    final int PLAYER_2 = 2;

    final int FACES = 6;

    final int WINNING_SCORE = 100;

    // Scores

    int playerOneScore = 0;
    int playerTwoScore = 0;

    int currentScore = 0;


    // Who's turn?

    boolean isPlayerTurn = true;


    // Methods

    int roll() {
        int rolledNumber = (int) (Math.random() * FACES) + 1;

        return rolledNumber;
    }
}
