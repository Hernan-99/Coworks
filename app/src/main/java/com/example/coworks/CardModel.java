package com.example.coworks;

public class CardModel {
    /*String titulo;
    /String descripcion;
    String precio;*/
    int id;
    int img;

    public CardModel() {
    }

    public CardModel(int id, int img) {
        this.id = id;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
    /*   public CardModel() {
    }

    public CardModel(String titulo, String descripcion, String precio, int img) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
*/
}

