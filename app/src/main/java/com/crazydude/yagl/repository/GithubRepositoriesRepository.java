package com.crazydude.yagl.repository;

import com.activeandroid.ActiveAndroid;
import com.alorma.github.sdk.bean.dto.response.Repo;
import com.crazydude.yagl.model.GithubRepository;
import com.crazydude.yagl.model.database.GithubRepositoryModel;
import com.crazydude.yagl.repository.mappers.DatabaseToGithubRepositoryMapper;
import com.crazydude.yagl.repository.mappers.GithubRepositoryToDatabaseMapper;
import com.crazydude.yagl.repository.mappers.Mapper;
import com.crazydude.yagl.repository.mappers.RestToGithubRepositoryMapper;
import com.crazydude.yagl.repository.specification.MyRepositoriesSpecification;
import com.crazydude.yagl.repository.specification.Specification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Crazy on 04.04.2016.
 */
public class GithubRepositoriesRepository implements Repository<GithubRepository> {

    private final Mapper<GithubRepository, GithubRepositoryModel> mToDatabaseModelMapper;
    private final Mapper<GithubRepositoryModel, GithubRepository> mToGithubRepositoryMapper;
    private final Mapper<Repo, GithubRepository> mRestToGithubRepositoryMapper;

    @Inject
    public GithubRepositoriesRepository() {
        mToDatabaseModelMapper = new GithubRepositoryToDatabaseMapper();
        mToGithubRepositoryMapper = new DatabaseToGithubRepositoryMapper();
        mRestToGithubRepositoryMapper = new RestToGithubRepositoryMapper();
    }

    @Override
    public void add(GithubRepository item) {
        add(Collections.singletonList(item));
    }

    @Override
    public void add(Iterable<GithubRepository> items) {
        ActiveAndroid.beginTransaction();
        try {
            for (GithubRepository item : items) {
                GithubRepositoryModel dbModel = mToDatabaseModelMapper.map(item);
                dbModel.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        } catch (RuntimeException e) {

        }
        ActiveAndroid.endTransaction();
    }

    @Override
    public void update(GithubRepository item) {
        GithubRepositoryModel dbModel = mToDatabaseModelMapper.map(item);
        dbModel.save();
    }

    @Override
    public void remove(GithubRepository item) {
    }

    @Override
    public Observable<List<GithubRepository>> query(Specification specification) {
        List<GithubRepositoryModel> localResults = ((MyRepositoriesSpecification) specification).getResults();
        Observable<List<Repo>> networkResults = ((MyRepositoriesSpecification) specification).getNetworkResults();

        ArrayList<GithubRepository> repositories = new ArrayList<>();
        for (GithubRepositoryModel result : localResults) {
            repositories.add(mToGithubRepositoryMapper.map(result));
        }

        return Observable.concat(Observable.just(repositories),
                networkResults.map((Func1<List<Repo>, List<GithubRepository>>) repos -> {
                    ArrayList<GithubRepository> githubRepositories = new ArrayList<>();
                    for (Repo repo : repos) {
                        githubRepositories.add(mRestToGithubRepositoryMapper.map(repo));
                    }

                    return githubRepositories;
                }))
                .doOnNext(this::add);
    }
}
