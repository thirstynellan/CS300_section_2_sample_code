package edu.byuh.cis.cs300.myfirstapp.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import edu.byuh.cis.cs300.myfirstapp.sprites.Duck;

public class KarlView extends View {

    private Paint momo;
    private Paint alema;
    //private Bitmap duckImg;
    private Duck fah;
    private boolean initialized;
    private Toast hiram;


    public KarlView(Context c) {
        super(c);
        initialized = false;
        momo = new Paint();
        momo.setColor(Color.BLUE);
        momo.setStyle(Paint.Style.STROKE);
        alema = new Paint();
        alema.setColor(Color.RED);
        //duckImg = BitmapFactory.decodeResource(getResources(), R.drawable.duck);
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
            //int duckSize = (int)(w * 0.25);
            //duckImg = Bitmap.createScaledBitmap(duckImg, duckSize, duckSize, true);
            fah = new Duck(getResources(), w);
            fah.setLocation(w*0.5f, h*0.6f);
            momo.setStrokeWidth(w * 0.01f);
            alema.setStrokeWidth(w * 0.02f);
            initialized = true;
        }
        c.drawColor(Color.GREEN);
        c.drawRect(rectLeft, rectTop, rectRight, rectBottom, momo);
        c.drawLine(w*0.4f, h*0.3f, w*0.8f, h*0.8f, alema);
        fah.draw(c);
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
            Log.d("CS3000", "VIEW: You just tapped the screen at (" + x + "," + y + ")");
        }
        //true: I handled it; we're done.
        //false: I'll pass this on to the next object in the CoR
        return true;
    }
}












