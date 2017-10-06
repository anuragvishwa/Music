package com.hfad.music.data.auth;

/**
 * Created by anurag on 6/10/17.
 */

public class AuthInjection {

    public static AuthSource provideAuthSource(){
        return FakeAuthService.getInstance();
    }
}
