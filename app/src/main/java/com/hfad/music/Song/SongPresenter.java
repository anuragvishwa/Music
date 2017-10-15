package com.hfad.music.Song;

import com.hfad.music.data.auth.AuthSource;
import com.hfad.music.util.BaseSchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by anurag on 23/9/17.
 */

public class SongPresenter implements SongContract.Presenter {

    private SongContract.View view;

    private AuthSource auth;

    private CompositeDisposable compositeDisposable;

    private BaseSchedulerProvider scheduleProvider;

    private final List<SongList> listSongs = new ArrayList<SongList>();


    public SongPresenter() {
        for(int i=0;i<=10;i++){

            SongList songList = new SongList("Channa mereya" + (i+1) , "Arjit Singh");

            listSongs.add(songList);

        }
    }

    public SongPresenter(AuthSource authSource,
                         SongContract.View view,
                         BaseSchedulerProvider schedulerProvider){

        this.auth=authSource;
        this.view= view;
        this.scheduleProvider = schedulerProvider;
        this.compositeDisposable = new CompositeDisposable();

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void longPressOptions() {

    }

    @Override
    public void playSong() {

    }

    @Override
    public void playNextSong() {

    }

    @Override
    public void playAlbum() {

    }

    @Override
    public void addToQueue() {

    }

    @Override
    public void addToPlayList() {

    }

    @Override
    public void useAsRingTone() {

    }

    @Override
    public void deleteSong() {

    }

    @Override
    public void onBindRepositoryRowViewAtPosition(SongAdapter.ViewHolder holder, int position) {
        SongList song = listSongs.get(position);
        holder.setSongName(song.getTitle());
        holder.setArtistName(song.getArtist());

    }

    @Override
    public int getSongsCount() {
        return listSongs.size();
    }
}
