package com.earl.weatherappjava.domain.models;

public class CurrentWeather {

    int id;
    Double windSpeed;
    Double degrees;
    String description;

    public CurrentWeather(
            int id,
            Double windSpeed,
            Double degrees,
            String description
    ) {
        this.degrees = degrees;
        this.description = description;
        this.id = id;
        this.windSpeed = windSpeed;
    }

    public Double getDegrees() {
        return degrees;
    }

    public String getDescription() {
        return description;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }
}
