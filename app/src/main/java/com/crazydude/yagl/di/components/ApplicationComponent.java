package com.crazydude.yagl.di.components;

import com.crazydude.yagl.YAGLApplication;
import com.crazydude.yagl.di.modules.ActivityModule;
import com.crazydude.yagl.di.modules.ApplicationModule;
import com.crazydude.yagl.di.scopes.ApplicationScope;

import dagger.Component;

/**
 * Created by Crazy on 03.04.2016.
 */
@ApplicationScope
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    ActivityComponent provideActivityComponent(ActivityModule activityModule);

    void inject(YAGLApplication application);
}
