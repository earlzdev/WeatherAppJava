package com.earl.weatherappjava.presentation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.earl.weatherappjava.R;
import com.earl.weatherappjava.WeatherApp;
import com.earl.weatherappjava.databinding.FragmentWeatherBinding;
import com.earl.weatherappjava.domain.models.CurrentWeather;
import com.earl.weatherappjava.presentation.utils.BaseFragment;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class WeatherFragment extends BaseFragment<FragmentWeatherBinding> {

    public static final String TAG = "WeatherFragment";

    @Inject
    dagger.Lazy<WeatherViewModel.Factory> weatherViewModelFactory;
    WeatherViewModel viewModel;

    @Override
    protected FragmentWeatherBinding viewBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentWeatherBinding.inflate(inflater, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        WeatherApp.instance.appComponent.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = weatherViewModelFactory.get().create(WeatherViewModel.class);
        fetchCurrentWeather();
    }

    private void fetchCurrentWeather() {
        viewModel.fetchCurrentWeather()
                .subscribe(new SingleObserver<CurrentWeather>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {}
                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull CurrentWeather currentWeather) {
                        binding.temp.setText(String.format(getString(R.string.temp_formt), currentWeather.getDegrees()));
                        binding.description.setText(String.format(getString(R.string.desrciption_format), currentWeather.getDescription()));
                    }
                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Toast.makeText(requireContext(), "Error occurred -> " + e, Toast.LENGTH_LONG).show();
                    }
                });
    }

    @NonNull
    public static WeatherFragment newInstance() {
        return new WeatherFragment();
    }
}
