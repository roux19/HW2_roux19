package com.example.thema_000.hw2_roux19;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by thema_000 on 3/27/2017.
 */

public class PaintSnowmen extends SurfaceView {

    //all of the snowballs of a snowman
    Snowball[] snowballs = new Snowball[6];

    public PaintSnowmen(Context context) {
        super(context);
        this.initialization();
    }

    public PaintSnowmen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.initialization();
    }

    public PaintSnowmen(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        this.initialization();
    }

    public  PaintSnowmen(Context context, AttributeSet attributeSet, int defStyle, int anotherThing) {
        super(context, attributeSet, defStyle, anotherThing);
        this.initialization();
    }

    /**
     * initialization
     * called at the constructor to initialize snowmen
     */
    private void initialization()
    {
        //make our snowballs
        snowballs[0] = new Snowball( 50.0f, 500.0f, 200.0f, "Left Head", 255, 255, 255);
        snowballs[1] = new Snowball( 50.0f, 1550.0f, 200.0f, "Right Head", 255, 255, 255);
        snowballs[2] = new Snowball( 100.0f, 500.0f, 350.0f, "Left Body", 255, 255, 255);
        snowballs[3] = new Snowball( 100.0f, 1550.0f, 350.0f, "Right Body", 255, 255, 255);
        snowballs[4] = new Snowball( 150.0f, 500.0f, 600.0f, "Left Butt", 255, 255, 255);
        snowballs[5] = new Snowball( 150.0f, 1550.0f, 600.0f, "Right Butt", 255, 255, 255);
        this.setWillNotDraw(false);
    }

    @Override
    public void onDraw( Canvas c ) {
        //draw all of the snowballs
        for( int i = 0; i < 6; i++ )
        {
            snowballs[i].draw(c);
        }

    }

    //getters
    public Snowball[] getSnowballs() {
        return snowballs;
    }
}
