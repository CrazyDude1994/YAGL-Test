package com.crazydude.yagl.repository;

import com.crazydude.yagl.repository.specification.Specification;

import java.util.List;

import rx.Observable;

/**
 * Created by Crazy on 04.04.2016.
 */
public interface Repository<T> {

    void add(T item);

    void add(Iterable<T> items);

    void update(T item);

    void remove(T item);

    Observable<List<T>> query(Specification specification);
}
