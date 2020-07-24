package com.example.reciclador.Consumer.Response;

import com.example.reciclador.Consumer.Model.LoginData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    @POST ("data_api/")
    Call<List> iniciar_sesion(@Header("Authorization") String Authorization, @Body LoginData logindata);
}
