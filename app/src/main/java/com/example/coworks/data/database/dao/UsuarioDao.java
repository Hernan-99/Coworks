package com.example.coworks.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.coworks.data.database.model.Usuario;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Dao
public interface UsuarioDao {

    @Query("SELECT * FROM usuario WHERE email_usuario= :email AND password_usuario= :password")
    LiveData<Usuario> getUsuarioCredenciales(String email, String password);

    @Insert
    void postUsuario(Usuario usuario);
    static final ExecutorService executorSv = Executors.newSingleThreadExecutor();
    default void postUserAsync(Usuario usuario){
        executorSv.execute(()->{postUsuario(usuario);});
    }

    @Update
    void updateUsuario(Usuario usuario);

    @Delete
    void deleteUsuario(Usuario usuario);
}
