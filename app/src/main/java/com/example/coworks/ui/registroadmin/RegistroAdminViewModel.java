package com.example.coworks.ui.registroadmin;

import androidx.lifecycle.ViewModel;

import com.example.coworks.data.database.dao.UsuarioDao;
import com.example.coworks.data.database.model.Usuario;

public class RegistroAdminViewModel extends ViewModel {
    private UsuarioDao usuarioDao;

    public RegistroAdminViewModel() {
    }

    public RegistroAdminViewModel(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public void postUsuario(Usuario usuario){
        usuarioDao.postUserAsync(usuario);
    }
}
