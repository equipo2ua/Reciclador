package com.example.reciclador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecoverAccount extends AppCompatActivity {
    Intent intent;
    Button botoncancelar;
    Button botonverificar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_account);

        botoncancelar = (Button) findViewById(R.id.r_c_cancelar);
        botoncancelar.setOnClickListener(listen);

        botonverificar = (Button) findViewById(R.id.r_c_verificar);
        botonverificar.setOnClickListener(listen);
    }

    View.OnClickListener listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.r_c_cancelar:
                    intent = new Intent(RecoverAccount.this, InicioSesion.class);
                    startActivity(intent);
                    break;

                case R.id.r_c_verificar:
                    intent = new Intent(RecoverAccount.this, NewPassword.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}