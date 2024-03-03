package com.example.coworks.data.database.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "reserva", foreignKeys = {
        @ForeignKey(entity = Oficina.class,
                    parentColumns = "id_oficina",
                    childColumns = "oficina_id_oficina",
                    onDelete = ForeignKey.CASCADE),
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
                    onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Servicio.class,
                    parentColumns = "id_servicio",
                    childColumns = "servicio_id_servicio",
                    onDelete = ForeignKey.CASCADE)

})
public class Reserva {
    @PrimaryKey(autoGenerate = true)
    public int id_reserva;

    @NonNull
    public int precio_reserva;
    public int oficina_id_oficina;
    public int usuario_id_usuario;
    public int usuario_rol_id_rol;
    public int empresa_id_empresa;
    public int servicio_id_servicio;

    // constructor vacio
    public Reserva() {
    }

    // constructor parametrizado
    public Reserva(int id_reserva,
                   int precio_reserva,
                   int oficina_id_oficina,
                   int usuario_id_usuario,
                   int usuario_rol_id_rol,
                   int empresa_id_empresa,
                   int servicio_id_servicio) {
        this.id_reserva = id_reserva;
        this.precio_reserva = precio_reserva;
        this.oficina_id_oficina = oficina_id_oficina;
        this.usuario_id_usuario = usuario_id_usuario;
        this.usuario_rol_id_rol = usuario_rol_id_rol;
        this.empresa_id_empresa = empresa_id_empresa;
        this.servicio_id_servicio = servicio_id_servicio;
    }

    //Getters & Setters

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getPrecio_reserva() {
        return precio_reserva;
    }

    public void setPrecio_reserva(int precio_reserva) {
        this.precio_reserva = precio_reserva;
    }

    public int getOficina_id_oficina() {
        return oficina_id_oficina;
    }

    public void setOficina_id_oficina(int oficina_id_oficina) {
        this.oficina_id_oficina = oficina_id_oficina;
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

    public int getServicio_id_servicio() {
        return servicio_id_servicio;
    }

    public void setServicio_id_servicio(int servicio_id_servicio) {
        this.servicio_id_servicio = servicio_id_servicio;
    }
}
