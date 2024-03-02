package com.example.coworks.ui.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coworks.ConfirmarEliminarCuenta;
import com.example.coworks.ui.MainActivity;
import com.example.coworks.ui.inicio.InicioActivity;
import com.example.coworks.utils.OcultarActionBar;
import com.example.coworks.R;
import com.example.coworks.utils.RedireccionamientoNavbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PerfilActivity extends AppCompatActivity {

    // variables
    private TextView iptNombre, iptTelefono, iptEmail, iptPassword;
    private TextView bntEliminarCuenta, btnCerrarSesion;
    private Button btnGuardarDatos, btnCancelar;
    private BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        //funcion para ocultar barras
        OcultarActionBar.ocultar(this);



        nav = findViewById(R.id.bottom_navbar);
        RedireccionamientoNavbar listener = new RedireccionamientoNavbar(this);
        nav.setOnItemSelectedListener(listener);

        //para que quede seleccionado el icono
        Menu menu = nav.getMenu();
        MenuItem menuItem = menu.findItem(R.id.perfil);
        menuItem.setChecked(true);

        // ---- REFERENCIA A ID's ----
        iptNombre = findViewById(R.id.iptNombre);
        iptTelefono = findViewById(R.id.iptTelefono);
        iptEmail = findViewById(R.id.iptEmail);
        iptPassword = findViewById(R.id.iptPassword);
        btnGuardarDatos = findViewById(R.id.btnGuardarDatos);
        btnCancelar = findViewById(R.id.btnCancelar);
        bntEliminarCuenta = findViewById(R.id.btnEliminarCuenta);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);
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

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PerfilActivity.this, "Cerrando sesion", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PerfilActivity.this, InicioActivity.class);
                startActivity(intent);
                finish();
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