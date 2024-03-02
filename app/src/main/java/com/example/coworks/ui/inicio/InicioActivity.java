package com.example.coworks.ui.inicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coworks.ui.login.LoginActivity;
import com.example.coworks.ui.registroclient.RegistroClientActivity;
import com.example.coworks.utils.OcultarActionBar;
import com.example.coworks.R;

public class InicioActivity extends AppCompatActivity {

    private Button btnLogin, btnSignUp;
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
                Intent intent = new Intent(InicioActivity.this, RegistroClientActivity.class);
                startActivity(intent);
            }
        });
    }
}
