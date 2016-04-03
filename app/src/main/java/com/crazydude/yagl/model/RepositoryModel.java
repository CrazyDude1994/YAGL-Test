package com.crazydude.yagl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Crazy on 03.04.2016.
 */
@Data
@AllArgsConstructor
@Accessors(prefix = "m")
public class RepositoryModel {

    private String mName;
}
