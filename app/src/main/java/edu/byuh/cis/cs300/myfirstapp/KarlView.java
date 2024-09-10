package edu.byuh.cis.cs300.myfirstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

public class KarlView extends View {

    public KarlView(Context c) {
        super(c);
    }

    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);
        c.drawColor(Color.GREEN);
    }
}
