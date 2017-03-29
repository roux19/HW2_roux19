package com.example.thema_000.hw2_roux19;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by thema_000 on 3/27/2017.
 */

public class Snowball {

    //shape and position
    float radius;
    float xCenter;
    float yCenter;

    //name to be displayed when selected
    String name;

    //color
    int red;
    int green;
    int blue;

    /**
     * Snowball
     * real simple constructor
     * @param initRadius
     * @param initX
     * @param initY
     * @param initName
     * @param initRed
     * @param initGreen
     * @param initBlue
     */
    public Snowball( float initRadius, float initX, float initY, String initName, int initRed, int initGreen, int initBlue)
    {
        radius = initRadius;
        xCenter = initX;
        yCenter = initY;
        name = initName;
        red = initRed;
        green = initGreen;
        blue = initBlue;

    }

    /**
     * draw
     * called in PaintSnowmen onDraw
     * draws snowmen onto canvas
     * @param c
     */
    public void draw(Canvas c)
    {
        //make a paint from rgb values
        Paint tempPaint = new Paint();
        tempPaint.setARGB(255, red, green, blue);

        //draw it
        c.drawOval( xCenter-radius, yCenter-radius, xCenter+radius, yCenter+radius, tempPaint );
    }

    /**
     * contains
     * tells whether this snowball contains a point on the canvas
     * called in onTouch meathod
     * returns true if the point is on the snowman
     * @param x
     * @param y
     * @return
     */
    public boolean contains( float x, float y)
    {
        //distance formaula
        float distToCenter = (float)Math.sqrt((xCenter-x)*(xCenter-x)+(yCenter-y)*(yCenter-y));

        //if distance is bigger than radius this snowball does not contain this point
        if ( distToCenter > radius ) return false;
        //otherwise it does
        else return true;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }
}
