package com.example.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

// class that takes care of the images
public class BitmapControl
{
    Bitmap background;
    Bitmap[] flyingBird;

    public BitmapControl(Resources res)
    {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        background = imageScale(background);
        flyingBird = new Bitmap[3];
        flyingBird[0] = BitmapFactory.decodeResource(res, R.drawable.bird1);
        flyingBird[1] = BitmapFactory.decodeResource(res, R.drawable.bird2);
        flyingBird[2] = BitmapFactory.decodeResource(res, R.drawable.bird3);
    }

    public Bitmap getBird(int frame)
    {
        return flyingBird[frame];
    }

    public int getBirdWidth()
    {
        return flyingBird[0].getWidth();
    }

    public int getBirdHeight()
    {
        return flyingBird[0].getHeight();
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

    public Bitmap imageScale(Bitmap bitmap)
    {
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        int bgScaleWidth = (int) widthHeightRatio * AppHolder.SCREEN_WIDTH_X;
        return Bitmap.createScaledBitmap(bitmap, bgScaleWidth, AppHolder.SCREEN_HEIGHT_Y, false);
    }
}
