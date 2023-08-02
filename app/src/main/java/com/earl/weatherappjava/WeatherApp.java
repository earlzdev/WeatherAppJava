package com.earl.weatherappjava;

import android.app.Application;

import com.earl.weatherappjava.di.AppComponent;
import com.earl.weatherappjava.di.DaggerAppComponent;

public class WeatherApp extends Application {

    public static WeatherApp instance;
    public AppComponent appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
