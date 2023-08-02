package com.earl.weatherappjava.data.localDataSource.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "LastSeenWeather")
public class CurrentWeatherDbEntity {
    @PrimaryKey(autoGenerate = true) int id;
    @ColumnInfo(name = "windSpeed") double windSpeed;
    @ColumnInfo(name = "degrees") double degrees;
    @ColumnInfo(name = "description") String description;

    public CurrentWeatherDbEntity(
            Integer id,
            Double windSpeed,
            Double degrees,
            String description
    ) {
        this.id = id;
        this.windSpeed = windSpeed;
        this.degrees = degrees;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public double getDegrees() {
        return degrees;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getDescription() {
        return description;
    }
}
