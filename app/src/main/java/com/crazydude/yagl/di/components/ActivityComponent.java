package com.crazydude.yagl.di.components;

import com.crazydude.yagl.di.modules.ActivityModule;
import com.crazydude.yagl.di.modules.FragmentModule;
import com.crazydude.yagl.di.scopes.ActivityScope;
import com.crazydude.yagl.ui.activity.LoginActivity;
import com.crazydude.yagl.ui.activity.RepositoryActivity;
import com.crazydude.yagl.ui.presenter.view.LoginView;

import dagger.Subcomponent;

/**
 * Created by Crazy on 03.04.2016.
 */
@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    FragmentComponent provideFragmentComponent(FragmentModule fragmentModule);

    void inject(LoginActivity loginActivity);

    void inject(RepositoryActivity repositoryActivity);
}
