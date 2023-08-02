package com.earl.weatherappjava.di;

import android.app.Application;

import com.earl.weatherappjava.presentation.WeatherFragment;

import dagger.BindsInstance;
import dagger.Component;

@AppScope
@Component(modules = {
        BaseModule.class,
        MappersModule.class
})
public interface AppComponent {

    void inject(WeatherFragment fragment);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application context);

        AppComponent build();
    }
}
