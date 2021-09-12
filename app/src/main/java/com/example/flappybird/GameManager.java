package com.example.flappybird;

import android.graphics.Canvas;

public class GameManager
{
    BgImage bgImage;

    public GameManager()
    {
        bgImage = new BgImage();
    }

    // dont let the background image leave the screen
    public void backgroundAnimation(Canvas canvas)
    {
        bgImage.setX(bgImage.getX() - bgImage.getVelocity());

        if(bgImage.getX() < -AppHolder.getBitmapControl().getBackgroundWidth()) // why the minus sign in front of AppHolder here in the if statement? Needs to have a negative value?
        {
            bgImage.setX(0);
        }

        // draw bitmap on canvas
        canvas.drawBitmap(AppHolder.getBitmapControl().getBackground(), bgImage.getX(), bgImage.getY(), null);
    }
}
