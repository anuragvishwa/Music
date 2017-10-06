package com.hfad.music.data.auth;

/**
 * Created by anurag on 6/10/17.
 */

public class User {

    public User(String email, String userId) {
        this.email = email;
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String email;
    private String userId;


}
