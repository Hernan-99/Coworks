package com.example.coworks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InicioActivity extends AppCompatActivity {

    Button btnLogin, btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //funcion para ocultar barras
        OcultarActionBar.ocultar(this);


        btnLogin = findViewById(R.id.btnLoginActivity);
        btnSignUp = findViewById(R.id.btnSignUpActivity);

        // Configuracion de evento click para los botones
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creacion de Intent para abrir la activity
                Intent intent = new Intent(InicioActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creacion de Intent para abrir la activity
                Intent intent = new Intent(InicioActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}
