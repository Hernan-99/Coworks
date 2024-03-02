package com.example.coworks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.coworks.ui.MainActivity;

public class ConfirmarEliminarCuenta extends AppCompatActivity {
    private Button btnConfirmar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_eliminar_cuenta);

        btnConfirmar = findViewById(R.id.btnConfirmar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarEliminarCuenta.this, CuentaEliminada.class);
                startActivity(intent);
                Toast.makeText(ConfirmarEliminarCuenta.this, "Cuenta eliminada", Toast.LENGTH_SHORT).show();
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarEliminarCuenta.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}