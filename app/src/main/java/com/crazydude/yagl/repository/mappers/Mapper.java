package com.crazydude.yagl.repository.mappers;

/**
 * Created by Crazy on 04.04.2016.
 */
public interface Mapper<From, To> {

    To map(From from);
}
