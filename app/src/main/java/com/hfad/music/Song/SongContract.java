package com.hfad.music.Song;

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

        void longPressSong(String songID);

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

    }

}
