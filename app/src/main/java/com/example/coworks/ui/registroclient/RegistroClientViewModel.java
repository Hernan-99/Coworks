package com.example.coworks.ui.registroclient;

import androidx.lifecycle.ViewModel;

import com.example.coworks.data.database.dao.UsuarioDao;
import com.example.coworks.data.database.model.Usuario;

public class RegistroClientViewModel extends ViewModel {
    public UsuarioDao usuarioDao;

    public RegistroClientViewModel() {
    }

    public RegistroClientViewModel(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public void postUsuario(Usuario usuario){
        usuarioDao.postUserAsync(usuario);
    }
}
