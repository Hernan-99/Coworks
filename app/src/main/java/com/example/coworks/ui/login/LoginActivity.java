package com.example.coworks.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.coworks.utils.OcultarActionBar;
import com.example.coworks.R;

public class LoginActivity extends AppCompatActivity {
    private EditText emailLogin, passwordLogin;
    private TextView registrarse;
    private Button ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //funcion para ocultar barras
        OcultarActionBar.ocultar(this);

        // ------------ REFERENCIA ID's --------------
        emailLogin = findViewById(R.id.iptEmailLogin);
        passwordLogin = findViewById(R.id.iptPasswordLogin);
        registrarse = findViewById(R.id.registrarse);
        ingresar = findViewById(R.id.ingresar);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creacion de Intent para abrir la activity
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(LoginActivity.this, MainActivity.class);
               startActivity(intent);
            }
        });
    }

}
