package com.crazydude.yagl.repository.specification;

import com.activeandroid.query.Select;
import com.alorma.github.sdk.bean.dto.response.Repo;
import com.alorma.github.sdk.services.repos.UserReposClient;
import com.alorma.gitskarios.core.Pair;
import com.crazydude.yagl.model.database.GithubRepositoryModel;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

/**
 * Created by Crazy on 04.04.2016.
 */
public class MyRepositoriesSpecification implements ActiveAndroidSpecification, RESTSpecification {

    public MyRepositoriesSpecification() {
    }

    @Override
    public List<GithubRepositoryModel> getResults() {
        return new Select().from(GithubRepositoryModel.class).execute();
    }

    @Override
    public Observable<List<Repo>> getNetworkResults() {
        return new UserReposClient()
                .observable()
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Pair<List<Repo>, Integer>, List<Repo>>() {
                    @Override
                    public List<Repo> call(Pair<List<Repo>, Integer> listIntegerPair) {
                        return listIntegerPair.first;
                    }
                });
    }
}
