package com.example.reciclador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EnterCode extends AppCompatActivity {
    Intent intent;
    Button botoncancelar;
    Button botonenviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_code);
        botoncancelar = (Button) findViewById(R.id.e_c_cancelar);
        botoncancelar.setOnClickListener(listen);
        botonenviar = (Button) findViewById(R.id.e_c_enviar);
        botonenviar.setOnClickListener(listen);
    }

    View.OnClickListener listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.e_c_cancelar:
                    intent = new Intent(EnterCode.this, InicioSesion.class);
                    startActivity(intent);
                    break;

                case R.id.e_c_enviar:
                    intent = new Intent(EnterCode.this, RecoverAccount.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}