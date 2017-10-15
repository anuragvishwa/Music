package com.hfad.music;

import com.hfad.music.Song.SongContract;
import com.hfad.music.Song.SongPresenter;
import com.hfad.music.data.auth.AuthInjection;
import com.hfad.music.data.auth.AuthSource;
import com.hfad.music.data.scheduler.SchedulerInjection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    private AuthSource authSource;

    @Before
    public void SetUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        authSource = AuthInjection.provideAuthSource();

        presenter = new SongPresenter(authSource,view, SchedulerInjection.provideSchedulerProvider());
    }

    @Test
    public void whenUserDeleteSong() throws Exception{

        presenter.deleteSong();

        Mockito.verify(presenter).deleteSong();


    }

    @Test
    public void whenSongDeleteFail() throws Exception{
        Mockito.verify(view).makeToast(Mockito.anyString());
    }

    @Test
    public void whenUserSelectSong() throws Exception{

        Mockito.verify(view).selectSong();

    }

    @Test
    public void whenSongDoesntPlay() throws Exception{
        Mockito.verify(view).makeToast(Mockito.anyString());
    }



}
