package com.crazydude.yagl.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.crazydude.yagl.di.qualifiers.ApplicationContext;

import javax.inject.Inject;

/**
 * Created by Crazy on 04.04.2016.
 */
public class PreferenceManager {

    private static final String PREFS_NAME = "DefaultPrefs";

    SharedPreferences mSharedPreferences;

    @Inject
    public PreferenceManager(@ApplicationContext Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void setToken(String token) {
        mSharedPreferences.edit().putString("token", token).apply();
    }

    public String getToken() {
        return mSharedPreferences.getString("token", null);
    }
}
