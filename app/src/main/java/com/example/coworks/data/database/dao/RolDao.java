package com.example.coworks.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.coworks.data.database.model.Rol;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Dao
public interface RolDao {
    @Insert
    void postRol(Rol rol);
    static final ExecutorService executorSv = Executors.newSingleThreadExecutor();
    default void postRolAsync(Rol rol){
        executorSv.execute(()->{postRol(rol);});
    }

}
