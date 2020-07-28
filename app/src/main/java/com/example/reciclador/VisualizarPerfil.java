package com.example.reciclador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.reciclador.Consumer.Model.DeserealizarPerfil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VisualizarPerfil extends AppCompatActivity {

    private TextView tv001_;
    private TextView tv002_;
    private TextView tv004_;
    private TextView tv005_;
    private TextView tv006_;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_perfil);

        tv001_ = findViewById(R.id.tv001);
        tv002_ = findViewById(R.id.tv002);
        tv004_ = findViewById(R.id.tv004);
        tv005_ = findViewById(R.id.tv005);
        tv006_ = findViewById(R.id.tv006);



        Bundle bundle = this.getIntent().getExtras();
        Gson gson = new Gson();
        String datos = bundle.getString("NombreReciclador");
        Type type = new TypeToken<ArrayList<DeserealizarPerfil>>(){}.getType();
        ArrayList<DeserealizarPerfil> items = gson.fromJson(datos, type);

        tv001_.setText(items.get(0).getNombre_reciclador());
        tv002_.setText(items.get(0).getApellido_reciclador());
        tv004_.setText(items.get(0).getRut_reciclador());
        String b = String.valueOf(items.get(0).getTelefono_reciclador());
        tv005_.setText(b);
        tv006_.setText(items.get(0).getCorreo_reciclador());

        //DeserealizarPerfil lista = gson.fromJson(getIntent().getExtras().getString("NombreReciclador"), DeserealizarPerfil.class);
        //Log.d("Lista",""+getIntent().getExtras().getString("NombreReciclador"));
    }
}