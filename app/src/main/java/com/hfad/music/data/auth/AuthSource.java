package com.hfad.music.data.auth;

import io.reactivex.Completable;
import io.reactivex.Maybe;

/**
 * Created by anurag on 6/10/17.
 */

public interface AuthSource {

    Completable createAccount(Credentials cred);

    Completable attemptLogin(Credentials cred);

    Completable deleteUser();

    Maybe<User> getUser();

    Completable logUserOur();

    Completable reauthenticateUser(String password);

    void setReturnFail(boolean bool);


}
