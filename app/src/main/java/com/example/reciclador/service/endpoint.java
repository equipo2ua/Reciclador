package com.example.reciclador.service;

import com.example.reciclador.models.Campos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface endpoint {

    @POST("iniciar_reciclador_ep/")
    Call<List> iniciar_sesion(@Header("Authentication")String Autorizar, @Body Campos campos );
}
