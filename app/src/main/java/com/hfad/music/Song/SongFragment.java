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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.music.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongFragment extends Fragment implements SongContract.View {

    private TextView song,artist;
    private ImageButton thumbnail;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<SongList> songLists;
    private SongContract.Presenter presenter;
    private View contentContainer;



    public SongFragment() {
        // Required empty public constructor
    }




    @Override
    public void setPresenter(SongContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public static SongFragment newInstance(){

        return new SongFragment();
    }

    public void makeToast(@StringRes int stringId) {
        Toast.makeText(getActivity().getApplicationContext(),getString(stringId),
                Toast.LENGTH_SHORT).show();


    }


    @Override
    public void makeToast(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();

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
/*
        recyclerView = (RecyclerView)view.findViewById(R.id.songRecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        songLists = new ArrayList<>();

        for(int i=0;i<=10;i++){

            SongList songList = new SongList("Channa mereya" + (i+1) , "Arjit Singh");

            songLists.add(songList);

        }

        adapter = new SongAdapter(songLists,getActivity());

        recyclerView.setAdapter(adapter);*/
        contentContainer = view.findViewById(R.id.songRelative);
        song = (TextView)view.findViewById(R.id.songName);
        artist = (TextView)view.findViewById(R.id.albumName);


        return view;
    }

    @Override
    public void setSongName(String name) {
        song.setText(name);
    }

    @Override
    public void setArtist(String songArtist) {
        artist.setText(songArtist);

    }

    @Override
    public void onActivityCreated(Bundle savedInstance){
        super.onActivityCreated(savedInstance);
        if(presenter==null){
            presenter = new SongFragment()
        }

    }
}
