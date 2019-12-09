package com.codinginflow.vipertrader.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SingletonClass {
    private Api api;

    private static SingletonClass instance = null;
    public static final String BASE_URL = "https://tbpilot.matriksdata.com/9999/";

    public static SingletonClass getInstance() {
        if (instance == null)
            instance = new SingletonClass();

        return instance;
    }

    private SingletonClass() {

        createApi();
    }

    private void createApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        api = retrofit.create(Api.class);
    }

    public Api getApi() {
        return api;
    }
}