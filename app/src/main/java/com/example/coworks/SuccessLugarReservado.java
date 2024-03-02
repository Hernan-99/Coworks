package com.example.coworks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.coworks.utils.OcultarActionBar;
import com.example.coworks.utils.RedireccionamientoNavbar;
import com.example.coworks.ui.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SuccessLugarReservado extends AppCompatActivity {

    Button btnHome;

    BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_lugar_reservado);

        nav = findViewById(R.id.bottom_navbar);
        RedireccionamientoNavbar listener = new RedireccionamientoNavbar(this);
        nav.setOnItemSelectedListener(listener);



        //funcion para ocultar barras
        OcultarActionBar.ocultar(this);
        btnHome = findViewById(R.id.btnVolverHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccessLugarReservado.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}