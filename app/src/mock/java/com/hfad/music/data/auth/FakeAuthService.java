package com.hfad.music.data.auth;

import io.reactivex.Completable;
import io.reactivex.Maybe;

/**
 * Created by anurag on 10/10/17.
 */

public class FakeAuthService implements AuthSource{

    boolean returnFailure = false;

    private static final User fakeUser =
            new User(
                    "email@example.com",
                    "someId"
            );

    public static AuthSource getInstance() {
        return new FakeAuthService();
    }

    public FakeAuthService(){

    }

    @Override
    public Completable createAccount(Credentials cred) {
        if(returnFailure){
            Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public Completable attemptLogin(Credentials cred) {
        if(returnFailure){
            Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public Completable deleteUser() {
        if(returnFailure){
            Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public Maybe<User> getUser() {
        if(returnFailure){
            Maybe.error(new Exception());
        }
        return Maybe.just(fakeUser);
    }

    @Override
    public Completable logUserOur() {
        if(returnFailure){
            Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public Completable reauthenticateUser(String password) {
        if(returnFailure){
            Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public void setReturnFail(boolean bool) {
        returnFailure = bool;

    }
}
