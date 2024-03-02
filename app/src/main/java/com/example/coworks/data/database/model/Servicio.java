package com.example.coworks.data.database.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "servicio")
public class Servicio {
    @PrimaryKey(autoGenerate = true)
    int id_servicio;

    @NonNull
    String tipo_servicio;

    // constructor vacio
    public Servicio() {
    }

    // constructor parametrizado
    public Servicio(int id_servicio, @NonNull String tipo_servicio) {
        this.id_servicio = id_servicio;
        this.tipo_servicio = tipo_servicio;
    }

    //Getters & Setters
    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    @NonNull
    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(@NonNull String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }
}
