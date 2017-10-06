package com.hfad.music.data.database;

/**
 * Created by anurag on 6/10/17.
 */

public class Profile {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    private String interests;
    private String email;
    private String photoURL;
    private String history;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    private String uid;


    public Profile(String name,String interests,String email,String photoURL,String history,String uid){
        this.name = name;
        this.interests = interests;
        this.email = email;
        this.photoURL = photoURL;
        this.history= history;
        this.uid= uid;
    }

    public Profile(){
        //for firebase
    }





}
