package com.example.coworks.ui.registroclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coworks.data.database.appdatabase.CoworksDatabase;
import com.example.coworks.data.database.dao.RolDao;
import com.example.coworks.data.database.dao.UsuarioDao;
import com.example.coworks.data.database.model.Rol;
import com.example.coworks.data.database.model.Usuario;
import com.example.coworks.ui.registroadmin.RegistroAdminActivity;
import com.example.coworks.ui.login.LoginActivity;
import com.example.coworks.utils.HashPass;
import com.example.coworks.utils.OcultarActionBar;
import com.example.coworks.R;

public class RegistroClientActivity extends AppCompatActivity {

    private EditText nombre, telefono, email, password;
    private TextView login, adminRegistro;
    private Button btnRegistrarse;

    private UsuarioDao usuarioDao;
    private RolDao rolDao;
    private RegistroClientViewModel registroClientViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_client);

        //funcion para ocultar barras
        OcultarActionBar.ocultar(this);

        nombre = findViewById(R.id.iptNombre);
        telefono = findViewById(R.id.iptTel);
        email = findViewById(R.id.iptEmail);
        password = findViewById(R.id.iptPassword);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        adminRegistro = findViewById(R.id.registroAdmin);
        login = findViewById(R.id.iniciarSesion);

        usuarioDao = CoworksDatabase.getInstance(this).usuarioDao();
        rolDao =CoworksDatabase.getInstance(this).rolDao();
        registroClientViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(RegistroClientViewModel.class);
        registroClientViewModel.usuarioDao = CoworksDatabase.getInstance(this).usuarioDao();
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertClient();
            }
        });

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

    private void insertClient(){
        String nombreUsr = nombre.getText().toString();
        String telefonoUsr = telefono.getText().toString();
        String emailUsr = email.getText().toString();
        String passwordUsr = password.getText().toString();

        if (!nombreUsr.isEmpty() && !telefonoUsr.isEmpty() && !emailUsr.isEmpty() && !passwordUsr.isEmpty()){
            // --------------- si los campos no estan vacios, entonces: --------------
            //establezco rol
            Rol rolClient = new Rol("ROL_CLIENT");
            rolDao.postRolAsync(rolClient);

            //hasheo contraseña
            String hashedPassword = HashPass.hashPassword(passwordUsr); //contraseña hasheada

            Usuario usuario = new Usuario();
            usuario.setNombre_usuario(nombreUsr);
            usuario.setTelefono_usuario(telefonoUsr);
            usuario.setEmail_usuario(emailUsr);
            usuario.setPassword_usuario(hashedPassword);
            usuario.setRolIdRol(1);

            registroClientViewModel.postUsuario(usuario);

            Intent intent = new Intent(RegistroClientActivity.this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Usuario registrado, inicie sesion", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}