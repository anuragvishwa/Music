package com.hfad.music.Song;

import android.media.session.MediaSession;

import com.hfad.music.util.BasePresenter;
import com.hfad.music.util.BaseView;

/**
 * Created by anurag on 23/9/17.
 */

public interface SongContract {
    interface View extends BaseView<Presenter>{

        void setSongName(String name);

        void setArtist(String songArtist);

        void selectSong();

        void setPresenter(SongContract.Presenter presenter);

        void createMediaPlayer();

        void longPressSong(String songID);

        //Return boolean indicator indicating whether the player is playing or is supposed
        //to be playing when we gain audio focus

        boolean isPlaying();

        //Return the position of currently playing an item.

        int getCurrentStreamPosition();

        //Return duration if currently playing an item

        long getDuration();

        //Set the current position . Typically used when switching players
        //that are in paused state.

        void setCurrentStreamPosition(int pos);

        //Item to play

        void play(MediaSession.QueueItem item);

        //Item to play, reset true to always start from begining.

        void play(MediaSession.QueueItem item,boolean reset);

        //Pause the current playing item

        void pause();

        //Seek to the given position
        void seekTo(int position);

    }


    interface Presenter extends BasePresenter{

        void longPressOptions();

        void playSong();

        void playNextSong();

        void playAlbum();

        void addToQueue();

        void addToPlayList();

        void useAsRingTone();

        void deleteSong();

        void onBindRepositoryRowViewAtPosition(SongAdapter.ViewHolder holder,int position);

        int getSongsCount();

        //Start/setup the playback


        //Stop the playback . All resources can be de-allocated by implications here.

        void stop();

        //Set the latest playback state as determined by the caller.

        void setState(int state);

        int getState();

        interface Callback{
            //On current music completed.

            void onCompletion();

            //On playback status changed.implementations can use this
            //callback to update playback state on the media sessions.

            void onPlaybackStatusChanged(int state);

            //Error to be added to the PlaybackState

            void onError(String error);

        }

        void setCallback(Callback callback);

        void configMediaPlayerState();

    }

}
