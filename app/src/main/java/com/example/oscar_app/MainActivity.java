package com.example.oscar_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.oscar_app.service.DirectorDTO;
import com.example.oscar_app.service.LoginDTO;
import com.example.oscar_app.service.MovieDTO;
import com.example.oscar_app.service.MovieResourceService;
import com.example.oscar_app.service.RetrofitConfig;
import com.example.oscar_app.service.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button btn;

    RetrofitConfig retrofit = new RetrofitConfig();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btn = findViewById(R.id.login_btn);
        btn.setOnClickListener(view -> handleLogin(view) );

    }

    public void handleLogin(View view) {
        String usernameStr = username.getText().toString();
        String passwordStr = password.getText().toString();

        LoginDTO loginDTO = new LoginDTO(usernameStr, passwordStr);

//        Call<Void> loginRequest = service.login(loginDTO);
//
//        loginRequest.enqueue(new Callback<Void>() {
//
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                int status = response.code();
//                System.out.println("Request returned with status " + status);
//
//                if (response.isSuccessful()) {
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//
//                System.out.println("Deu ruim");
//            }
//        });

        MovieResourceService movieService = RetrofitConfig.getMovieService();

        Call<List<MovieDTO>> requestMovies = movieService.getMovies();
        Call<List<DirectorDTO>> requestDirectors = movieService.getDirector();

        requestMovies.enqueue(new Callback<List<MovieDTO>>() {

            @Override
            public void onResponse(Call<List<MovieDTO>> call, Response<List<MovieDTO>> response) {
                if (response.isSuccessful()) {
                    try {
                        List<MovieDTO> body = response.body();
                        System.out.println(body);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else
                    System.out.println(response);

            }

            @Override
            public void onFailure(Call<List<MovieDTO>> call, Throwable t) {
                System.out.println("Deu ruim");
            }

        });

        requestDirectors.enqueue(new Callback<List<DirectorDTO>>() {

            @Override
            public void onResponse(Call<List<DirectorDTO>> call, Response<List<DirectorDTO>> response) {
                if (response.isSuccessful()) {
                    try {
                        List<DirectorDTO> body = response.body();
                        System.out.println(body);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else
                    System.out.println(response);

            }

            @Override
            public void onFailure(Call<List<DirectorDTO>> call, Throwable t) {
                System.out.println("Deu ruim");
            }

        });

    }

}