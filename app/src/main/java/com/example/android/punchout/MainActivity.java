package com.example.android.punchout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int blueScore = 0;
    private int redScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayForBlue(blueScore);
        displayForRed(redScore);
    }

    /**
     * Reset button
     */

    public void reset(View view) {

        blueScore = 0;
        redScore = 0;
        displayForBlue(blueScore);
        displayForRed(redScore);
        TextView redOrBlue = findViewById(R.id.winner);
        redOrBlue.setText(String.valueOf(""));

    }

    /**
     * Blue functions from here
     */

    public void blueHighPunch(View view) {

        blueScore = blueScore >= 50 ? 50 : blueScore + 6;
        displayForBlue(blueScore);
        displayWinner();
    }

    public void blueLowPunch(View view) {

        blueScore = blueScore >= 50 ? 50 : blueScore + 3;
        displayForBlue(blueScore);
        displayWinner();
    }

    public void blueDodge(View view) {

        redScore = redScore <= 0 ? 0 : redScore - 1;
        displayForRed(redScore);
    }

    /**
     * Red functions from here
     */

    public void redHighPunch(View view) {

        redScore = redScore >= 50 ? 50 : redScore + 6;
        displayForRed(redScore);
        displayWinner();
    }

    public void redLowPunch(View view) {

        redScore = redScore >= 50 ? 50 : redScore + 3;
        displayForRed(redScore);
        displayWinner();
    }

    public void redDodge(View view) {

        blueScore = blueScore <= 0 ? 0 : blueScore - 1;
        displayForBlue(blueScore);
    }

    /**
     * Displays the given score for Blue.
     */
    public void displayForBlue(int score) {
        TextView scoreView = findViewById(R.id.blue_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Red.
     */
    public void displayForRed(int score) {
        TextView scoreView = findViewById(R.id.red_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the winner.
     */

    public void displayWinner() {
        TextView redOrBlue = findViewById(R.id.winner);

        if (blueScore >= 50) {
            redOrBlue.setText(String.valueOf("  BLUE WINS!"));
        }
        if (redScore >= 50) {
            redOrBlue.setText(String.valueOf("  RED WINS!"));
        }
    }
}
