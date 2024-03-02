package com.example.coworks.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.coworks.utils.OcultarActionBar;
import com.example.coworks.R;
import com.example.coworks.SuccessLugarReservado;
import com.example.coworks.utils.RedireccionamientoNavbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ReservaActivity extends AppCompatActivity {

    private Button btnReservar, btnCancelar;
    private BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        nav = findViewById(R.id.bottom_navbar);
        RedireccionamientoNavbar listener = new RedireccionamientoNavbar(this);
        nav.setOnItemSelectedListener(listener);


        //ocultar barras
        OcultarActionBar.ocultar(this);


        btnReservar = findViewById(R.id.btnReservar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReservaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReservaActivity.this, SuccessLugarReservado.class);
                startActivity(intent);
            }
        });

    }
}