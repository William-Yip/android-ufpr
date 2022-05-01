package com.example.oscar_app.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieResourceService {


    @GET("filme")
    Call<List<MovieDTO>> getMovies();

    @GET("diretor")
    Call<List<DirectorDTO>> getDirector();


}
