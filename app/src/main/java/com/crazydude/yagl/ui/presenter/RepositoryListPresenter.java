package com.crazydude.yagl.ui.presenter;

import com.crazydude.yagl.repository.GithubRepositoriesRepository;
import com.crazydude.yagl.repository.specification.MyRepositoriesSpecification;
import com.crazydude.yagl.ui.presenter.view.RepositoryListView;

import javax.inject.Inject;

/**
 * Created by Crazy on 04.04.2016.
 */
public class RepositoryListPresenter extends BasePresenter<RepositoryListView> {

    private GithubRepositoriesRepository mRepository;

    @Inject
    public RepositoryListPresenter(GithubRepositoriesRepository githubRepository) {
        mRepository = githubRepository;
    }

    public void loadSelfRepositories() {
        getView().setRefreshing(true);
        mRepository.query(new MyRepositoriesSpecification())
                .subscribe(githubRepositories -> {
                    if (getView() != null) {
                        getView().setData(githubRepositories);
                        getView().setRefreshing(false);
                    }
                }, throwable -> {
                    if (getView() != null) {
                        getView().showUpdateFailSnackbar();
                        getView().setRefreshing(false);
                    }
                });
    }
}
