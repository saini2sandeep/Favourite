package com.example.sandeepsaini.favourite;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Sandeep Saini on 10/23/2018
 */


@Retention(RetentionPolicy.SOURCE)
@StringDef({
        PreferenceKey.FAVOURITE_CONTENT_LIST,
})



public @interface PreferenceKey {
    String FAVOURITE_CONTENT_LIST = "FAVOURITE_CONTENT_LIST";
}
