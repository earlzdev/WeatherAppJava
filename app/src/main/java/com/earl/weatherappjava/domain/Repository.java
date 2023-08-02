package com.earl.weatherappjava.domain;

import com.earl.weatherappjava.domain.models.CurrentWeather;

import io.reactivex.rxjava3.core.Single;

public interface Repository {

    Single<CurrentWeather> fetchCurrentWeather(Double lat, Double lon);
}
