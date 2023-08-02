package com.earl.weatherappjava.data.localDataSource;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.earl.weatherappjava.data.localDataSource.entities.CurrentWeatherDbEntity;

@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNewCurrentWeather(CurrentWeatherDbEntity weatherDb);
}
