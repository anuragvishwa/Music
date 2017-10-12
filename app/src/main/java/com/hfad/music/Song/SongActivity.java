package com.hfad.music.Song;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hfad.music.R;
import com.hfad.music.util.ActivityUtils;

public class SongActivity extends AppCompatActivity {

    private static final String SONG_FRAGMENT = "SONG_FRAGMENT";

    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        manager = this.getSupportFragmentManager();

        //set up fragment:

        SongFragment fragment = (SongFragment)manager.findFragmentByTag(SONG_FRAGMENT);

        if(fragment== null){
            fragment = SongFragment.newInstance();
        }

        ActivityUtils.addFragmentToActivity(manager,
                fragment,
                R.id.songFragment,
                SONG_FRAGMENT);


    }
}
