package com.earl.weatherappjava.data.remoteDataSource.models;

import java.util.ArrayList;

import kotlinx.serialization.Serializable;

//@Serializable
//public class CurrentWeatherRemoteResponse {
//    Double windSpeed;
//    Double degrees;
//    String description;
//
//    public CurrentWeatherRemoteResponse(
//            Double windSpeed,
//            Double degrees,
//            String description
//    ) {
//        this.windSpeed = windSpeed;
//        this.degrees = degrees;
//        this.description = description;
//    }
//
//    public Double getWindSpeed() {
//        return windSpeed;
//    }
//
//    public Double getDegrees() {
//        return degrees;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//}

@Serializable
public class CurrentWeatherRemoteResponse{
    public Coord coord;
    public ArrayList<Weather> weather;
    public String base;
    public Main main;
    public int visibility;
    public Wind wind;
    public Clouds clouds;
    public int dt;
    public Sys sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;

    public CurrentWeatherRemoteResponse(
            Coord coord,
    ArrayList<Weather> weather,
    String base,
    Main main,
    int visibility,
    Wind wind,
    Clouds clouds,
    int dt,
    Sys sys,
    int timezone,
    int id,
    String name,
    int cod
    ) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public String getDescription() {
        return weather.get(0).description;
    }

    public double getDegrees() {
        return main.feels_like;
    }

    public double getWindSpeed() {
        return wind.speed;
    }
}

class Clouds{
    public int all;
}

class Coord{
    public double lon;
    public double lat;
}

class Main{
    public double temp;
    public double feels_like;
    public double temp_min;
    public double temp_max;
    public int pressure;
    public int humidity;
    public int sea_level;
    public int grnd_level;
}

class Sys{
    public int type;
    public int id;
    public String country;
    public int sunrise;
    public int sunset;
}

class Weather{
    public int id;
    public String main;
    public String description;
    public String icon;
}

class Wind{
    public double speed;
    public int deg;
    public double gust;
}


