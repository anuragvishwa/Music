package com.hfad.music.data.database;

import android.provider.ContactsContract;

import io.reactivex.Completable;
import io.reactivex.Maybe;

/**
 * Created by anurag on 6/10/17.
 */

public class FakeDatabaseService implements DatabaseSource {
    boolean returnFailure = false;
    boolean returnEmpty = false;

    private static final Profile fakeProfile = new Profile("Anurag","","email@someemail.com","","","someId");

    public FakeDatabaseService(){

    }

    public static FakeDatabaseService getInstance(){
        return new FakeDatabaseService();
    }

    @Override
    public Completable createProfile(Profile profile) {
        if (returnFailure){
            return Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public Maybe<Profile> getProfile(String uid) {
        if(returnFailure) {
            return Maybe.error(new Exception());
        }
        else if(returnEmpty){
            return Maybe.empty();

        }
        return Maybe.just(fakeProfile);
    }

    @Override
    public Completable deleteProfile(String uid) {
        if (returnFailure){
            return Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public Completable updateProfile(Profile profile) {
        if (returnFailure){
            return Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public void setReturnFail(boolean bool) {
        this.returnFailure= bool;

    }

    @Override
    public void setReturnEmpty(boolean bool) {
        this.returnEmpty=bool;

    }
}
