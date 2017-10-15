package com.hfad.music.util;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anurag on 6/10/17.
 */

public class ImmideateSchedulerProvider implements BaseSchedulerProvider {
    private static ImmideateSchedulerProvider INSTANCE;

    private ImmideateSchedulerProvider(){

    }

    public static synchronized ImmideateSchedulerProvider getInstance (){
        if(INSTANCE==null){
            INSTANCE = new ImmideateSchedulerProvider();
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
