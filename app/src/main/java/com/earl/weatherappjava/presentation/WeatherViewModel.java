package com.earl.weatherappjava.presentation;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.earl.weatherappjava.di.AppScope;
import com.earl.weatherappjava.domain.Repository;
import com.earl.weatherappjava.domain.models.CurrentWeather;

import javax.inject.Inject;
import javax.inject.Provider;

import io.reactivex.rxjava3.core.Single;

public class WeatherViewModel extends ViewModel {

    Repository repository;

    /**
     * Можно получить откуда угодно, например определить по ip адерсу.
     * Так как это не цель задания, возьму координаты Москвы.
     */
    private static final Double default_lat = 55.75;
    private static final Double default_lon = 37.37;

    @Inject
    public WeatherViewModel (
            Repository repository
    ) {
        this.repository = repository;
    }

    Single<CurrentWeather> fetchCurrentWeather() {
        return repository.fetchCurrentWeather(default_lat, default_lon);
    }

    @AppScope
    static class Factory implements ViewModelProvider.Factory {

        Provider<Repository> repository;

        @Inject
        public Factory(@NonNull Provider<Repository> repositoryProvider) {
            this.repository = repositoryProvider;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new WeatherViewModel(repository.get());
        }
    }
}
