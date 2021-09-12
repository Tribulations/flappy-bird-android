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
    static int JUMP_VELOCITY;
    static int tubeGap;
    static int tubeNumbers;
    static int tubeVelocity;
    static int minimumTubeCollection_Y;
    static int maximumTubeCollection_Y;
    static int tubeDistance;
    static Context gameActivityContext;

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
        JUMP_VELOCITY =- 50;
        AppHolder.tubeGap = 650;
        tubeNumbers = 2;
        tubeVelocity = 24;
        minimumTubeCollection_Y = (int) (AppHolder.tubeGap / 2.0);
        maximumTubeCollection_Y = AppHolder.SCREEN_HEIGHT_Y - AppHolder.minimumTubeCollection_Y - AppHolder.tubeGap;
        AppHolder.tubeDistance = AppHolder.SCREEN_WIDTH_X * 2 / 3;
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
