package com.example.coworks.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coworks.data.database.appdatabase.CoworksDatabase;
import com.example.coworks.data.database.model.Usuario;
import com.example.coworks.ui.MainActivity;
import com.example.coworks.ui.registroclient.RegistroClientActivity;
import com.example.coworks.utils.HashPass;
import com.example.coworks.utils.OcultarActionBar;
import com.example.coworks.R;

public class LoginActivity extends AppCompatActivity {
    private EditText emailLogin, passwordLogin;
    private TextView registrarse;
    private Button ingresar;
    private LoginViewModel loginViewModel;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(LoginViewModel.class);
        loginViewModel.usuarioDao = CoworksDatabase.getInstance(this).usuarioDao();

        //funcion para ocultar barras
        OcultarActionBar.ocultar(this);

        // ------------ REFERENCIA ID's --------------
        emailLogin = findViewById(R.id.iptEmailLogin);
        passwordLogin = findViewById(R.id.iptPasswordLogin);
        registrarse = findViewById(R.id.registrarse);
        ingresar = findViewById(R.id.ingresar);

        //------- LISTENERS --------
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creacion de Intent para abrir la activity
                Intent intent = new Intent(LoginActivity.this, RegistroClientActivity.class);
                startActivity(intent);
            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                successLogin();
            }
        });
    }



    //------- AUTENTICACION DE USUARIO
    private void successLogin(){
        String emailUsr = emailLogin.getText().toString();
        String passwordUsr = passwordLogin.getText().toString();

        // hasheo password para que matcheen en la db
        String hashedPassword = HashPass.hashPassword(passwordUsr);
        loginViewModel.getUsuarioCredenciales(emailUsr, hashedPassword).observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                if (usuario != null){
                    // Almacenar el email y la contraseña en el shared preferences
                    credencialesDeUsuario(emailUsr, passwordUsr);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para guardar el email y la contraseña del usuario en el shared preferences
    private void credencialesDeUsuario(String email, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();
    }

}
