package com.hfad.music.util;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anurag on 6/10/17.
 */

public class ImmideateScheduleProvider implements BaseScheduleProvider {
    private static ImmideateScheduleProvider INSTANCE;

    private ImmideateScheduleProvider(){

    }

    public static synchronized ImmideateScheduleProvider getInstance (){
        if(INSTANCE==null){
            INSTANCE = new ImmideateScheduleProvider();
        }
        return INSTANCE;
    }

    @Override
    public Scheduler computation() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler io() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler ui() {
        return Schedulers.trampoline();
    }
}
