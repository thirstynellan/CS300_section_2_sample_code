package edu.byuh.cis.cs300.myfirstapp.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import edu.byuh.cis.cs300.myfirstapp.Observer;
import edu.byuh.cis.cs300.myfirstapp.Prefs;
import edu.byuh.cis.cs300.myfirstapp.R;
import edu.byuh.cis.cs300.myfirstapp.Timer;
import edu.byuh.cis.cs300.myfirstapp.sprites.Duck;

public class KarlView extends AppCompatImageView implements Observer {

    private Paint alema;
    private Paint momo;
    private List<Duck> flock;
    private boolean initialized;
    private Toast hiram;
    private Timer tim;
    private int level;
    private MediaPlayer song;
    private boolean duckDir;

    public KarlView(Context c, boolean dd) {
        super(c);
        duckDir = dd;
        level = 1;
        setImageResource(R.drawable.bkgd2);
        setScaleType(ScaleType.FIT_XY);
        initialized = false;
        flock = new ArrayList<>();
        momo = new Paint();
        momo.setColor(Color.BLUE);
        momo.setStyle(Paint.Style.STROKE);
        momo.setTextSize(70);
        alema = new Paint();
        alema.setColor(Color.RED);
        song = MediaPlayer.create(getContext(), R.raw.zhaytee_microcomposer_1);
        song.setLooping(true);
        if (Prefs.getMusicPref(c)) {
            song.start();
        }
    }

    public void pauseMusic() {
        if (Prefs.getMusicPref(getContext())) {
            song.pause();
        }
    }

    public void resumeMusic() {
        if (Prefs.getMusicPref(getContext())) {
            song.start();
        }
    }

    public void unloadMusic() {
        song.release();
    }

    private void createDucks(int n) {
        int danceSpeed = Prefs.getSpeedPref(getContext());
        float w = getWidth();
        float h = getHeight();
        for (int i=0; i<n; i++) {
            Duck fah = new Duck(getResources(), w, duckDir);
            float duckX = (float) (w * 0.75 * Math.random());
            float duckY = (float) (h * 0.75 * Math.random());
            fah.setLocation(duckX, duckY);
            fah.setDanceSpeed(danceSpeed);
            flock.add(fah);
            tim.subscribe(fah);
        }
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
            createDucks(level * 10);
            momo.setStrokeWidth(w * 0.01f);
            alema.setStrokeWidth(w * 0.02f);
            tim.subscribe(this);
            initialized = true;
        }
        //c.drawColor(Color.GREEN);
        //c.drawRect(rectLeft, rectTop, rectRight, rectBottom, momo);
        //c.drawLine(w*0.4f, h*0.3f, w*0.8f, h*0.8f, alema);
//        class Ina implements Consumer<Duck> {
//            @Override
//            public void accept(Duck d) {
//                d.draw(c, momo);
//            }
//        }
//        var n = new Ina();
        flock.forEach(d -> d.draw(c, momo));
//        for (var d : flock) {
//            d.draw(c, momo);
//        }
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
//            List<Duck> doomed = new ArrayList<>();
//            for (var d : flock) {
//                if (d.contains(x, y)) {
//                    doomed.add(d);
//                    tim.unsubscribe(d);//right thing to do
//                }
//            }
//            flock.removeAll(doomed);
//            class Tom implements Predicate<Duck> {
//                @Override
//                public boolean test(Duck d) {
//                    return d.contains(x,y);
//                }
//            }
//            var tom = new Tom();
            //flock.removeIf(d -> d.contains(x,y));
            List<Duck> doomed = flock.stream().filter(d -> d.contains(x,y)).collect(Collectors.toList());
            flock.removeAll(doomed);
            doomed.forEach(d -> tim.unsubscribe(d));
            if (flock.isEmpty()) {
                level++;
                AlertDialog.Builder ab = new AlertDialog.Builder(getContext())
                  .setTitle("Congratulations!")
                  .setMessage("Well, done, captain! You have successfully cleared the sector of the invading duck aliens. The Federation is in need of a captain for a similar mission. Do you want to volunteer?")
                  .setCancelable(false)
                  .setPositiveButton("Yes, play again!", (d, j) -> createDucks(level * 10))
                  .setNegativeButton("No, I quit.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface d, int j) {
                        ((Activity)getContext()).finish();
                    }
                });
//                AlertDialog box = ab.create();
//                box.show();
                ab.create().show();
            }
        }
        //true: I handled it; we're done.
        //false: I'll pass this on to the next object in the CoR
        return true;
    }

    @Override
    public void update() {
        if (Math.random() < 0.1) {
            post(() -> createDucks(1));
        }
        invalidate();
    }
}












