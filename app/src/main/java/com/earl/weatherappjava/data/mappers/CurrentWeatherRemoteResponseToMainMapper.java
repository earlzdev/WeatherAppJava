package com.earl.weatherappjava.data.mappers;

import com.earl.weatherappjava.data.remoteDataSource.models.CurrentWeatherRemoteResponse;
import com.earl.weatherappjava.domain.models.CurrentWeather;

public class CurrentWeatherRemoteResponseToMainMapper implements
        BaseMapper<CurrentWeatherRemoteResponse, CurrentWeather> {

    public CurrentWeatherRemoteResponseToMainMapper() {};

    @Override
    public CurrentWeather map(CurrentWeatherRemoteResponse value) {
        return new CurrentWeather(
                0,
                value.getWindSpeed(),
                value.getDegrees(),
                value.getDescription()
        );
    }
}
