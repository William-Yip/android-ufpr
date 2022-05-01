package com.example.oscar_app.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    public static Service getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);

        return service;
    }

    public static MovieResourceService getMovieService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://wecodecorp.com.br/ufpr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieResourceService service = retrofit.create(MovieResourceService.class);

        return service;
    }

}