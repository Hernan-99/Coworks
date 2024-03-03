package com.example.coworks.ui.registroadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coworks.R;
import com.example.coworks.data.database.appdatabase.CoworksDatabase;
import com.example.coworks.data.database.dao.RolDao;
import com.example.coworks.data.database.dao.UsuarioDao;
import com.example.coworks.data.database.model.Rol;
import com.example.coworks.data.database.model.Usuario;
import com.example.coworks.ui.login.LoginActivity;
import com.example.coworks.utils.HashPass;

public class RegistroAdminActivity extends AppCompatActivity {
    private Button btnRegistroAdmin;
    private TextView btnIniciar;
    private EditText nombre, telefono, email, password;

    private UsuarioDao usuarioDao;
    private RolDao rolDao;
    private RegistroAdminViewModel registroAdminViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_admin);

        btnRegistroAdmin = findViewById(R.id.btnRegistro);
        btnIniciar = findViewById(R.id.btnIniciar);

        //------- inputs -------------
        nombre = findViewById(R.id.iptNombreAdmin);
        telefono = findViewById(R.id.iptTelAdmin);
        email = findViewById(R.id.iptEmailAdmin);
        password = findViewById(R.id.iptPassAdmin);

        usuarioDao = CoworksDatabase.getInstance(this).usuarioDao();
        rolDao = CoworksDatabase.getInstance(this).rolDao();
        registroAdminViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(RegistroAdminViewModel.class);

        btnRegistroAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertAdmin();
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

    private void insertAdmin(){
        String nombreUsr = nombre.getText().toString();
        String telefonoUsr = telefono.getText().toString();
        String emailUsr = email.getText().toString();
        String passwordUsr = password.getText().toString();

        if (!nombreUsr.isEmpty() && !telefonoUsr.isEmpty() && !emailUsr.isEmpty() && !passwordUsr.isEmpty()){
            // --------------- si los campos no estan vacios, entonces: --------------
            //establezco rol
            Rol rolAdmin = new Rol("ROL_ADMIN");
            rolDao.postRolAsync(rolAdmin);

            //hasheo contraseña
            String hashedPassword = HashPass.hashPassword(passwordUsr);

            Usuario usuario = new Usuario();
            usuario.setNombre_usuario(nombreUsr);
            usuario.setTelefono_usuario(telefonoUsr);
            usuario.setEmail_usuario(emailUsr);
            usuario.setPassword_usuario(hashedPassword); //contraseña hasheada
            usuario.setRolIdRol(2);

            registroAdminViewModel.postUsuario(usuario);

            Intent intent = new Intent(RegistroAdminActivity.this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Admin registrado, inicie sesion", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}