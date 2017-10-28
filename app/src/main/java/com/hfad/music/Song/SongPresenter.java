package com.hfad.music.Song;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.PowerManager;
import android.util.Log;

import com.hfad.music.data.auth.AuthSource;
import com.hfad.music.util.BaseSchedulerProvider;
import com.hfad.music.util.Playback;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by anurag on 23/9/17.
 */

public class SongPresenter implements SongContract.Presenter,AudioManager.OnAudioFocusChangeListener,
        MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {

    private SongContract.View view;

    private AuthSource auth;

    private CompositeDisposable compositeDisposable;

    private BaseSchedulerProvider scheduleProvider;

    private final List<SongList> listSongs = new ArrayList<SongList>();

    private AudioManager audioManager;




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
        view.setPresenter(this);

    }

    @Override
    public void subscribe() {
        //Presenter doesn't need initialization in this case

    }

    @Override
    public void unsubscribe() {
        compositeDisposable.clear();

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



    @Override
    public void stop() {

    }

    @Override
    public void setState(int state) {

    }

    @Override
    public int getState() {
        return 0;
    }

    @Override
    public void setCallback(Callback callback) {

    }

    @Override
    public void configMediaPlayerState() {

      //  Log.d()
    }

    @Override
    public void onAudioFocusChange(int i) {

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onSeekComplete(MediaPlayer mediaPlayer) {

    }
}
