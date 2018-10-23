package com.example.sandeepsaini.favourite;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Sandeep Saini on 10/23/2018
 */


@Retention(RetentionPolicy.SOURCE)
@StringDef({
        PreferenceKey.USER_LOGIN_STATUS,
        PreferenceKey.EMAIL,
        PreferenceKey.STUDENT_EMAIL,
        PreferenceKey.STUDENT_ID,
        PreferenceKey.STUDENT_NAME,
        PreferenceKey.STUDENT_ENTITY_ID,
        PreferenceKey.PASSWORD,
        PreferenceKey.STUDENT_COURSE_LIST,
        PreferenceKey.LAST_READ_CONTENT_LIST,
        PreferenceKey.STUDENT_AUTH_TOKEN,
        PreferenceKey.LAST_WATCHED_CONTENT_LIST,
        PreferenceKey.STUDENT_PROFILE,
        PreferenceKey.SECTION_ONE_SPENT_TIME,
        PreferenceKey.CURRENT_LAB_MODULE_ID,
        PreferenceKey.LAB_VIDEO_IP

})



public @interface PrefrenceKey {
}
