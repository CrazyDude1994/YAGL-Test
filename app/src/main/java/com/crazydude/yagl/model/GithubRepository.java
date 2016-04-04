package com.crazydude.yagl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Crazy on 04.04.2016.
 */
@Data
@AllArgsConstructor
@Accessors(prefix = "m")
public class GithubRepository {

    private long mServerId;
    private String mName;
}

