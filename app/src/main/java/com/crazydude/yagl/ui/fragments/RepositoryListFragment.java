package com.crazydude.yagl.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.crazydude.yagl.R;
import com.crazydude.yagl.model.GithubRepository;
import com.crazydude.yagl.ui.adapters.RepositoryAdapter;
import com.crazydude.yagl.ui.presenter.BasePresenter;
import com.crazydude.yagl.ui.presenter.RepositoryListPresenter;
import com.crazydude.yagl.ui.presenter.view.RepositoryListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by Crazy on 04.04.2016.
 */
public class RepositoryListFragment extends BaseFragment implements RepositoryListView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.fragment_repository_list_recycler)
    RecyclerView mRepositoryRecycler;
    @Bind(R.id.fragment_repository_list_refresher)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    RepositoryAdapter mRepositoryAdapter;

    @Inject
    RepositoryListPresenter mPresenter;

    @Override
    public void setRefreshing(boolean refreshing) {
        mSwipeRefreshLayout.setRefreshing(refreshing);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecycler();
        mPresenter.loadSelfRepositories();
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void setData(List<GithubRepository> githubRepositories) {
        mRepositoryAdapter.setData(githubRepositories);
    }

    @Override
    protected void injectDependencies() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_repository_list;
    }

    private void initRecycler() {
        mRepositoryRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRepositoryRecycler.setAdapter(mRepositoryAdapter);
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void showUpdateFailSnackbar() {
        Snackbar.make(getView(), R.string.failed_to_fetch_repositories, Snackbar.LENGTH_LONG)
                .setAction(R.string.retry, view -> {
                    mPresenter.loadSelfRepositories();
                })
                .show();
    }

    @Override
    public void onRefresh() {
        mPresenter.loadSelfRepositories();
    }
}
