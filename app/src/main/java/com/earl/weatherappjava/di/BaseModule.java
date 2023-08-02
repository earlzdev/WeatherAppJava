package com.earl.weatherappjava.di;

import android.app.Application;

import androidx.annotation.NonNull;

import com.earl.weatherappjava.data.RepositoryImpl;
import com.earl.weatherappjava.data.localDataSource.AppDatabase;
import com.earl.weatherappjava.data.localDataSource.WeatherDao;
import com.earl.weatherappjava.data.localDataSource.entities.CurrentWeatherDbEntity;
import com.earl.weatherappjava.data.mappers.BaseMapper;
import com.earl.weatherappjava.data.remoteDataSource.NetworkService;
import com.earl.weatherappjava.data.remoteDataSource.RetrofitBuilder;
import com.earl.weatherappjava.data.remoteDataSource.models.CurrentWeatherRemoteResponse;
import com.earl.weatherappjava.domain.Repository;
import com.earl.weatherappjava.domain.models.CurrentWeather;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseModule {

    @Provides
    Repository provideRepository(
        WeatherDao weatherDao,
        NetworkService networkService,
        BaseMapper<CurrentWeatherRemoteResponse, CurrentWeather> currentWeatherRemoteToMainMapper,
        BaseMapper<CurrentWeather, CurrentWeatherDbEntity> currentWeatherDbEntityMapper
    ) {
        return new RepositoryImpl(
                weatherDao,
                networkService,
                currentWeatherRemoteToMainMapper,
                currentWeatherDbEntityMapper
        );
    }

    @Provides
    AppDatabase provideAppDatabase(Application context) {
        return AppDatabase.getInstance(context);
    }

    @Provides
    WeatherDao provideWeatherDao(
            @NonNull AppDatabase appDb
    ) {
        return appDb.weatherDao();
    }

    @Provides
    NetworkService provideNetworkService() {
        return new RetrofitBuilder().buildNetworkService();
    }
}
