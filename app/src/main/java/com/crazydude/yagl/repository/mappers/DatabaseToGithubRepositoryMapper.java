package com.crazydude.yagl.repository.mappers;

import com.crazydude.yagl.model.GithubRepository;
import com.crazydude.yagl.model.database.GithubRepositoryModel;

/**
 * Created by Crazy on 04.04.2016.
 */
public class DatabaseToGithubRepositoryMapper implements Mapper<GithubRepositoryModel, GithubRepository> {

    @Override
    public GithubRepository map(GithubRepositoryModel githubRepositoryModel) {
        return new GithubRepository(githubRepositoryModel.getServerId(), githubRepositoryModel.getName());
    }
}
