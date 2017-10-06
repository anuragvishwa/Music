package com.hfad.music.data.database;

/**
 * Created by anurag on 6/10/17.
 */

public class DatabaseInjection {
    public static DatabaseSource provideDatabaseSource(){
        return FakeDatabaseService.getInstance();
    }
}
