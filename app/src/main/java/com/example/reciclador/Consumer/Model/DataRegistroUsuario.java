package com.example.reciclador.Consumer.Model;

import com.google.gson.annotations.SerializedName;

public class DataRegistroUsuario {

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("apellido")
    private  String apellido;

    @SerializedName("rut")
    private  String rut;

    @SerializedName("correo")
    private  String correo;

    @SerializedName("telefono")
    private String telefono;

    @SerializedName("calleynumero")
    private  String calleynumero;

    @SerializedName("comuna")
    private  String comuna;

    @SerializedName("contraseña")
    private String contraseña;

    @SerializedName("repetircontraseña")
    private String repetircontraseña;


    public DataRegistroUsuario(String nombre, String apellido, String rut, String correo, String telefono, String calleynumero, String comuna, String contraseña, String repetircontraseña){

        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.telefono = telefono;
        this.calleynumero = calleynumero;
        this.comuna = comuna;
        this.contraseña = contraseña;
        this.repetircontraseña = repetircontraseña;

    }


}
