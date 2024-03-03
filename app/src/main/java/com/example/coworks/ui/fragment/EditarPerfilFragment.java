package com.example.coworks.ui.fragment;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.coworks.R;
import com.example.coworks.data.database.model.Usuario;
import com.example.coworks.ui.perfil.PerfilViewModel;

public class EditarPerfilFragment extends DialogFragment {

    private Button btnGuardarCambios, btnCancelar;
    private ImageButton btnCerrarDialog;
    private EditText iptNombre, iptTelefono, iptEmail, iptPassword;
    private Usuario usuarioUpdate;
    private PerfilViewModel perfilViewModel;

    public EditarPerfilFragment() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editar_perfil, container, false);


        iptNombre = view.findViewById(R.id.iptNuevoNombre);
        iptTelefono = view.findViewById(R.id.iptNuevoTelefono);
        iptEmail = view.findViewById(R.id.iptNuevoEmail);
        iptPassword = view.findViewById(R.id.iptNuevaPassword);
        btnGuardarCambios = view.findViewById(R.id.btnGuardarCambios);
        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnCerrarDialog = view.findViewById(R.id.btnCerrarDialog);


        btnCerrarDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nuevoNombre = iptNombre.getText().toString();
                String nuevoTelefono = iptTelefono.getText().toString();
                String nuevoEmail = iptEmail.getText().toString();
                String nuevoPassword = iptPassword.getText().toString();

                // Crear un nuevo objeto Usuario con los nuevos valores
                usuarioUpdate = new Usuario();
                usuarioUpdate.setNombre_usuario(nuevoNombre);
                usuarioUpdate.setTelefono_usuario(nuevoTelefono);
                usuarioUpdate.setEmail_usuario(nuevoEmail);
                usuarioUpdate.setPassword_usuario(nuevoPassword);

                // Obtener una instancia de UsuarioDao y actualizar el usuario en la base de datos
                perfilViewModel.usuarioDao.updateUsuario(usuarioUpdate);

                dismiss();
                Toast.makeText(view.getContext(), "Datos guardados", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        // Obtener los argumentos pasados desde la actividad
        Bundle args = getArguments();
        if (args != null) {
            String nombre = args.getString("nombre", "");
            String telefono = args.getString("telefono", "");
            String email = args.getString("email", "");
            String password = args.getString("password", "");

            iptNombre.setHint(nombre);
            iptTelefono.setHint(telefono);
            iptEmail.setHint(email);
            iptPassword.setHint(password);
        }



        return view;
    }
}