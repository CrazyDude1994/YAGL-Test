package com.crazydude.yagl.repository.mappers;

import com.alorma.github.sdk.bean.dto.response.Repo;
import com.crazydude.yagl.model.GithubRepository;

/**
 * Created by Crazy on 04.04.2016.
 */
public class RestToGithubRepositoryMapper implements Mapper<Repo, GithubRepository> {

    @Override
    public GithubRepository map(Repo repo) {
        return new GithubRepository(repo.id, repo.name);
    }
}
