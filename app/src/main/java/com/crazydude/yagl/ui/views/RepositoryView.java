package com.crazydude.yagl.ui.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.crazydude.yagl.R;
import com.crazydude.yagl.model.GithubRepository;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Crazy on 04.04.2016.
 */
public class RepositoryView extends RelativeLayout implements ViewModel<GithubRepository> {

    @Bind(R.id.view_repository_name_text)
    TextView mRepositoryName;

    public RepositoryView(Context context) {
        super(context);
        init();
    }

    public RepositoryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RepositoryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public RepositoryView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    public void setData(GithubRepository data) {
        mRepositoryName.setText(data.getName());
    }

    private void init() {
        View view = inflate(getContext(), R.layout.view_repository, this);
        ButterKnife.bind(view);
    }
}
