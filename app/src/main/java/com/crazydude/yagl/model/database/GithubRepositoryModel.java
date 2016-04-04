package com.crazydude.yagl.model.database;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created by Crazy on 03.04.2016.
 */
@Data
@AllArgsConstructor
@Accessors(prefix = "m")
@Table(name = "Repository")
@NoArgsConstructor
public class GithubRepositoryModel extends Model {

    @Column(name = "serverId", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private long mServerId;
    @Column(name = "name")
    private String mName;
}
