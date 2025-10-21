package com.example.talento.backend;

public class Servicio extends Producto {

    private Integer duracionHoras;

    public Servicio(String nombre, Double precio, Integer duracionHoras) {
        super(nombre, precio);
        this.duracionHoras = duracionHoras;
    }

    public Integer getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(Integer duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    @Override
    public double calcularDescuento() {
        // Ejemplo: Descuento del 5% para servicios
        return getPrecio() * 0.95;
    }

    @Override
    public String toString() {
        return super.toString() + ", duración=" + duracionHoras + " horas}";
    }

}
