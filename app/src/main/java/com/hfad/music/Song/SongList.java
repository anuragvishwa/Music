package com.hfad.music.Song;

/**
 * Created by anurag on 12/10/17.
 */

public class SongList {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public SongList(String title, String artist) {
        this.title = title;
        this.artist = artist;

    }

    private String artist;
}
