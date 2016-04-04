package com.crazydude.yagl.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazydude.yagl.di.components.ActivityComponent;
import com.crazydude.yagl.di.components.FragmentComponent;
import com.crazydude.yagl.di.modules.FragmentModule;
import com.crazydude.yagl.ui.activity.BaseActivity;
import com.crazydude.yagl.ui.presenter.BasePresenter;

import butterknife.ButterKnife;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Created by Crazy on 03.04.2016.
 */
@Accessors(prefix = "m")
abstract public class BaseFragment extends Fragment {

    @Getter
    private FragmentComponent mFragmentComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Do not recreate presenter
        setRetainInstance(true);

        mFragmentComponent = getActivityComponent()
                .provideFragmentComponent(new FragmentModule(this));
        injectDependencies();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(getLayoutRes(), container, false);
        ButterKnife.bind(this, view);
        getPresenter().attachView(this);

        return view;
    }

    protected ActivityComponent getActivityComponent() {
        return ((BaseActivity) getActivity()).getActivityComponent();
    }

    abstract protected void injectDependencies();

    abstract protected int getLayoutRes();

    abstract protected BasePresenter getPresenter();


    @Override
    public void onPause() {
        super.onPause();
        getPresenter().detachView();
    }
}