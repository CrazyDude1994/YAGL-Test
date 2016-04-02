package com.crazydude.yagl.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.crazydude.yagl.R;
import com.crazydude.yagl.ui.presenter.LoginPresenter;
import com.crazydude.yagl.ui.presenter.view.LoginView;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    LoginPresenter mPresenter;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }
}
