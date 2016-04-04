package com.crazydude.yagl;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.crazydude.yagl.di.components.ApplicationComponent;
import com.crazydude.yagl.di.components.DaggerApplicationComponent;
import com.crazydude.yagl.di.modules.ApplicationModule;

import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Created by Crazy on 03.04.2016.
 */
@Accessors(prefix = "m")
public class YAGLApplication extends Application {

    @Getter
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        mApplicationComponent.inject(this);
    }
}
