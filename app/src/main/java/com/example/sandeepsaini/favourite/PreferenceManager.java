package com.example.sandeepsaini.favourite;

import android.content.SharedPreferences;
import android.text.TextUtils;

import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sandeep Saini on 10/23/2018
 */
public class PreferenceManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public PreferenceManager(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        editor = sharedPreferences.edit();
    }

    public void saveDataInSet(@PreferenceKey String key, String value) {
        Set<String> stringSet = getStringSet(key);
        if (stringSet == null)
            stringSet = new LinkedHashSet<>();
        stringSet.add(value);
        save(key, stringSet);
    }

    public void deleteDataInSet(String mapKey, String dataKey) {
        Set<String> stringSet = getStringSet(mapKey);
        if (stringSet != null && stringSet.contains(dataKey)) {
            stringSet.remove(dataKey);
            save(mapKey, stringSet);
        }
    }

    public void saveDataInMap(String mapKey, String dataKey, String dataValue) {
        JsonHashMap jsonHashMapData = getMapData(mapKey);
        if (jsonHashMapData == null)
            jsonHashMapData = new JsonHashMap();
        jsonHashMapData.put(dataKey, dataValue);
        save(mapKey, jsonHashMapData.toString());
    }

    public  void deleteDataInMap(String mapKey, String dataKey) {
        JsonHashMap jsonHashMapData = getMapData(mapKey);
        if (jsonHashMapData != null && jsonHashMapData.containsKey(dataKey)) {
            jsonHashMapData.remove(dataKey);
            save(mapKey, jsonHashMapData.toString());
        }
    }

    public  JsonHashMap getMapData(String mapKey) {
        String value = sharedPreferences.getString(mapKey, null);
        if (TextUtils.isEmpty(value))
            return null;
        return new JsonHashMap(value);
    }


    public void save(@PreferenceKey String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public void save(@PreferenceKey String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void save(@PreferenceKey String key, float value) {
        editor.putFloat(key, value);
        editor.apply();
    }

    public void save(@PreferenceKey String key, long value) {
        editor.putLong(key, value);
        editor.apply();
    }

    public void save(@PreferenceKey String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    public void save(@PreferenceKey String key, Set<String> values) {
        editor.putStringSet(key, values);
        editor.apply();
    }



    public void saveObject(@PreferenceKey String key, Object object) {
        String objectJSON;
        try {
            objectJSON = GsonUtils.convertToJSON(object);
        } catch (Exception e) {
            return;
        }
        if (TextUtils.isEmpty(objectJSON)) {
            return;
        }
        editor.putString(key, objectJSON);
        editor.apply();
    }

    public <T> T getObject(@PreferenceKey String key, Type typeOfT) {

        String objectJSON = sharedPreferences.getString(key, null);
        if (TextUtils.isEmpty(objectJSON))
            return null;
        try {
            return GsonUtils.convertToObject(objectJSON, typeOfT);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T getObject(@PreferenceKey String key, Class<T> tClass) {

        String objectJSON = sharedPreferences.getString(key, null);
        if (TextUtils.isEmpty(objectJSON))
            return null;
        try {
            return GsonUtils.convertToObject(objectJSON, tClass);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean getBoolean(@PreferenceKey String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public boolean getBoolean(@PreferenceKey String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public float getFloat(@PreferenceKey String key) {
        return sharedPreferences.getFloat(key, 0);
    }

    public float getFloat(@PreferenceKey String key, int defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    public int getInt(@PreferenceKey String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public int getInt(@PreferenceKey String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public long getLong(@PreferenceKey String key) {
        return sharedPreferences.getLong(key, 0);
    }

    public String getString( @PreferenceKey String key) {
        return sharedPreferences.getString(key, null);
    }

    public String getString(@PreferenceKey String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public Set<String> getStringSet(@PreferenceKey String key) {
        return sharedPreferences.getStringSet(key, null);
    }

    public Map<String, ?> getAll() {
        return sharedPreferences.getAll();
    }

    public boolean contains(@PreferenceKey String key) {
        return sharedPreferences.contains(key);
    }

    public void remove(@PreferenceKey String key) {
        editor.remove(key);
        editor.apply();
    }

    public void removeAll() {
        editor.clear();
        editor.apply();
    }


}

