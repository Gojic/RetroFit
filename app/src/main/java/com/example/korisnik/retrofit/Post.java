package com.example.korisnik.retrofit;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int userId;
    private int id;
    private String title;

    @SerializedName("body")
    private String decs;

    public Post(int userId, int id, String title, String decs) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.decs = decs;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDecs() {
        return decs;
    }




}
