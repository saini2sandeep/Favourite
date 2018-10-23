package com.example.sandeepsaini.favourite;

/**
 * Created by Sandeep Saini on 10/22/2018
 */
public class Story {
    public Story(){}


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(int isLiked) {
        this.isLiked = isLiked;
    }

    public String getIdStory() {
        return idStory;
    }

    public void setIdStory(String isStory) {
        this.idStory = isStory;
    }

    private String idStory;
    private String title;
    private int isLiked;

    @Override
    public String toString() {
        return GsonUtils.convertToJSON(this);
    }
}
