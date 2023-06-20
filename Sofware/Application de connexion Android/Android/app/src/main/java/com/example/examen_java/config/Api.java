package com.example.examen_java.config;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    @GET("/login")
    Call<ResponseBody> login(@Query("email")String email, @Query("password")String password);

    @GET("/cvs/getAll")
    Call<ResponseBody> all();

    @GET("/cvs/get/{id}")
    Call<ResponseBody> get(@Path("id")int id);

}

