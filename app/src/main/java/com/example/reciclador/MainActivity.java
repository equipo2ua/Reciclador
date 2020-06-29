package com.example.reciclador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
    }
    public void onclicInisioSesion(View view){
        Intent siguiente = new Intent(this, InicioSesion.class);
        startActivity(siguiente);

    }
}