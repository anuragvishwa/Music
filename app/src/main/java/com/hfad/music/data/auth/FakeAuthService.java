package com.hfad.music.data.auth;

import io.reactivex.Completable;
import io.reactivex.Maybe;

/**
 * Created by anurag on 6/10/17.
 */

public class FakeAuthService implements AuthSource {
    boolean returnFailure = false;

    private static final User fakeUser =
            new User("email@someemail.com",
                    "someId");

    public FakeAuthService(){

    }

    public static AuthSource getInstance(){
        return new FakeAuthService();
    }
    @Override
    public Completable createAccount(Credentials cred) {
        if(returnFailure) {
            return Completable.error(new Exception());
        }
          return Completable.complete();

    }

    @Override
    public Completable attemptLogin(Credentials cred) {
        if(returnFailure) {
            return Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public Completable deleteUser() {
        if(returnFailure) {
            return Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public Maybe<User> getUser() {
        if(returnFailure) {
            return Maybe.error(new Exception());
        }
        return Maybe.just(fakeUser);
    }

    @Override
    public Completable logUserOur() {
        if (returnFailure){
            return Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public Completable reauthenticateUser(String password) {
        if (returnFailure){
            return Completable.error(new Exception());
        }
        return Completable.complete();
    }

    @Override
    public void setReturnFail(boolean bool) {
        returnFailure = bool;

    }
}
