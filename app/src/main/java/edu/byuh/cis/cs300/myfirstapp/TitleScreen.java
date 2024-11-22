package edu.byuh.cis.cs300.myfirstapp;

import android.content.Intent;
import android.graphics.Paint;
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
                    Intent tom = new Intent(this, Prefs.class);
                    startActivity(tom);
                }
            } else if (y > 2*h/3) {
                //TODO open the main activity
                Intent taylor = new Intent(this, MainActivity.class);
                if (x < w/2) {
                    taylor.putExtra("DUCK_DIR", true);
                } else {
                    taylor.putExtra("DUCK_DIR", false);
                }
                startActivity(taylor);
                finish();
            }
        }
        return true;
    }





}
