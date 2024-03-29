package com.example.flappybird;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GamePlay extends SurfaceView implements SurfaceHolder.Callback
{

    MainThread mainThread;

    public GamePlay(Context context)
    {
        super(context);
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        mainThread = new MainThread(surfaceHolder);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder)
    {
        mainThread.setIsRunning(true);
        mainThread.start();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder)
    {
        boolean retry = true;

        while(retry)
        {
            try
            {
                mainThread.setIsRunning(false);
                mainThread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(AppHolder.getGameManager().gameState == 0)
        {
            AppHolder.getGameManager().gameState = 1;
            AppHolder.getSoundPlayer().playSwoosh();
        }
        else
        {
            AppHolder.getSoundPlayer().playWing();
        }

        AppHolder.getGameManager().bird.setVelocity(AppHolder.JUMP_VELOCITY);
        return true;
    }
}
