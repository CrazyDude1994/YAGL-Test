package com.crazydude.yagl.di.components;

import com.crazydude.yagl.YAGLApplication;
import com.crazydude.yagl.di.modules.ActivityModule;
import com.crazydude.yagl.di.modules.ApplicationModule;

import dagger.Component;

/**
 * Created by Crazy on 03.04.2016.
 */
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    ActivityComponent provideActivityComponent(ActivityModule activityModule);

    void inject(YAGLApplication application);
}
