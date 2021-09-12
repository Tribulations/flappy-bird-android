package com.example.flappybird;

import android.graphics.Canvas;

public class GameManager
{
    BgImage bgImage;
    FlyingBird bird;

    public GameManager()
    {
        bgImage = new BgImage();
        bird = new FlyingBird();
    }

    public void birdAnimation(Canvas canvas)
    {
        // apply gravity
        if(bird.getBirdY() < (AppHolder.SCREEN_HEIGHT_Y - AppHolder.getBitmapControl().getBirdHeight() )
                || bird.getVelocity() < 0)
        {
            bird.setVelocity(bird.getVelocity() + AppHolder.gravityPull);
            bird.setBirdY(bird.getBirdY() + bird.getVelocity());
        }

        int currentFrame = bird.getCurrentFrame();
        canvas.drawBitmap(AppHolder.getBitmapControl().getBird(currentFrame), bird.getBirdX(), bird.getBirdY(), null);
        currentFrame++;

        if(currentFrame > bird.maximumFrame)
        {
            currentFrame = 0;
        }

        bird.setCurrentFrame(currentFrame);
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

        if(bgImage.getX() < - (AppHolder.getBitmapControl().getBackgroundWidth() - AppHolder.SCREEN_WIDTH_X) )
        {
            canvas.drawBitmap(AppHolder.getBitmapControl().getBackground(), bgImage.getX() +
                    AppHolder.getBitmapControl().getBackgroundWidth(), bgImage.getY(), null);
        }
    }
}
