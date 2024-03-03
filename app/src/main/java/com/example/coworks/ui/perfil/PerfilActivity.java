package com.example.coworks.ui.perfil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coworks.ConfirmarEliminarCuenta;
import com.example.coworks.data.database.appdatabase.CoworksDatabase;
import com.example.coworks.data.database.dao.UsuarioDao;
import com.example.coworks.data.database.model.Usuario;
import com.example.coworks.ui.MainActivity;
import com.example.coworks.ui.fragment.EditarPerfilFragment;
import com.example.coworks.ui.inicio.InicioActivity;
import com.example.coworks.utils.HashPass;
import com.example.coworks.utils.OcultarActionBar;
import com.example.coworks.R;
import com.example.coworks.utils.RedireccionamientoNavbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PerfilActivity extends AppCompatActivity {

    // variables
    private TextView iptNombre, iptTelefono, iptEmail, iptPassword;
    private TextView bntEliminarCuenta, btnCerrarSesion;
    private Button btnEditar;
    private PerfilViewModel perfilViewModel;
    private BottomNavigationView nav;

    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        perfilViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(PerfilViewModel.class);
        perfilViewModel.usuarioDao = CoworksDatabase.getInstance(this).usuarioDao();

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);


        //funcion para ocultar barras
        OcultarActionBar.ocultar(this);

        //perfilViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(PerfilViewModel.class);
        //perfilViewModel.usuarioDao = CoworksDatabase.getInstance(this).usuarioDao();

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
        //btnEditar = findViewById(R.id.btnEditarPerfil);
        bntEliminarCuenta = findViewById(R.id.btnEliminarCuenta);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);
        //-------------------------------



        String email = obtenerEmailUsuarioSesion();
        String password = obtenerContraseñaUsuarioSesion();
        perfilViewModel.getUsuarioCredenciales(email, HashPass.hashPassword(password)).observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                if (usuario != null) {
                    // Actualizar la interfaz de usuario con los nuevos datos del usuario
                    iptNombre.setText(usuario.getNombre_usuario());
                    iptTelefono.setText(usuario.getTelefono_usuario());
                    iptEmail.setText(usuario.getEmail_usuario());
                    iptPassword.setText("********");
                } else {
                    // si no se encuentra usuario
                    Toast.makeText(PerfilActivity.this, "Error al cargar los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // -------- LISTENERS BTNS ---------
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editarPerfilDialog();
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
        mostrarDatosUsuario();
    }

    private void editarPerfilDialog(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        EditarPerfilFragment editarPerfilFragment = new EditarPerfilFragment();
        //editarPerfilFragment.show(fragmentManager,"editar_perfil_dialog");

        //carga de datos en el fragment
        String nombre = iptNombre.getText().toString();
        String telefono = iptTelefono.getText().toString();
        String email = iptEmail.getText().toString();
        String password= iptPassword.getText().toString();

        // Crear un Bundle para pasar los datos como argumentos al fragmento
        Bundle bundle = new Bundle();
        bundle.putString("nombre", nombre);
        bundle.putString("telefono", telefono);
        bundle.putString("email", email);
        bundle.putString("password", password);

        // Establecer los argumentos en el fragmento
        editarPerfilFragment.setArguments(bundle);
        editarPerfilFragment.show(fragmentManager, "editar_perfil_dialog");
    }

    private void mostrarDatosUsuario() {
        // Obtener email y contraseña del usuario del shared preferences
        String email = obtenerEmailUsuarioSesion();
        String password = obtenerContraseñaUsuarioSesion();

        // Obtencion de usuario de la base de datos
        perfilViewModel.getUsuarioCredenciales(email, HashPass.hashPassword(password));
    }

    private String obtenerEmailUsuarioSesion() {
        // Obtener el email de usuario almacenado en SharedPreferences
        return sharedPreferences.getString("email", ""); // Si no se encuentra, devuelve una cadena vacía
    }

    private String obtenerContraseñaUsuarioSesion() {
        // Obtener la contraseña almacenada en SharedPreferences
        return sharedPreferences.getString("password", ""); // Si no se encuentra, devuelve una cadena vacía
    }


}