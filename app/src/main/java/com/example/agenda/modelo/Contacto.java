package com.example.agenda.modelo;

public class Contacto {

    // 1. declarar nuestros atributos.

    private int id;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;

    // Generar los métodos 'get' y 'set'
    // para eso se seleccionar con right-click, Generate, Gether and Sedder.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //...de aquí crear e ir a la clase 'Conexion'
}
