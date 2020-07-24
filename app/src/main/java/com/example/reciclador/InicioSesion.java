package com.example.reciclador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.reciclador.Consumer.Model.LoginData;
import com.example.reciclador.Consumer.Response.ApiAdapter;
import com.example.reciclador.Consumer.Response.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InicioSesion extends AppCompatActivity {

    Button botonlogin;
    EditText nombre;
    EditText contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        Log.d("Funciona","XDDDDD");
        botonlogin = (Button)findViewById(R.id.button4);
        botonlogin.setOnClickListener(listen);


    }

    final View.OnClickListener listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(InicioSesion.this, "En el OnClick", Toast.LENGTH_LONG);
            switch (v.getId()){
                case R.id.button4:
                    Toast.makeText(InicioSesion.this, "Llegamos al Switch", Toast.LENGTH_LONG);

                    // capturamos los datos de name y password
                    nombre = (EditText)findViewById(R.id.editText2);
                    contraseña = (EditText)findViewById(R.id.editText3);

                    LoginData logindata = new LoginData(nombre.getText().toString(), contraseña.getText().toString());

                    // creamos la llamada
                    Call<List> llamada = ApiAdapter.getApiService().iniciar_sesion("Basic bWF0aWFzdWE6bWF0aTc3", logindata);

                    llamada.enqueue(new Callback<List>() {
                        @Override
                        public void onResponse(Call<List> call, Response<List> response) {
                            if (response.isSuccessful()){
                                Log.d("Funciona",""+response.body());
                                Toast.makeText(InicioSesion.this, "Funciona", Toast.LENGTH_LONG);
                            }

                        }

                        @Override
                        public void onFailure(Call<List> call, Throwable t) {
                            Log.d("Ta Malito",""+t);
                            Toast.makeText(InicioSesion.this, "Ta Malito", Toast.LENGTH_LONG);
                        }
                    });


                    break;
            }

        }
    };

}