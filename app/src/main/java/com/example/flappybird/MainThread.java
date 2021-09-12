package com.example.flappybird;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.SurfaceHolder;

public class MainThread extends Thread
{
    SurfaceHolder surfaceHolder;
    long timeSpent;
    long kickOffTime;
    long WAIT = 31; // the time it takes for the frame to refresh in ms
    boolean running;
    private static Canvas canvas;
    public MainThread(SurfaceHolder surfaceHolder)
    {
        this.surfaceHolder = surfaceHolder;
        running = true;
    }

    @Override
    public void run()
    {
        while(running)
        {
            kickOffTime = SystemClock.uptimeMillis();
            canvas = null;
            try
            {
                synchronized (surfaceHolder)
                {
                    canvas = surfaceHolder.lockCanvas();
                    AppHolder.getGameManager().backgroundAnimation(canvas);
                    AppHolder.getGameManager().birdAnimation(canvas);
                    AppHolder.getGameManager().scrollingTube(canvas);
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                if(canvas != null)
                {
                    try
                    {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            timeSpent = SystemClock.uptimeMillis() - kickOffTime;

            if(timeSpent < WAIT)
            {
                try
                {
                    Thread.sleep(WAIT - timeSpent);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isRunning()
    {
        return running;
    }

    public void setIsRunning(boolean state)
    {
        running = state;
    }
}
