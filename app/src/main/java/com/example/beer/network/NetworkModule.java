package com.example.beer.network;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {
    private static NetworkModule Instance;
    private static final String BASE_URL = "https://api.punkapi.com/v2/beers/";
    private final Retrofit mRetrofit;

    private NetworkModule() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public static NetworkModule getInstance() {
        if (Instance == null) {
            return new NetworkModule();
        }
        return Instance;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}

