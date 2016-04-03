package com.crazydude.yagl.di.modules;

import android.content.Context;

import com.crazydude.yagl.di.qualifiers.ActivityContext;
import com.crazydude.yagl.di.scopes.ActivityScope;
import com.crazydude.yagl.ui.activity.BaseActivity;

import java.lang.ref.WeakReference;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Crazy on 03.04.2016.
 */
@Module
public class ActivityModule {

    private WeakReference<BaseActivity> mActivityRef;

    public ActivityModule(BaseActivity baseActivity) {
        mActivityRef = new WeakReference<>(baseActivity);
    }

    @ActivityScope
    @ActivityContext
    @Provides
    public Context provideActivityContext() {
        return mActivityRef.get();
    }
}
