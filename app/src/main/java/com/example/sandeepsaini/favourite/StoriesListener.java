package com.example.sandeepsaini.favourite;

/**
 * Created by Sandeep Saini on 10/22/2018
 */
public interface StoriesListener {
    void onLikeStory(Story story);

    void onUnlikeStory(Story story);
}
