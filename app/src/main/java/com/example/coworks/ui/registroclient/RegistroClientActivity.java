package com.example.coworks.ui.registroclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coworks.ui.registroadmin.RegistroAdminActivity;
import com.example.coworks.ui.login.LoginActivity;
import com.example.coworks.utils.OcultarActionBar;
import com.example.coworks.R;

public class RegistroClientActivity extends AppCompatActivity {

    EditText nombre, telefono, email, password;

    private TextView login, adminRegistro;
    private Button btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //funcion para ocultar barras
        OcultarActionBar.ocultar(this);

        nombre = findViewById(R.id.iptNombre);
        telefono = findViewById(R.id.iptTel);
        email = findViewById(R.id.iptEmail);
        password = findViewById(R.id.iptPassword);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        adminRegistro = findViewById(R.id.registroAdmin);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegistroClientActivity.this, "Usuario creado, inicie sesion", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegistroClientActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        login = findViewById(R.id.iniciarSesion);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistroClientActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        adminRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistroClientActivity.this, RegistroAdminActivity.class);
                startActivity(intent);
            }
        });

    }
}