package com.crazydude.yagl.ui.presenter;

import com.crazydude.yagl.managers.GithubManager;
import com.crazydude.yagl.model.RepositoryModel;
import com.crazydude.yagl.ui.presenter.view.RepositoryView;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by Crazy on 03.04.2016.
 */
public class RepositoryPresenter extends BasePresenter<RepositoryView> {

    private GithubManager mGithubManager;

    @Inject
    public RepositoryPresenter(GithubManager githubManager) {
        mGithubManager = githubManager;
    }

    public void loadSelfRepositories() {
        mGithubManager.loadSelfRepository().subscribe(new Action1<ArrayList<RepositoryModel>>() {
            @Override
            public void call(ArrayList<RepositoryModel> repositoryModels) {

            }
        });
    }
}
