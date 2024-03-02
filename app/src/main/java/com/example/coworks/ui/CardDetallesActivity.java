package com.example.coworks.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.coworks.utils.OcultarActionBar;
import com.example.coworks.R;
import com.example.coworks.utils.RedireccionamientoNavbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class CardDetallesActivity extends AppCompatActivity {
    Button btnReserva;
    BottomNavigationView nav;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detalles);

        nav = findViewById(R.id.bottom_navbar);
        RedireccionamientoNavbar listener = new RedireccionamientoNavbar(this);
        nav.setOnItemSelectedListener(listener);

        //funcion para ocultar barras
        OcultarActionBar.ocultar(this);

        btnReserva = findViewById(R.id.btnReserva);
        btnReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardDetallesActivity.this, ReservaActivity.class);
                startActivity(intent);
            }
        });
    }
}
