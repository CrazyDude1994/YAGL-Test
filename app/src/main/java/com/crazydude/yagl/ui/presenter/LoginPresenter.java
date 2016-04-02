package com.crazydude.yagl.ui.presenter;

import com.crazydude.yagl.ui.presenter.view.LoginView;

import javax.inject.Inject;

/**
 * Created by Crazy on 02.04.2016.
 */
public class LoginPresenter {

    private LoginView mLoginView;

    @Inject
    public LoginPresenter(LoginView loginView) {
        mLoginView = loginView;
    }
}
