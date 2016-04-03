package com.crazydude.yagl.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialog;
import android.test.mock.MockApplication;

import com.crazydude.yagl.R;
import com.crazydude.yagl.YAGLApplication;
import com.crazydude.yagl.di.components.ActivityComponent;
import com.crazydude.yagl.di.components.ApplicationComponent;
import com.crazydude.yagl.di.components.DaggerApplicationComponent;
import com.crazydude.yagl.di.modules.ActivityModule;
import com.crazydude.yagl.ui.presenter.BasePresenter;

import butterknife.ButterKnife;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Created by Crazy on 03.04.2016.
 */
@Accessors(prefix = "m")
abstract public class BaseActivity extends AppCompatActivity {

    @Getter
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        ButterKnife.bind(this);

        mActivityComponent = getApplicationComponent()
                .provideActivityComponent(new ActivityModule(this));
        injectDependencies();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((YAGLApplication) getApplication()).getApplicationComponent();
    }

    abstract protected void injectDependencies();

    abstract protected int getLayoutRes();

    abstract protected BasePresenter getPresenter();

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().attachView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().detachView();
    }

    protected void showMessageDialog(int messageId) {
        AppCompatDialog dialog = new AlertDialog.Builder(this)
                .setMessage(messageId)
                .setCancelable(true)
                .setPositiveButton(R.string.ok, null)
                .create();
        dialog.show();
    }
}
