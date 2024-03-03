package com.example.coworks.ui.perfil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.coworks.data.database.dao.UsuarioDao;
import com.example.coworks.data.database.model.Usuario;

public class PerfilViewModel extends ViewModel {
    public UsuarioDao usuarioDao;
    public PerfilViewModel() {
    }

    public PerfilViewModel(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public LiveData<Usuario> getUsuarioCredenciales(String email, String password){
        return usuarioDao.getUsuarioCredenciales(email, password);
    }

}
