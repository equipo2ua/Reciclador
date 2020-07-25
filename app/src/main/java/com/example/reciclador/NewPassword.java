package com.example.reciclador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewPassword extends AppCompatActivity {

    Button botoncancelar;
    Button botonenviar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        botoncancelar = (Button) findViewById(R.id.n_p_cancelar);
        botoncancelar.setOnClickListener(listen);

        botonenviar = (Button) findViewById(R.id.n_p_enviar);
        botonenviar.setOnClickListener(listen);

    }

    View.OnClickListener listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.n_p_cancelar:
                    intent = new Intent(NewPassword.this, InicioSesion.class);
                    startActivity(intent);
                    break;

                case  R.id.n_p_enviar:
                    intent = new Intent(NewPassword.this, InicioSesion.class);
                    startActivity(intent);
                    break;
            }

        }
    };
}