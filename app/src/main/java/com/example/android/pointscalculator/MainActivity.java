package com.example.android.pointscalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB=0;
    int clrWinner = Color.rgb(100, 255, 100);
    int clrLoser = Color.rgb(255, 100, 100);
    int clrTie = Color.rgb(100, 100, 255);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addOneForTeamA(View v) {
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA+=2;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA+=3;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
        setColor(scoreTeamA-scoreTeamB,scoreView);
        updateCommentText();
    }

    public void addOneForTeamB(View v) {
        scoreTeamB+=1;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB+=2;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        scoreTeamB+=3;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
        setColor(scoreTeamB-scoreTeamA,scoreView);
        updateCommentText();
    }

    public void setColor(int pointsDiff,TextView text)
    {
        if(pointsDiff>0)
            text.setTextColor(clrWinner);
        else if(pointsDiff<0)
            text.setTextColor(clrLoser);
        else
            text.setTextColor(clrTie);
    }

    public void updateCommentText()
    {
        TextView scoreView = (TextView) findViewById(R.id.comment);
        String scoreDiff;
        if(scoreTeamA-scoreTeamB>0)
        {
            scoreDiff = String.valueOf(scoreTeamA-scoreTeamB);
            String comment = "Team A is leading!\nwinning "+scoreDiff+" scores";
            scoreView.setText(comment);
        }
        else if(scoreTeamA-scoreTeamB<0)
        {
            scoreDiff = String.valueOf(scoreTeamB-scoreTeamA);
            String comment = "Team B is leading!\nwinning "+scoreDiff+" scores";
            scoreView.setText(comment);
        }
        else
        {
            String comment = "Team A and Team B\nties in scores!";
            scoreView.setText(comment);
        }
    }

    public void reset(View v)
    {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
