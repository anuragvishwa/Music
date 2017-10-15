package com.hfad.music.data.auth;

public class AuthInjection{

    public static AuthSource provideAuthSource(){
        return FakeAuthService.getInstance();
    }

}