package com.crazydude.yagl.di.modules;

import com.crazydude.yagl.ui.fragments.BaseFragment;

import dagger.Module;

/**
 * Created by Crazy on 03.04.2016.
 */
@Module
public class FragmentModule {

    private BaseFragment mBaseFragment;

    public FragmentModule(BaseFragment baseFragment) {
        mBaseFragment = baseFragment;
    }
}
