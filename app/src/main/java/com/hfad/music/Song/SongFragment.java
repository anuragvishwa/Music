package com.hfad.music.Song;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
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
import com.hfad.music.Service.MediaPlayerService;

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
    private MediaPlayerService player;
    boolean serviceBound = false;



    //Binding the client to the AudioPlayer Service:

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MediaPlayerService.LocalBinder binder = (MediaPlayerService.LocalBinder) iBinder;
            player = binder.getService();
            serviceBound = true;

            Toast.makeText(getActivity(), "Service Bound", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            serviceBound= false;

        }
    };

    public void playAudio(String media){
        //Check if service is active

        if(!serviceBound) {
            Intent playerIntent = new Intent(getActivity(), MediaPlayerService.class);
            playerIntent.putExtra("media", media);
            getActivity().startService(playerIntent);
            getActivity().bindService(playerIntent, serviceConnection, Context.BIND_AUTO_CREATE);
        }
        else
        {
            //Service is active
            //Send broadcast receiver

        }

    }



    public SongFragment() {
        // Required empty public constructor
    }

    @Override
    public void createMediaPlayer() {

    }




    @Override
    public void setPresenter(SongContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void longPressSong(String songID) {

    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public int getCurrentStreamPosition() {
        return 0;
    }

    @Override
    public long getDuration() {
        return 0;
    }

    @Override
    public void setCurrentStreamPosition(int pos) {

    }

    @Override
    public void play(MediaSession.QueueItem item) {

    }

    @Override
    public void play(MediaSession.QueueItem item, boolean reset) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void seekTo(int position) {

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
        recyclerView = (RecyclerView)view.findViewById(R.id.songRecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        playAudio("https://upload.wikimedia.org/wikipedia/commons/6/6c/Grieg_Lyric_Pieces_Kobold.ogg");

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
    public void selectSong() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstance){
        super.onActivityCreated(savedInstance);
        if(presenter==null){
            presenter = new SongPresenter();
            adapter = new SongAdapter(presenter);
            recyclerView.setAdapter(adapter);
        }

    }

    @Override
    public void onDestroy(){
        presenter.unsubscribe();
        super.onDestroy();
    }
}
