package com.example.coworks.data.database.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rol")
public class Rol {
    @PrimaryKey(autoGenerate = true)
    public int id_rol;

    @NonNull
    public String nombre_rol;

    //constructor vacio
    public Rol() {
    }

    //constructor parametrizado
    public Rol(@NonNull String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    //Getters & Setters
    @NonNull
    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(@NonNull String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
}
