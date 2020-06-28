package com.example.reciclador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InicioSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
    }
    public void onclicResgistrarusuario(View viwe){
    Intent siguiente = new Intent(this,RegistroUsuario.class);
    startActivity(siguiente);
    }
}