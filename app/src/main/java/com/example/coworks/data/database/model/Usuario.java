package com.example.coworks.data.database.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuario", foreignKeys = @ForeignKey(entity = Rol.class,
    parentColumns = "id_rol",
    childColumns = "rol_id_rol",
    onDelete = ForeignKey.CASCADE))
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    int id_usuario;

    @NonNull
    String nombre_usario;

    @NonNull
    String telefono_usuario;

    @NonNull
    String email_usuario;

    @NonNull
    String password_usuario;

    @ColumnInfo(name = "rol_id_rol")
    @NonNull
    int rolIdRol;

    //constructor vacio
    public Usuario() {
    }

    //constructor parametrizado


    public Usuario(int id_usuario,
                   @NonNull String nombre_usario,
                   @NonNull String telefono_usuario,
                   @NonNull String email_usuario,
                   @NonNull String password_usuario,
                   int rolIdRol) {
        this.id_usuario = id_usuario;
        this.nombre_usario = nombre_usario;
        this.telefono_usuario = telefono_usuario;
        this.email_usuario = email_usuario;
        this.password_usuario = password_usuario;
        this.rolIdRol = rolIdRol;
    }

    //Getters & Setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @NonNull
    public String getNombre_usario() {
        return nombre_usario;
    }

    public void setNombre_usario(@NonNull String nombre_usario) {
        this.nombre_usario = nombre_usario;
    }

    @NonNull
    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(@NonNull String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    @NonNull
    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(@NonNull String email_usuario) {
        this.email_usuario = email_usuario;
    }

    @NonNull
    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(@NonNull String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public int getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(int rolIdRol) {
        this.rolIdRol = rolIdRol;
    }
}
