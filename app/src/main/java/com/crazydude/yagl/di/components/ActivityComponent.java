package com.crazydude.yagl.di.components;

import com.crazydude.yagl.di.modules.ActivityModule;
import com.crazydude.yagl.di.modules.FragmentModule;
import com.crazydude.yagl.ui.activity.LoginActivity;

import dagger.Subcomponent;

/**
 * Created by Crazy on 03.04.2016.
 */
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    FragmentComponent provideFragmentComponent(FragmentModule fragmentModule);

    void inject(LoginActivity loginActivity);
}
