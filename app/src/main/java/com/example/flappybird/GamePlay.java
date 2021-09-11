package com.example.flappybird;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GamePlay extends SurfaceView implements SurfaceHolder.Callback
{

    public GamePlay(Context context)
    {
        super(context);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder)
    {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height)
    {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder)
    {

    }
}
