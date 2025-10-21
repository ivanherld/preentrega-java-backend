package com.example.talento.backend;

public class Categoria {

    private Integer id;          //* Identidad única
    private String nombre;       //* Nombre de la categoría

    private static Integer idCounter = 1;

    public Categoria(String nombre) {
        this.id = idCounter++;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
