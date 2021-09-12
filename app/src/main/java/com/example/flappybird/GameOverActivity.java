package com.example.flappybird;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GameOverActivity extends AppCompatActivity
{
    private static final String TAG = "GameOverActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
    }
}