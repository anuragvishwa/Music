package com.hfad.music;

import com.hfad.music.Song.SongContract;
import com.hfad.music.Song.SongPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by anurag on 12/10/17.
 *
 * This is a unit test for our presenter.
 */
@RunWith(MockitoJUnitRunner.class)
public class SongPresenterTest {

    @Mock
    private SongContract.View view;

    private SongPresenter presenter;

    @Before
    public void SetUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        presenter = new SongPresenter();
    }

    @Test
    public void whenSongLoadSucceeds(){

    }

    @Test
    public void whenSongLoadFails(){

    }

    @Test
    public void whenUserPlaysTheSong(){

    }

    @Test
    public void whenTheSongDoesntPlay(){
        
    }
}
