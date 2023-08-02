package com.earl.weatherappjava.data.mappers;

public interface BaseMapper <T, V> {

    V map(T value);
}
