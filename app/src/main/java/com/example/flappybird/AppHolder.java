package com.example.flappybird;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppHolder
{
    static BitmapControl bitmapControl;
    static GameManager gameManager;
    static int SCREEN_WIDTH_X;
    static int SCREEN_HEIGHT_Y;
    static int gravityPull;

    public static void assign(Context context)
    {
        // the mapScreenSize method needs to be called first
        mapScreenSize(context);
        bitmapControl = new BitmapControl(context.getResources());
        holdGameVariables();
        gameManager = new GameManager();
    }

    public static void holdGameVariables()
    {
        AppHolder.gravityPull = 5;
    }

    public static BitmapControl getBitmapControl()
    {
        return bitmapControl;
    }

    public static GameManager getGameManager()
    {
        return gameManager;
    }

    private static void mapScreenSize(Context context)
    {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display dsp = manager.getDefaultDisplay();
        DisplayMetrics dMetrics = new DisplayMetrics();
        dsp.getMetrics(dMetrics);

        int width = dMetrics.widthPixels;
        int height = dMetrics.heightPixels;
        AppHolder.SCREEN_WIDTH_X = width;
        AppHolder.SCREEN_HEIGHT_Y = height;
    }
}
