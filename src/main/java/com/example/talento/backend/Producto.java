package com.example.talento.backend;

public abstract class Producto implements Vendible {

    private Integer id;      //* Identidad única 
    private String nombre;   //* Nombre del producto
    private Double precio;   //* Precio del producto
    
    private static Integer idCounter = 1;

    public Producto(String nombre, Double precio) {
        this.id = idCounter++;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void SetNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public abstract double calcularDescuento();

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ' ';
    }


}

