package com.crazydude.yagl.ui.presenter;

import android.support.annotation.Nullable;

import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Created by Crazy on 03.04.2016.
 */
@Accessors(prefix = "m")
public class BasePresenter<V> {

    @Getter
    @Nullable
    private V mView;

    public void attachView(V view) {
        mView = view;
    }

    public void detachView() {
        mView = null;
    }
}
