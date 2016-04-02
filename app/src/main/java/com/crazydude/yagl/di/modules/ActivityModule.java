package com.crazydude.yagl.di.modules;

import com.crazydude.yagl.ui.activity.BaseActivity;

import java.lang.ref.WeakReference;

import dagger.Module;

/**
 * Created by Crazy on 03.04.2016.
 */
@Module
public class ActivityModule {

    private WeakReference<BaseActivity> mActivityRef;

    public ActivityModule(BaseActivity baseActivity) {
        mActivityRef = new WeakReference<>(baseActivity);
    }
}
