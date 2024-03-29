package com.nilportugues.simplewebapi.users.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserApiFactory {

    private final String baseUrl;

    public UserApiFactory(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public UserApi create() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(UserApi.class);
    }
}