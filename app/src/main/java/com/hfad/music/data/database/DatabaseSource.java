package com.hfad.music.data.database;

import io.reactivex.Completable;
import io.reactivex.Maybe;

/**
 * Created by anurag on 6/10/17.
 */

public interface DatabaseSource {


    Completable createProfile(Profile profile);

    Maybe<Profile> getProfile(String uid);

    Completable deleteProfile(String uid);

    Completable updateProfile(Profile profile);

    void setReturnFail(boolean bool);

    void setReturnEmpty(boolean bool);

}
