package com.earl.weatherappjava.data.remoteDataSource;

import com.earl.weatherappjava.data.remoteDataSource.models.CurrentWeatherRemoteResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkService {

    @GET("data/2.5/weather")
    Single<CurrentWeatherRemoteResponse> fetchCurrentWeather(
            @Query("lon") Double lon,
            @Query("lat") Double lat,
            @Query("appid") String key
    );
}
