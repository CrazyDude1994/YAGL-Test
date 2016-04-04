package com.crazydude.yagl.ui.adapters;

import android.view.ViewGroup;

import com.crazydude.yagl.model.GithubRepository;
import com.crazydude.yagl.ui.views.RepositoryView;

import javax.inject.Inject;

/**
 * Created by Crazy on 04.04.2016.
 */
public class RepositoryAdapter extends BaseAdapter<GithubRepository, RepositoryView, BaseViewHolder<RepositoryView>> {

    @Inject
    public RepositoryAdapter() {
    }

    @Override
    public BaseViewHolder<RepositoryView> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<>(new RepositoryView(parent.getContext()));
    }
}
