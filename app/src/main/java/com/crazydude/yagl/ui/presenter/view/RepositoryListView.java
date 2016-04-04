package com.crazydude.yagl.ui.presenter.view;

import com.crazydude.yagl.model.GithubRepository;

import java.util.List;

/**
 * Created by Crazy on 04.04.2016.
 */
public interface RepositoryListView {

    void setData(List<GithubRepository> githubRepositories);

    void showUpdateFailSnackbar();

    void setRefreshing(boolean b);
}
