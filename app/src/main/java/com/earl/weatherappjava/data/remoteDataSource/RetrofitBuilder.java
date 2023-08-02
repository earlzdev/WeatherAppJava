package com.earl.weatherappjava.data.remoteDataSource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private static final String base_url = "https://api.openweathermap.org/";
    private static NetworkService instance;

    public NetworkService buildNetworkService() {
        if (instance == null) {
            synchronized (RetrofitBuilder.class) {
                if (instance == null) {
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    Gson gsonConverter = new GsonBuilder()
                            .setLenient()
                            .create();
                    OkHttpClient okHttpClient = new OkHttpClient.Builder()
                            .readTimeout(30, TimeUnit.SECONDS)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .addInterceptor(interceptor)
                            .build();
                    instance = new Retrofit.Builder()
                            .client(okHttpClient)
                            .addConverterFactory(GsonConverterFactory.create(gsonConverter))
                            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                            .baseUrl(base_url)
                            .build()
                            .create(NetworkService.class);
                }
            }
        }
        return instance;
    }
}
