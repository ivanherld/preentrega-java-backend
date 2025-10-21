package com.example.talento.backend;

public class Articulo extends Producto {

    private Categoria categoria;  //* Categoria del articulo

    public Articulo(String nombre, Double precio, Categoria categoria) {
        super(nombre, precio);
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public double calcularDescuento() {
        // Ejemplo: Descuento del 10% para artículos
        return getPrecio() * 0.90;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", categoria=" + ( categoria != null ? categoria.getNombre() + " }" : "Sin categoría }");
    }

}
