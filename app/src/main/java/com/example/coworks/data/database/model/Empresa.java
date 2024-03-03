package com.example.coworks.data.database.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "empresa")
public class Empresa {
    @PrimaryKey(autoGenerate = true)
    public int id_empresa;

    @NonNull
    public String nombre_empresa;

    //constructor vacio
    public Empresa() {
    }

    //constructor parametrizado
    public Empresa(int id_empresa, @NonNull String nombre_empresa) {
        this.id_empresa = id_empresa;
        this.nombre_empresa = nombre_empresa;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    @NonNull
    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(@NonNull String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }
}
