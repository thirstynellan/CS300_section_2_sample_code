package edu.byuh.cis.cs300.myfirstapp.sprites;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;

import edu.byuh.cis.cs300.myfirstapp.R;

public class Duck {
    private Bitmap img;
    protected RectF bounds;

    public Duck(Resources res, float w) {
        img = BitmapFactory.decodeResource(res, R.drawable.duck);
        int duckSize = (int)(w * 0.25);
        img = Bitmap.createScaledBitmap(img, duckSize, duckSize, true);
        bounds = new RectF(0, 0, duckSize, duckSize);
    }

    public void setLocation(float x, float y) {
        bounds.offsetTo(x,y);
    }

    public void draw(Canvas c) {
        c.drawBitmap(img, bounds.left, bounds.top, null);
    }
}
