package com.example.reciclador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.reciclador.Consumer.Model.DataRegistroUsuario;
import com.example.reciclador.Consumer.Response.ApiAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroUsuario extends AppCompatActivity {

    Button botonregistro, botoncancelar;
    EditText nombre, apellido, rut, correo, telefono, calleynumero, comuna, contraseña, repetircontraseña;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        botonregistro = (Button) findViewById(R.id.crearRegistro);
        botonregistro.setOnClickListener(Listen);
        botoncancelar = (Button) findViewById(R.id.cancelar);
        botoncancelar.setOnClickListener(Listen);
    }

    View.OnClickListener Listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {


                case R.id.cancelar:
                    intent = new Intent(RegistroUsuario.this, InicioSesion.class);
                    startActivity(intent);
                    break;

                case R.id.crearRegistro:

                    nombre = (EditText) findViewById(R.id.nombre);
                    apellido = (EditText) findViewById(R.id.etapellido);
                    rut = (EditText) findViewById(R.id.etrut);
                    correo = (EditText) findViewById(R.id.etcorreo);
                    telefono = (EditText) findViewById(R.id.ettelefono);
                    calleynumero = (EditText) findViewById(R.id.calle);
                    comuna = (EditText) findViewById(R.id.comuna);
                    contraseña = (EditText) findViewById(R.id.contraseña);
                    repetircontraseña = (EditText) findViewById(R.id.repetirContraseña);

                    final DataRegistroUsuario RegistroUsuario = new DataRegistroUsuario(
                            nombre.getText().toString(),
                            apellido.getText().toString(),
                            rut.getText().toString(),
                            correo.getText().toString(),
                            telefono.getText().toString(),
                            calleynumero.getText().toString(),
                            comuna.getText().toString(),
                            contraseña.getText().toString(),
                            repetircontraseña.getText().toString()


                    );

                    Call<List> llamada = ApiAdapter.getApiService().Registro_Reciclador("basic bWF0aWFzdWE6bWF0aTc3",RegistroUsuario);
                    llamada.enqueue(new Callback<List>() {
                        @Override
                        public void onResponse(Call<List> call, Response<List> response) {

                            if(response.isSuccessful()){
                                intent = new Intent(
                                        RegistroUsuario.this,
                                        InicioSesion.class);
                                startActivity(intent);
                            }

                        }

                        @Override
                        public void onFailure(Call<List> call, Throwable t) {
                            Log.d("FalloLaLlamada", ""+t);

                        }
                    });







            }
        }
    };
}