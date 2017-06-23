package com.example.shashank.kotlin_tutorial;

/**
 * Created by shashank on 07-06-2017.
 */

public class Card {
    private String name;
    private int numOfchapters;
    private int thumbnail;

    public Card() {
    }

    public Card(String name, int numOfchapters, int thumbnail) {
        this.name = name;
        this.numOfchapters = numOfchapters;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfchapters() {
        return numOfchapters;
    }

    public void setNumOfchapters(int numOfchapters) {
        this.numOfchapters = numOfchapters;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
