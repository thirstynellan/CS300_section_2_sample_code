package edu.byuh.cis.cs300.myfirstapp.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.byuh.cis.cs300.myfirstapp.Observer;
import edu.byuh.cis.cs300.myfirstapp.Timer;
import edu.byuh.cis.cs300.myfirstapp.sprites.Duck;

public class KarlView extends View implements Observer {

    private Paint alema;
    private Paint momo;
    //private Duck fah;
    private List<Duck> flock;
    private boolean initialized;
    private Toast hiram;
    private Timer tim;

    public KarlView(Context c) {
        super(c);
        initialized = false;
        flock = new ArrayList<>();
        momo = new Paint();
        momo.setColor(Color.BLUE);
        momo.setStyle(Paint.Style.STROKE);
        momo.setTextSize(70);
        alema = new Paint();
        alema.setColor(Color.RED);
    }

    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);
        float w = getWidth();
        float h = getHeight();
        float rectLeft = w * 0.25f;
        float rectRight = w * 0.5f;
        float rectTop = h * 0.2f;
        float rectBottom = h * 0.6f;
        if (!initialized) {
            tim = new Timer();
            for (int i=0; i<55; i++) {
                Duck fah = new Duck(getResources(), w);
                float duckX = (float) (w * 0.75 * Math.random());
                float duckY = (float) (h * 0.75 * Math.random());
                fah.setLocation(duckX, duckY);
                flock.add(fah);
                tim.subscribe(fah);
            }
            momo.setStrokeWidth(w * 0.01f);
            alema.setStrokeWidth(w * 0.02f);
            tim.subscribe(this);
            initialized = true;
        }
        c.drawColor(Color.GREEN);
        c.drawRect(rectLeft, rectTop, rectRight, rectBottom, momo);
        c.drawLine(w*0.4f, h*0.3f, w*0.8f, h*0.8f, alema);
        for (var d : flock) {
            d.draw(c, momo);
        }
//        hiram = Toast.makeText(getContext(),
//                "CS300 is my favorite class",
//                Toast.LENGTH_LONG);
//        hiram.show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent m) {
        if (m.getAction() == MotionEvent.ACTION_DOWN) {
            float x = m.getX();
            float y = m.getY();
            List<Duck> doomed = new ArrayList<>();
            for (var d : flock) {
                if (d.contains(x, y)) {
                    doomed.add(d);
                }
            }
            flock.removeAll(doomed);
        }
        invalidate();
        //true: I handled it; we're done.
        //false: I'll pass this on to the next object in the CoR
        return true;
    }

    @Override
    public void update() {
        invalidate();
    }
}












