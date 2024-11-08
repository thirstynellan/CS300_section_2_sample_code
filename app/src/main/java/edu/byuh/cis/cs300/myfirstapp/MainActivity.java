package edu.byuh.cis.cs300.myfirstapp;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import edu.byuh.cis.cs300.myfirstapp.ui.KarlView;

public class MainActivity extends AppCompatActivity {

    private KarlView kv;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        kv = new KarlView(this);
        setContentView(kv);
    }

    @Override
    public void onPause() {
        super.onPause();
        //TODO pause the music
        kv.pauseMusic();
    }

    @Override
    public void onResume() {
        super.onResume();
        //TODO unpause the music
        kv.resumeMusic();
    }

    @Override
    public boolean onTouchEvent(MotionEvent m) {
        if (m.getAction() == MotionEvent.ACTION_DOWN) {
            float x = m.getX();
            float y = m.getY();
            Log.d("CS3000", "ACTIVITY: You just tapped the screen at (" + x + "," + y + ")");
        }
        //true: I handled it; we're done.
        //false: I'll pass this on to the next object in the CoR
        return false;
    }
}