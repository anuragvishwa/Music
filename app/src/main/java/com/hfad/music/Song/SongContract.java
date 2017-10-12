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

    }


    interface Presenter extends BasePresenter{

        void playSong();

        void playNextSong();

        void playAlbum();

        void addToQueue();

        void addToPlayList();

        void useAsRingTone();

        void deleteSong();

    }

}
