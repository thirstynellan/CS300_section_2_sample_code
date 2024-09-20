package edu.byuh.cis.cs300.myfirstapp;

import android.os.Bundle;

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
}