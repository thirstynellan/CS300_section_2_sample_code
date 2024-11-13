package edu.byuh.cis.cs300.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TitleScreen extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        iv = new ImageView(this);
        iv.setImageResource(R.drawable.duck_splash);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        setContentView(iv);
    }

    @Override
    public boolean onTouchEvent(MotionEvent m) {
        if (m.getAction() == MotionEvent.ACTION_DOWN) {
            float x = m.getX();
            float y = m.getY();
            float w = iv.getWidth();
            float h = iv.getHeight();
            if (y < h/3) {
                if (x < w/2) {
                    //TODO show the "about box"
                } else {
                    //TODO open the settings screen
                }
            } else if (y > 2*w/3) {
                //TODO open the main activity
                Intent taylor = new Intent(this, MainActivity.class);
                startActivity(taylor);
                finish();
            }
        }
        return true;
    }





}
