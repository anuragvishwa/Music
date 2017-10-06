package com.hfad.music.util;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anurag on 23/9/17.
 */

public class ScheduleProvider implements BaseScheduleProvider {
    private static ScheduleProvider INSTANCE;

    private ScheduleProvider(){

    }

    public static synchronized  ScheduleProvider getInstance(){
        if(INSTANCE==null){
            INSTANCE= new ScheduleProvider();
        }
        return INSTANCE;
    }

    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
