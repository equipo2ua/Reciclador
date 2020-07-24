package com.example.reciclador.Consumer.Model;

import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("contraseña")
    private String contraseña;

    public LoginData(String nombre, String contraseña){
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

}
