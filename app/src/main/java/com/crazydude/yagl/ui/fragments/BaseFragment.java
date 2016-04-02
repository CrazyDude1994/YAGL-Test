package com.crazydude.yagl.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazydude.yagl.di.components.ActivityComponent;
import com.crazydude.yagl.di.components.FragmentComponent;
import com.crazydude.yagl.di.modules.FragmentModule;
import com.crazydude.yagl.ui.activity.BaseActivity;

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

        mFragmentComponent = getActivityComponent()
                .provideFragmentComponent(new FragmentModule(this));
        injectDependencies();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(getLayoutRes(), container, false);
        ButterKnife.bind(view);

        return view;
    }

    protected ActivityComponent getActivityComponent() {
        return ((BaseActivity) getActivity()).getActivityComponent();
    }

    abstract protected void injectDependencies();

    abstract protected int getLayoutRes();
}
