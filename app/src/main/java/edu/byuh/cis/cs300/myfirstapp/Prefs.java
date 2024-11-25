package edu.byuh.cis.cs300.myfirstapp;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;

public class Prefs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public static boolean getMusicPref(Context c) {
        return PreferenceManager.getDefaultSharedPreferences(c).getBoolean("MUSIC_PREF", false);
    }

    public static int getSpeedPref(Context c) {
        String ky = PreferenceManager.getDefaultSharedPreferences(c).getString("SPEED_PREF", "10");
        return Integer.parseInt(ky);
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle b, String s) {
            Context context = getPreferenceManager().getContext();
            PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(context);

            //TODO add preference widgets here
            SwitchPreference music = new SwitchPreference(context);
            music.setTitle(R.string.music_pref);
            music.setSummaryOn(R.string.music_on);
            music.setSummaryOff(R.string.music_off);
            music.setDefaultValue(false);
            music.setKey("MUSIC_PREF");
            screen.addPreference(music);

            ListPreference speed = new ListPreference(context);
            speed.setTitle(R.string.speed_pref_title);
            speed.setSummary(R.string.speed_pref_summary);
            speed.setKey("SPEED_PREF");
            //String[] entries = {"Fast", "Medium", "Slow"};
            String[] values = {"20", "10", "4"};
            speed.setEntries(R.array.speed_entries);
            speed.setEntryValues(values);
            speed.setDefaultValue("10");
            screen.addPreference(speed);

            setPreferenceScreen(screen);
        }

    }
}