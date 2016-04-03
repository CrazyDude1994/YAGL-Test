package com.crazydude.yagl.di.modules;

import android.app.Application;
import android.content.Context;

import com.crazydude.yagl.YAGLApplication;
import com.crazydude.yagl.di.qualifiers.ApplicationContext;
import com.crazydude.yagl.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Crazy on 03.04.2016.
 */
@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideApplicationContext() {
        return mApplication;
    }
}
