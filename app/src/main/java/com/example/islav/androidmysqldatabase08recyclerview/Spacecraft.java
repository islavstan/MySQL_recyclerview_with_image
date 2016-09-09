package com.example.islav.androidmysqldatabase08recyclerview;

/**
 * Created by islav on 08.09.2016.
 */
public class Spacecraft {
    int id;
    String name,imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
