package com.crazydude.yagl.repository.mappers;

import com.crazydude.yagl.model.GithubRepository;
import com.crazydude.yagl.model.database.GithubRepositoryModel;

import java.util.Map;

/**
 * Created by Crazy on 04.04.2016.
 */
public class GithubRepositoryToDatabaseMapper implements Mapper<GithubRepository, GithubRepositoryModel> {

    @Override
    public GithubRepositoryModel map(GithubRepository githubRepository) {
        return new GithubRepositoryModel(githubRepository.getServerId(), githubRepository.getName());
    }
}
