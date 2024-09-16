package edu.byuh.cis.cs300.myfirstapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class KarlView extends View {

    private Paint momo;
    private Paint alema;
    private Bitmap duckImg;

    public KarlView(Context c) {
        super(c);
        momo = new Paint();
        momo.setColor(Color.BLUE);
        momo.setStyle(Paint.Style.STROKE);
        alema = new Paint();
        alema.setColor(Color.RED);
        duckImg = BitmapFactory.decodeResource(getResources(), R.drawable.duck);
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
        int duckSize = (int)(w * 0.25);
        //TODO next time, show how to make this
        //more efficient for animation
        duckImg = Bitmap.createScaledBitmap(duckImg, duckSize, duckSize, true);
        momo.setStrokeWidth(w * 0.01f);
        alema.setStrokeWidth(w * 0.02f);
        c.drawColor(Color.GREEN);
        c.drawRect(rectLeft, rectTop, rectRight, rectBottom, momo);
        c.drawLine(w*0.4f, h*0.3f, w*0.8f, h*0.8f, alema);
        c.drawBitmap(duckImg, w*0.5f, h*0.6f, alema);
    }
}
