package com.crazydude.yagl.managers;

import com.alorma.github.sdk.bean.dto.request.CreateAuthorization;
import com.alorma.github.sdk.bean.dto.response.Repo;
import com.alorma.github.sdk.services.login.CreateAuthorizationClient;
import com.alorma.github.sdk.services.repos.UserReposClient;
import com.alorma.gitskarios.core.Pair;
import com.alorma.gitskarios.core.client.TokenProvider;
import com.crazydude.yagl.exception.GithubAuthException;
import com.crazydude.yagl.exception.NetworkException;
import com.crazydude.yagl.model.database.GithubRepositoryModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit.RetrofitError;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;


/**
 * Created by Crazy on 03.04.2016.
 */
public class GithubManager {

    public static final String CLIENT_ID = "290701447ef43f68c479";
    public static final String CLIENT_SECRET = "dbf63ddfe6922d9628d537b0c4cf860fe8d11c38";
    public static final String[] SCOPES = new String[]{"public_repo"};

    private PreferenceManager mPreferenceManager;

    @Inject
    public GithubManager(PreferenceManager preferenceManager) {
        mPreferenceManager = preferenceManager;
    }

    public Observable login(String username, String password) {
        CreateAuthorization createAuthorization = new CreateAuthorization();
        createAuthorization.client_id = CLIENT_ID;
        createAuthorization.client_secret = CLIENT_SECRET;
        createAuthorization.scopes = SCOPES;

        return new CreateAuthorizationClient(username, password, createAuthorization)
                .observable()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(githubAuthorization -> {
                    mPreferenceManager.setToken(githubAuthorization.token);
                    TokenProvider.setTokenProviderInstance(() -> githubAuthorization.token);
                })
                .onErrorResumeNext(throwable -> {
                    if (throwable instanceof RetrofitError) {
                        return Observable.error(new NetworkException());
                    } else {
                        return Observable.error(new GithubAuthException());
                    }
                });
    }
}
