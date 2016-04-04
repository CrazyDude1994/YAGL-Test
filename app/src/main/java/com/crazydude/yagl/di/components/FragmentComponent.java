package com.crazydude.yagl.di.components;

import com.crazydude.yagl.di.modules.FragmentModule;
import com.crazydude.yagl.di.scopes.FragmentScope;
import com.crazydude.yagl.ui.fragments.RepositoryListFragment;

import dagger.Subcomponent;

/**
 * Created by Crazy on 03.04.2016.
 */
@FragmentScope
@Subcomponent(modules = {FragmentModule.class})
public interface FragmentComponent {

    void inject(RepositoryListFragment repositoryListFragment);
}
