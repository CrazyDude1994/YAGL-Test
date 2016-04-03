package com.crazydude.yagl.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.crazydude.yagl.R;
import com.crazydude.yagl.ui.presenter.BasePresenter;
import com.crazydude.yagl.ui.presenter.LoginPresenter;
import com.crazydude.yagl.ui.presenter.view.LoginView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    LoginPresenter mPresenter;

    @Bind(R.id.activity_login_username_edit)
    EditText mUsernameEdit;
    @Bind(R.id.activity_login_password_edit)
    EditText mPasswordEdit;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onResume() {
        super.onResume();

        mPresenter.checkLogin();
    }

    @OnClick(R.id.activity_login_login_button)
    public void onLoginClick() {
        mPresenter.login(mUsernameEdit.getText().toString(),
                mPasswordEdit.getText().toString());
    }

    @Override
    public void loginSuccess() {
        switchToLoggedIn();
    }

    private void switchToLoggedIn() {
        Intent intent = new Intent(this, RepositoryActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginFailed(int reason) {
        showMessageDialog(reason);
    }
}