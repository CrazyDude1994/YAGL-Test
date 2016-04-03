package com.crazydude.yagl.ui.presenter;

import com.alorma.gitskarios.core.client.TokenProvider;
import com.crazydude.yagl.R;
import com.crazydude.yagl.exception.GithubAuthException;
import com.crazydude.yagl.exception.NetworkException;
import com.crazydude.yagl.managers.GithubManager;
import com.crazydude.yagl.managers.PreferenceManager;
import com.crazydude.yagl.ui.presenter.view.LoginView;

import javax.inject.Inject;

/**
 * Created by Crazy on 02.04.2016.
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    private GithubManager mGithubManager;
    private PreferenceManager mPreferenceManager;

    @Inject
    public LoginPresenter(GithubManager githubManager, PreferenceManager preferenceManager) {
        mGithubManager = githubManager;
        mPreferenceManager = preferenceManager;
    }

    public void login(String username, String password) {
        mGithubManager.login(username, password)
                .subscribe(o -> getView().loginSuccess(),
                        throwable -> {
                            int reason = 0;
                            if (throwable instanceof GithubAuthException) {
                                reason = R.string.wrong_login_password;
                            } else if (throwable instanceof NetworkException) {
                                reason = R.string.network_error;
                            } else {
                                reason = R.string.unknown_error;
                            }
                            if (getView() != null) {
                                getView().loginFailed(reason);
                            }
                        });
    }

    public void checkLogin() {
        if (mPreferenceManager.getToken() != null && getView() != null) {
            TokenProvider.setTokenProviderInstance(() -> mPreferenceManager.getToken());
            getView().loginSuccess();
        }
    }
}
