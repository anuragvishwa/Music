package com.hfad.music.data.scheduler;

import com.hfad.music.util.BaseSchedulerProvider;
import com.hfad.music.util.ImmideateSchedulerProvider;

/**
 * Created by anurag on 15/10/17.
 */

public class SchedulerInjection {

    //Get the immediate scheduler since it is fake

    public static BaseSchedulerProvider provideSchedulerProvider(){

        return ImmideateSchedulerProvider.getInstance();

    }
}

