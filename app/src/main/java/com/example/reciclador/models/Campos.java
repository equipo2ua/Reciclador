package com.example.reciclador.models;

import com.google.gson.annotations.SerializedName;

public class Campos {
    @SerializedName("nombre")
    String nombre;
    @SerializedName("contraseña")
    String contraseña;

    public Campos(String nombre, String contraseña){
        this.nombre = nombre;
        this.contraseña = contraseña;

    }
}
