package com.example.flappybird;

public class FlyingBird
{
    private int birdX, birdY, currentFrame, velocity;
    public static int maximumFrame;

    public FlyingBird()
    {
        // show bird iun the center of screen
        birdX = AppHolder.SCREEN_WIDTH_X / 2 - AppHolder.getBitmapControl().getBirdWidth() / 2;
        birdY = AppHolder.SCREEN_HEIGHT_Y / 2 - AppHolder.getBitmapControl().getBirdHeight() / 2;
        currentFrame = 0;
        maximumFrame = 2;
    }

    public int getBirdX()
    {
        return birdX;
    }

    public void setBirdX(int birdX)
    {
        this.birdX = birdX;
    }

    public int getBirdY()
    {
        return birdY;
    }

    public void setBirdY(int birdY)
    {
        this.birdY = birdY;
    }

    public int getCurrentFrame()
    {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame)
    {
        this.currentFrame = currentFrame;
    }

    public int getVelocity()
    {
        return velocity;
    }

    public void setVelocity(int velocity)
    {
        this.velocity = velocity;
    }
}
