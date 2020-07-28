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
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InicioSesion extends AppCompatActivity {

    Button botonlogin;
    Button registrarse;
    Button olvidarpassword;
    EditText nombre;
    EditText contraseña;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        botonlogin = (Button)findViewById(R.id.button4);
        botonlogin.setOnClickListener(listen);

        registrarse = (Button)findViewById(R.id.button);
        registrarse.setOnClickListener(listen);

        olvidarpassword = (Button)findViewById(R.id.button2);
        olvidarpassword.setOnClickListener(listen);


    }

    final View.OnClickListener listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.button:
                    intent = new Intent(InicioSesion.this, RegistroUsuario.class);
                    startActivity(intent);
                    break;

                case R.id.button2:
                    intent = new Intent(InicioSesion.this, EnterCode.class);
                    startActivity(intent);
                    break;

                case R.id.button4:
                    Toast.makeText(InicioSesion.this, "Llegamos al Switch", Toast.LENGTH_LONG);

                    // capturamos los datos de name y password
                    nombre = (EditText)findViewById(R.id.editText2);
                    contraseña = (EditText)findViewById(R.id.editText3);

                    LoginData logindata = new LoginData(
                            nombre.getText().toString(),
                            contraseña.getText().toString()
                    );

                    // creamos la llamada
                    Call<List> llamada = ApiAdapter.getApiService().detalle_perfil_rest("basic bWF0aWFzdWE6bWF0aTc3", logindata);

                    llamada.enqueue(new Callback<List>() {
                        @Override
                        public void onResponse(Call<List> call, Response<List> response) {
                            if (response.isSuccessful()){
                                Log.d("Funciona",""+response.body());
                                Toast.makeText(InicioSesion.this, "Bienvenido Reciclador", Toast.LENGTH_LONG);
                                List data = response.body();

                                Gson gson = new Gson();
                                String datajson = gson.toJson(data);
                                Log.d("datajson", datajson);

                                Intent intentperfil =new Intent(InicioSesion.this, VisualizarPerfil.class );
                                intentperfil.putExtra("NombreReciclador", datajson );
                                startActivity(intentperfil);

                            }

                        }

                        @Override
                        public void onFailure(Call<List> call, Throwable t) {
                            Log.d("Ta Malito",""+t);
                            Toast.makeText(InicioSesion.this, "Tu solicitud de ingreso no fue posible, por favor verifique los datos", Toast.LENGTH_LONG);
                        }
                    });


                    break;
            }

        }
    };

}