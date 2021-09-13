package com.example.flappybird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.PrimitiveIterator;

public class GameOverActivity extends AppCompatActivity
{
    private static final String TAG = "GameOverActivity";
    private Button mBtnRestart;
    private TextView txtBest, txtScore;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        initViews();

        int scoreCount = getIntent().getExtras().getInt("score");

        // get from sharedpref
        SharedPreferences sharedPreferences = getSharedPreferences("myStoragePreference", MODE_PRIVATE);
        int scoreBest = sharedPreferences.getInt("scoreBest", 0);

        // edti shared pref
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();
        if(scoreCount > scoreBest)
        {
            scoreBest = scoreCount;
            sharedPrefEditor.putInt("scoreBest", scoreBest);
            //sharedPrefEditor.commit(); // whats the difference between commit and apply()?
            sharedPrefEditor.apply();
        }

        mBtnRestart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        txtScore.setText(String.valueOf(scoreCount));
        txtBest.setText(String.valueOf(scoreBest));
    }

    private void initViews()
    {
        mBtnRestart = findViewById(R.id.btnRestart);
        txtBest = findViewById(R.id.txtBest);
        txtScore = findViewById(R.id.txtScore);
    }
}