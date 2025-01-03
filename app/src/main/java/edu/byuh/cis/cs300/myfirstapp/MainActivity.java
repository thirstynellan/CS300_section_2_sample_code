package edu.byuh.cis.cs300.myfirstapp;

import android.content.Intent;
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
        Intent momo = getIntent();
        boolean dd = momo.getBooleanExtra("DUCK_DIR", true);
        kv = new KarlView(this, dd);
        setContentView(kv);
    }

    @Override
    public void onPause() {
        super.onPause();
        kv.pauseMusic();
    }

    @Override
    public void onResume() {
        super.onResume();
        kv.resumeMusic();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //un-load the music from memory
        kv.unloadMusic();
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