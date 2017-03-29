package com.example.thema_000.hw2_roux19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener{

    //instance variables
    PaintSnowmen paintSnowmen; //reference to our canvas class
    Snowball selected; //the current circle selected

    //references to gui elements
    TextView selectedText;
    SeekBar redBar;
    SeekBar greenBar;
    SeekBar blueBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //normal stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //make the surface view work
        paintSnowmen = (PaintSnowmen)this.findViewById(R.id.surfaceView);
        paintSnowmen.invalidate();
        paintSnowmen.setOnTouchListener(this);

        //make text work
        selectedText = (TextView)this.findViewById(R.id.selectedSnowball);

        //make seekbar and listeners work
        redBar = (SeekBar)this.findViewById(R.id.redBar);
        greenBar = (SeekBar)this.findViewById(R.id.greenBar);
        blueBar = (SeekBar)this.findViewById(R.id.blueBar);
        redBar.setOnSeekBarChangeListener(this);
        greenBar.setOnSeekBarChangeListener(this);
        blueBar.setOnSeekBarChangeListener(this);

        //set seekbar maxes (min is default 0)
        redBar.setMax(255);
        greenBar.setMax(255);
        blueBar.setMax(255);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        for( int i = 0; i < 6; i++) {
            //check to see if we have touched any snowballs
            if (paintSnowmen.getSnowballs()[i].contains(event.getX(), event.getY()))
            {
                //reference to selected snowball
                selected = paintSnowmen.getSnowballs()[i];
                selectedText.setText(selected.getName()); //set text view

                //set seekbars to correct progress
                redBar.setProgress(selected.getRed());
                greenBar.setProgress(selected.getGreen());
                blueBar.setProgress(selected.getBlue());
            }
        }

        return false;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if ( selected == null ) return; //dont want any null pointers

        if( fromUser == false ) return; //if it isnt the user moving it dont change anything

        //set red green or blue value to progress depending on slider
        if( seekBar == redBar )
        {
            selected.setRed(progress);
        }
        else if( seekBar == greenBar )
        {
            selected.setGreen(progress);
        }
        else if( seekBar == blueBar )
        {
            selected.setBlue(progress);
        }

        //repaint
        paintSnowmen.invalidate();
    }

    //we dont use these
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
