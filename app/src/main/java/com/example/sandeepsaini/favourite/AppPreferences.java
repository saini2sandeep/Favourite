package com.example.sandeepsaini.favourite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sandeep Saini on 10/23/2018
 */
public class AppPreferences {

    private PreferenceManager preferenceManager;

    public AppPreferences(PreferenceManager preferenceManager) {
        this.preferenceManager = preferenceManager;
    }

    public void saveFavouriteCard(Story story) {
        preferenceManager.saveDataInMap(PreferenceKey.FAVOURITE_CONTENT_LIST, story.getIdStory(), story.toString());
        List<Story> favouriteCardList = getFavouriteCardList();

        /*
        this code will limit the number of card stored in list if you want to limit the storing of number of cards
        then do this code. Now limit is set 10
         */
//        if (favouriteCardList != null && favouriteCardList.size() > 0) {
//            if (favouriteCardList.size() >= 10) {
//                deleteCard(favouriteCardList.get(0).getIdStory());
//            }
//        }
    }

    public void clear() {
        preferenceManager.removeAll();
    }


    public List<Story> getFavouriteCardList() {
        JsonHashMap jsonHashMap = preferenceManager.getMapData(PreferenceKey.FAVOURITE_CONTENT_LIST);
        if (jsonHashMap == null || jsonHashMap.isEmpty())
            return null;
        List<Story> favouriteCardList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : jsonHashMap.entrySet()) {
            Story favouriteCard = null;
            try {
                favouriteCard = GsonUtils.convertToObject(entry.getValue().toString(), Story.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            favouriteCardList.add(favouriteCard);
        }
        return favouriteCardList;
    }

    public void deleteCard(String contentID) {
        if (contentID != null) {
            preferenceManager.deleteDataInMap(PreferenceKey.FAVOURITE_CONTENT_LIST, contentID);
        }
    }
}
