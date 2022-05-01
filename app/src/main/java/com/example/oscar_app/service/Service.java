package com.example.oscar_app.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Service {

    @POST("user/login")
    Call<Void> login(@Body LoginDTO loginDTO);

}