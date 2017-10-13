package com.hfad.music.Song;

import java.util.List;

/**
 * Created by anurag on 23/9/17.
 */

public class SongPresenter implements SongContract.Presenter {

    private SongContract.View view;

    private final List<SongList> listSongs;

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

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

    }

    @Override
    public int getSongsCount() {
        return 0;
    }
}
