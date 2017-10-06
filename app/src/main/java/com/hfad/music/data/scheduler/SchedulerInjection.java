package com.hfad.music.data.scheduler;

import com.hfad.music.util.BaseScheduleProvider;
import com.hfad.music.util.ImmideateScheduleProvider;

/**
 * Created by anurag on 6/10/17.
 */

public class SchedulerInjection {

    public static BaseScheduleProvider provideSchedulerProvider(){
        return ImmideateScheduleProvider.getInstance();
    }
}
