package com.hfad.music.util;

import io.reactivex.Scheduler;

/**
 * Created by anurag on 23/9/17.
 */

public interface BaseScheduleProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
