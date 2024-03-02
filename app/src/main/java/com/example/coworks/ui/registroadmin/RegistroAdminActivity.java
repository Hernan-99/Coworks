package com.example.coworks.ui.registroadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coworks.R;
import com.example.coworks.ui.login.LoginActivity;

public class RegistroAdminActivity extends AppCompatActivity {
    private Button btnRegistroAdmin;
    private TextView btnIniciar;
    private EditText nombre, telefono, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_admin);

        btnRegistroAdmin = findViewById(R.id.btnRegistro);
        btnIniciar = findViewById(R.id.btnIniciar);

        //------- inputs -------------
        nombre = findViewById(R.id.iptNombreAdmin);
        telefono = findViewById(R.id.iptTelAdmin);
        email = findViewById(R.id.iptEmailAdmin);
        password = findViewById(R.id.iptPassAdmin);

        btnRegistroAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegistroAdminActivity.this, "Admin creado, inicie sesion", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistroAdminActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistroAdminActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}