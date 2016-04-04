package com.crazydude.yagl.ui.presenter;

import com.crazydude.yagl.repository.GithubRepositoriesRepository;
import com.crazydude.yagl.repository.specification.MyRepositoriesSpecification;
import com.crazydude.yagl.ui.presenter.view.RepositoryView;

import javax.inject.Inject;

/**
 * Created by Crazy on 03.04.2016.
 */
public class RepositoryPresenter extends BasePresenter<RepositoryView> {

    @Inject
    public RepositoryPresenter() {

    }

}
