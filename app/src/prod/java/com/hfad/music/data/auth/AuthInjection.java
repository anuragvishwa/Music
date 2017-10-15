package com.hfad.music.data.auth;

public FirebaseAuthService implements AuthSource{


public static AuthSource getInstance(){
        return new FirebaseAuthService();
        }

public FirebaseAuthService(){

        }
}
