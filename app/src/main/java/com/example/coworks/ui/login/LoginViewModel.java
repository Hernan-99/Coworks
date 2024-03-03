package com.example.coworks.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.coworks.data.database.dao.UsuarioDao;
import com.example.coworks.data.database.model.Usuario;

public class LoginViewModel  extends ViewModel {
    public UsuarioDao usuarioDao;

    public LoginViewModel() {
    }

    public LoginViewModel(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public LiveData<Usuario> getUsuarioCredenciales(String email, String password){
        return usuarioDao.getUsuarioCredenciales(email, password);
    }
}
