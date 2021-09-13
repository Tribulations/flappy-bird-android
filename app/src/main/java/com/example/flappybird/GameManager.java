package com.example.flappybird;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class GameManager
{
    private static final String TAG = "GameManager";
    
    BgImage bgImage;
    FlyingBird bird;
    static int gameState;
    ArrayList<TubeCollection> tubeCollections;
    Random rand;
    int scoreCount;
    int winningTube;
    Paint designPaint; // show the score

    public GameManager()
    {
        bgImage = new BgImage();
        bird = new FlyingBird();
        gameState = 0;
        tubeCollections = new ArrayList<>();
        rand = new Random();
        generateTubeObject();
        // format the score text
        initScoreVariables();
    }

    public void initScoreVariables()
    {
        scoreCount = 0;
        winningTube = 0;
        designPaint = new Paint();
        designPaint.setColor(Color.YELLOW);
        designPaint.setTextSize(250);
        designPaint.setStyle(Paint.Style.FILL);
        designPaint.setFakeBoldText(true);
        designPaint.setShadowLayer(5.0f, 20.0f, 20.0f, Color.BLACK);
    }

    public void generateTubeObject()
    {
        for(int i = 0; i < AppHolder.tubeNumbers; ++i)
        {
            int tubeX = AppHolder.SCREEN_WIDTH_X + i * AppHolder.tubeDistance;
            int upTubeCollectionY = AppHolder.minimumTubeCollection_Y;
            rand.nextInt(AppHolder.maximumTubeCollection_Y - AppHolder.minimumTubeCollection_Y + 1);
            TubeCollection tubeCollection = new TubeCollection(tubeX, upTubeCollectionY);
            tubeCollections.add(tubeCollection);
        }
    }

    public void scrollingTube(Canvas canvas)
    {
        Log.d(TAG, "scrollingTube: called");

        if(gameState == 1)
        {
            // collisions
            if((tubeCollections.get(winningTube).getXTube() < bird.getBirdX() + AppHolder.getBitmapControl().getBirdWidth())
                    && (tubeCollections.get(winningTube).getUpTubeCollection_Y() > bird.getBirdY()
                    || tubeCollections.get(winningTube).getDownTube_Y() < ( bird.getBirdY() + AppHolder.getBitmapControl().getBirdHeight())) )
            {
                gameState = 2;

                AppHolder.getSoundPlayer().playChrash();

                Context mContext = AppHolder.gameActivityContext;
                Intent mIntent = new Intent(mContext, GameOverActivity.class);

                mIntent.putExtra("score", scoreCount);
                mContext.startActivity(mIntent);
                ((Activity)mContext).finish();
            }

            // check if left side of bird is past the right side of a tube.
            if(tubeCollections.get(winningTube).getXTube() < bird.getBirdX() - AppHolder.getBitmapControl().getTubeWidth())
            {
                scoreCount++;
                winningTube++;
                // play score sound
                AppHolder.getSoundPlayer().playPing();

                if(winningTube > AppHolder.tubeNumbers - 1)
                {
                    winningTube = 0;
                }
            }

            for(int i = 0; i < AppHolder.tubeNumbers; ++i)
            {
                if(tubeCollections.get(i).getXTube() < -AppHolder.getBitmapControl().getTubeWidth())
                {
                    tubeCollections.get(i).setXTube(tubeCollections.get(i).getXTube()
                    + AppHolder.tubeNumbers * AppHolder.tubeDistance);

                    int upTubeCollectionY = AppHolder.minimumTubeCollection_Y +
                            rand.nextInt(AppHolder.maximumTubeCollection_Y - AppHolder.minimumTubeCollection_Y + 1);

                    tubeCollections.get(i).setUpTubeCollection_Y(upTubeCollectionY);
                }

                tubeCollections.get(i).setXTube(tubeCollections.get(i).getXTube() - AppHolder.tubeVelocity);

                // draw the upTube and downTube on the canvas
                canvas.drawBitmap(AppHolder.getBitmapControl().getUpTube(), tubeCollections.get(i).getXTube(),
                        tubeCollections.get(i).getUpTube_Y(), null);

                canvas.drawBitmap(AppHolder.getBitmapControl().getDownTube(), tubeCollections.get(i).getXTube(),
                        tubeCollections.get(i).getDownTube_Y(), null);
            }

            // render the score
            canvas.drawText(String.valueOf(scoreCount), AppHolder.SCREEN_WIDTH_X / 2  - AppHolder.getBitmapControl().getBirdWidth() / 2, 400, designPaint);
        }
    }

    public void birdAnimation(Canvas canvas)
    {
        if(gameState == 1)
        {
            // apply gravity
            if(bird.getBirdY() < (AppHolder.SCREEN_HEIGHT_Y - AppHolder.getBitmapControl().getBirdHeight() )
                    || bird.getVelocity() < 0)
            {
                bird.setVelocity(bird.getVelocity() + AppHolder.gravityPull);
                bird.setBirdY(bird.getBirdY() + bird.getVelocity());
            }
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
