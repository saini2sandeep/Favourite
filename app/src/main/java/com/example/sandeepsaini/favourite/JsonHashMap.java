package com.example.sandeepsaini.favourite;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Sandeep Saini on 10/23/2018
 */
public class JsonHashMap extends LinkedHashMap<String, Object> {

    public JsonHashMap() {
        super();
    }

    public JsonHashMap(String jsonString) {
        super();
        putAll((Map<? extends String, ?>) new Gson().fromJson(jsonString, new TypeToken<LinkedHashMap<String, Object>>() {
        }.getType()));
    }


    @Override
    public String toString() {
        return GsonUtils.convertToJSON(this);
    }
}
