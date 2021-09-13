package com.example.flappybird;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundPlayer
{
    private Context mContext;
    private MediaPlayer move, score, crash, jump;


    public SoundPlayer(Context mContext)
    {
        this.mContext = mContext;
        move = MediaPlayer.create(mContext, R.raw.swoosh);
        score = MediaPlayer.create(mContext, R.raw.ping);
        crash = MediaPlayer.create(mContext, R.raw.hit);
        jump = MediaPlayer.create(mContext, R.raw.wing);
    }

    public void playSwoosh()
    {
        if(move != null)
        {
            move.start();
        }
    }

    public void playPing()
    {
        if(score != null)
        {
            score.start();
        }
    }

    public void playChrash()
    {
        if(crash != null)
        {
            crash.start();
        }
    }

    public void playWing()
    {
        if(jump != null)
        {
            jump.start();
        }
    }
}
