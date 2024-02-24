package com.example.coworks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coworks.interfaces.RedireccionamientoNavbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PerfilActivity extends AppCompatActivity {

    private TextView bntEliminarCuenta;
    private Button btnGuardarDatos, btnCancelar;
    private BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nav = findViewById(R.id.bottom_navbar);
        RedireccionamientoNavbar listener = new RedireccionamientoNavbar(this);
        nav.setOnItemSelectedListener(listener);

        //para que quede seleccionado el icono
        Menu menu = nav.getMenu();
        MenuItem menuItem = menu.findItem(R.id.perfil);
        menuItem.setChecked(true);

        //funcion para ocultar barras
        OcultarActionBar.ocultar(this);

        // ---- REFERENCIA A ID BTNS ----
        btnGuardarDatos = findViewById(R.id.btnGuardarDatos);
        btnCancelar = findViewById(R.id.btnCancelar);
        bntEliminarCuenta = findViewById(R.id.btnEliminarCuenta);
        //-------------------------------


        // -------- LISTENERS BTNS ---------
        btnGuardarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(PerfilActivity.this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        bntEliminarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this, ConfirmarEliminarCuenta.class);
                startActivity(intent);
            }
        });

        // ----------------------------------
    }
}