package edu.byuh.cis.cs300.myfirstapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private KarlView kv;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        kv = new KarlView(this);
        setContentView(kv);
    }
}