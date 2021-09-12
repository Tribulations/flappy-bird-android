package com.example.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapControl
{
    Bitmap background;

    public BitmapControl(Resources res)
    {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
    }

    public Bitmap getBackground()
    {
        return background;
    }

    public int getBackgroundWidth()
    {
        return background.getWidth();
    }

    public int getBackgroundHeight()
    {
        return background.getHeight();
    }
}
