package com.example.coworks.model;

public class Usuario {
    private int id_usuario;
    private String nombre_usuario;
    private String telefono_usuario;
    private String email_usuario;
    private String password_usuario;
    private int id_rol;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_usuario, String telefono_usuario, String email_usuario, String password_usuario, int id_rol) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.telefono_usuario = telefono_usuario;
        this.email_usuario = email_usuario;
        this.password_usuario = password_usuario;
        this.id_rol = id_rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }
}
