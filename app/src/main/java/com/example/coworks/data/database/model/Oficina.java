package com.example.coworks.data.database.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "oficina", foreignKeys = {
        @ForeignKey(entity = Usuario.class,
        parentColumns = "id_usuario",
        childColumns = "usuario_id_usuario",
        onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Rol.class,
        parentColumns = "id_rol",
        childColumns = "usuario_rol_id_rol",
        onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Empresa.class,
        parentColumns = "id_empresa",
        childColumns = "empresa_id_empresa",
        onDelete = ForeignKey.CASCADE)
})
public class Oficina {
    @PrimaryKey(autoGenerate = true)
    public int id_oficina;

    @NonNull
    public int capacidad_oficina;

    @NonNull
    public String ubicacion_oficina;
    public int usuario_id_usuario;
    public int usuario_rol_id_rol;
    public int empresa_id_empresa;

    //constructor vacio
    public Oficina() {
    }

    //constructor parametrizado


    public Oficina(int id_oficina,
                   int capacidad_oficina,
                   @NonNull String ubicacion_oficina,
                   int usuario_id_usuario,
                   int usuario_rol_id_rol,
                   int empresa_id_empresa) {
        this.id_oficina = id_oficina;
        this.capacidad_oficina = capacidad_oficina;
        this.ubicacion_oficina = ubicacion_oficina;
        this.usuario_id_usuario = usuario_id_usuario;
        this.usuario_rol_id_rol = usuario_rol_id_rol;
        this.empresa_id_empresa = empresa_id_empresa;
    }

    // Getters & Setters
    public int getId_oficina() {
        return id_oficina;
    }

    public void setId_oficina(int id_oficina) {
        this.id_oficina = id_oficina;
    }

    public int getCapacidad_oficina() {
        return capacidad_oficina;
    }

    public void setCapacidad_oficina(int capacidad_oficina) {
        this.capacidad_oficina = capacidad_oficina;
    }

    @NonNull
    public String getUbicacion_oficina() {
        return ubicacion_oficina;
    }

    public void setUbicacion_oficina(@NonNull String ubicacion_oficina) {
        this.ubicacion_oficina = ubicacion_oficina;
    }

    public int getUsuario_id_usuario() {
        return usuario_id_usuario;
    }

    public void setUsuario_id_usuario(int usuario_id_usuario) {
        this.usuario_id_usuario = usuario_id_usuario;
    }

    public int getUsuario_rol_id_rol() {
        return usuario_rol_id_rol;
    }

    public void setUsuario_rol_id_rol(int usuario_rol_id_rol) {
        this.usuario_rol_id_rol = usuario_rol_id_rol;
    }

    public int getEmpresa_id_empresa() {
        return empresa_id_empresa;
    }

    public void setEmpresa_id_empresa(int empresa_id_empresa) {
        this.empresa_id_empresa = empresa_id_empresa;
    }
}
