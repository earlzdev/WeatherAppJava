package com.earl.weatherappjava.data;

import com.earl.weatherappjava.BuildConfig;
import com.earl.weatherappjava.data.localDataSource.WeatherDao;
import com.earl.weatherappjava.data.localDataSource.entities.CurrentWeatherDbEntity;
import com.earl.weatherappjava.data.mappers.BaseMapper;
import com.earl.weatherappjava.data.remoteDataSource.NetworkService;
import com.earl.weatherappjava.data.remoteDataSource.models.CurrentWeatherRemoteResponse;
import com.earl.weatherappjava.domain.Repository;
import com.earl.weatherappjava.domain.models.CurrentWeather;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RepositoryImpl implements Repository {

    WeatherDao weatherDao;
    NetworkService networkService;
    BaseMapper<CurrentWeatherRemoteResponse, CurrentWeather> currentWeatherRemoteToMainMapper;
    BaseMapper<CurrentWeather, CurrentWeatherDbEntity> currentWeatherDbEntityMapper;

    public RepositoryImpl(
            WeatherDao weatherDao,
            NetworkService networkService,
            BaseMapper<CurrentWeatherRemoteResponse, CurrentWeather> currentWeatherRemoteToMainMapper,
            BaseMapper<CurrentWeather, CurrentWeatherDbEntity> currentWeatherDbEntityMapper
    ) {
        this.weatherDao = weatherDao;
        this.networkService = networkService;
        this.currentWeatherRemoteToMainMapper = currentWeatherRemoteToMainMapper;
        this.currentWeatherDbEntityMapper = currentWeatherDbEntityMapper;
    };

    @Override
    public Single<CurrentWeather> fetchCurrentWeather(Double lat, Double lon) {
        return networkService.fetchCurrentWeather(lat, lon, BuildConfig.API_KEY)
                .map(remoteResponse -> currentWeatherRemoteToMainMapper.map(remoteResponse))
                .doOnSuccess(weather -> {
                    weatherDao.insertNewCurrentWeather(currentWeatherDbEntityMapper.map(weather));
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
