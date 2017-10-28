package com.hfad.music.util;

import android.media.session.MediaSession;

/**
 * Created by anurag on 27/10/17.
 */

public interface Playback {

    //Start/setup the playback
    void start();

    //Stop the playback . All resources can be de-allocated by implications here.

    void stop();

    //Set the latest playback state as determined by the caller.

    void setState(int state);

    int getState();

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

    interface Callback{
        //On current music completed.

        void onCompletion();

        //On playback status changed.implementations can use this
        //callback to update playback state on the media sessions.

        void onPlaybackStatusChanged(int state);

        //Error to be added to the PlaybackState

        void onError(String error);

    }


    //Callback to be called

    void setCallback(Callback callback);


}
