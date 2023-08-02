package com.earl.weatherappjava.di;

import com.earl.weatherappjava.data.localDataSource.entities.CurrentWeatherDbEntity;
import com.earl.weatherappjava.data.mappers.BaseMapper;
import com.earl.weatherappjava.data.mappers.CurrentWeatherRemoteResponseToMainMapper;
import com.earl.weatherappjava.data.mappers.CurrentWeatherToDbEntityMapper;
import com.earl.weatherappjava.data.remoteDataSource.models.CurrentWeatherRemoteResponse;
import com.earl.weatherappjava.domain.models.CurrentWeather;

import dagger.Module;
import dagger.Provides;

@Module
public class MappersModule {

    @Provides
    BaseMapper<CurrentWeatherRemoteResponse, CurrentWeather> provideCurrentWeatherRemoteToMainMapper() {
        return new CurrentWeatherRemoteResponseToMainMapper();
    }

    @Provides
    BaseMapper<CurrentWeather, CurrentWeatherDbEntity> provideCurrentWeatherToDbEntityMapper() {
        return new CurrentWeatherToDbEntityMapper();
    }
}
