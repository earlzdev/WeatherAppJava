package com.earl.weatherappjava.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.earl.weatherappjava.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationContract {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            showWeatherFragment();
        }
    }

    @Override
    public void showWeatherFragment() {
        showFragmentWithoutBackstack(WeatherFragment.newInstance(), WeatherFragment.TAG);
    }

    private void showFragmentWithoutBackstack(Fragment fragment, String TAG) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, fragment, TAG)
                .commit();
    }
}