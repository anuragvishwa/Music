package com.hfad.music.Song;


import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hfad.music.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongFragment extends Fragment implements SongContract.View {

    private SongContract.Presenter presenter;


    public SongFragment() {
        // Required empty public constructor
    }


    @Override
    public void setPresenter(SongContract.Presenter presenter) {

        this.presenter = presenter;

    }

    @Override

    public static SongFragment newInstance(){
        return new SongFragment();
    }

    public void makeToast(@StringRes int stringId) {

    }

    @Override
    public void makeToast(String message) {

    }

    @Override
    public void songList() {

    }

    @Override
    public void selectSong() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstance){
        super.onActivityCreated(savedInstance);
        if(presenter==null){
            presenter = new SongFragment()
        }

    }
}
