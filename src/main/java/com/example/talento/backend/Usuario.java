package com.example.talento.backend;

import java.util.ArrayList;

public class Usuario {
    private Integer id;
    private String nombre;
    private String email;
    private String password;
    private ArrayList<Producto> productosComprados = new ArrayList<>();

     private static Integer idCounter = 1;

    public Usuario(String nombre, String email, String password, ArrayList<Producto> productosComprados) {
        this.id = idCounter++;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.productosComprados = productosComprados;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean verificarPassword(String intento) {
        return java.util.Objects.equals(this.password, intento);
    }
    
    public ArrayList<Producto> getProductosComprados() {
        return productosComprados;
    }

    public void comprarProducto(Producto producto) {
        productosComprados.add(producto);
    }

    //*Puse que solo recupere la cantidad de productos porque podria ser engorroso para la vista de consola. */
    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", productosComprados=" + productosComprados.size() +
                '}';
    }
}
