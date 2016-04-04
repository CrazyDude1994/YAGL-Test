package com.crazydude.yagl.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.crazydude.yagl.R;
import com.crazydude.yagl.ui.fragments.RepositoryListFragment;
import com.crazydude.yagl.ui.presenter.BasePresenter;
import com.crazydude.yagl.ui.presenter.RepositoryPresenter;

import javax.inject.Inject;

/**
 * Created by Crazy on 03.04.2016.
 */
public class RepositoryActivity extends BaseActivity {

    @Inject
    RepositoryPresenter mPresenter;

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_repository_placeholder, new RepositoryListFragment())
                .commit();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_repository;
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }
}
