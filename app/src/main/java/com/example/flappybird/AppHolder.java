package com.example.flappybird;

import android.content.Context;

public class AppHolder
{
    static BitmapControl bitmapControl;
    static GameManager gameManager;
    static int SCREEN_WIDTH_X;
    static int SCREEN_HEIGHT_Y;

    public static void assign(Context context)
    {
        bitmapControl = new BitmapControl(context.getResources());
        gameManager = new GameManager();
    }

    public static BitmapControl getBitmapControl()
    {
        return bitmapControl;
    }

    public static GameManager getGameManager()
    {
        return gameManager;
    }
}
