package edu.byuh.cis.cs300.myfirstapp.sprites;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;

import edu.byuh.cis.cs300.myfirstapp.R;

public class Duck {
    private Bitmap img;
    private Bitmap leftDuck, rightDuck;
    private boolean inverted;
    private RectF bounds;

    public Duck(Resources res, float w) {
        leftDuck = BitmapFactory.decodeResource(res, R.drawable.duck);
        int duckSize = (int)(w * 0.25);
        leftDuck = Bitmap.createScaledBitmap(leftDuck, duckSize, duckSize, true);
        bounds = new RectF(0, 0, duckSize, duckSize);
        rightDuck = BitmapFactory.decodeResource(res, R.drawable.duck2);
        rightDuck = Bitmap.createScaledBitmap(rightDuck, duckSize, duckSize, true);
        img = leftDuck;
        inverted = false;
    }

    public void setLocation(float x, float y) {
        bounds.offsetTo(x,y);
    }

    public void draw(Canvas c) {
        c.drawBitmap(img, bounds.left, bounds.top, null);
    }

    public boolean contains(float x, float y) {
//        if (bounds.contains(x,y)) {
//            return true;
//        } else {
//            return false;
//        }
        return bounds.contains(x,y);
    }

    public void respondToTap() {
        if (inverted) {
            img = leftDuck;
            inverted = false;
        } else {
            img = rightDuck;
            inverted = true;
        }
    }

    public void dance() {
        float dx = (float)(Math.random()*10)-5;
        float dy = (float)(Math.random()*10)-5;
        bounds.offset(dx, dy);
    }
}
