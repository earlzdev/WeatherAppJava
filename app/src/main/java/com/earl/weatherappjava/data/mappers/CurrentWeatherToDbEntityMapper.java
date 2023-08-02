package com.earl.weatherappjava.data.mappers;

import com.earl.weatherappjava.data.localDataSource.entities.CurrentWeatherDbEntity;
import com.earl.weatherappjava.domain.models.CurrentWeather;

public class CurrentWeatherToDbEntityMapper implements BaseMapper<CurrentWeather, CurrentWeatherDbEntity> {

    public CurrentWeatherToDbEntityMapper() {};

    @Override
    public CurrentWeatherDbEntity map(CurrentWeather value) {
        return new CurrentWeatherDbEntity(
                0,
                value.getWindSpeed(),
                value.getDegrees(),
                value.getDescription()
        );
    }
}
