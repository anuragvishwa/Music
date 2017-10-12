package com.hfad.music.Song;


import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hfad.music.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongFragment extends Fragment implements SongContract.View {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<SongList> songLists;
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
    public View onCreateView (LayoutInflater inflater,
                       ViewGroup container,
                       Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_song,container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.songRecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        songLists = new ArrayList<>();

        for(int i=0;i<=10;i++){

            SongList songList = new SongList("Channa mereya" + (i+1) , "Arjit Singh");

            songLists.add(songList);

        }

        adapter = new SongAdapter(songLists,getActivity());

        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstance){
        super.onActivityCreated(savedInstance);
        if(presenter==null){
            presenter = new SongFragment()
        }

    }
}
