package com.example.flappybird;

import java.util.Random;

public class TubeCollection
{
    private int xTube;
    private int upTubeCollection_Y;
    private Random rand;
    private int coloredTube;

    public TubeCollection(int xTube, int upTubeCollection_Y)
    {
        this.xTube = xTube;
        this.upTubeCollection_Y = upTubeCollection_Y;
        rand = new Random();
    }

    public void setColoredTube()
    {
        coloredTube = rand.nextInt(2);
    }

    public int getColoredTube()
    {
        return coloredTube;
    }

    public int getXTube()
    {
        return xTube;
    }

    public int getUpTubeCollection_Y()
    {
        return upTubeCollection_Y;
    }

    public int getUpTube_Y()
    {
        return upTubeCollection_Y - AppHolder.getBitmapControl().getTubeHeight();
    }

    public int getDownTube_Y()
    {
        return upTubeCollection_Y + AppHolder.tubeGap;
    }

    public void setXTube(int xTube)
    {
        this.xTube = xTube;
    }

    public void setUpTubeCollection_Y(int upTubeCollection_Y)
    {
        this.upTubeCollection_Y = upTubeCollection_Y;
    }
}
