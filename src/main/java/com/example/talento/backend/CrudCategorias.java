package com.example.talento.backend;

import java.util.ArrayList;

public class CrudCategorias extends CrudConsola<Categoria> {

    private final ArrayList<Categoria> categorias;

    public CrudCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public void crear() {
        String nombre = leerTexto("Ingrese el nombre de la nueva categoría: ");
        Categoria nuevaCategoria = new Categoria(nombre);
        categorias.add(nuevaCategoria);
        System.out.println("Categoría creada: " + nuevaCategoria);
    }

    @Override
    public void listar() {
        System.out.println("=== Lista de Categorías ===");
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías disponibles.");
        } else {
            for (Categoria categoria : categorias) {
                System.out.println(categoria);
            }
        }
        // Pausa para que el usuario pueda leer la lista antes de volver al menú
        leerTexto("Presione Enter para continuar...");
    }

    @Override
    public void actualizar() {
        Integer id = leerEntero("Ingrese el ID de la categoría a actualizar: ");
        for (Categoria categoria : categorias) {
            if (categoria.getId().equals(id)) {
                String nuevoNombre = leerTexto("Ingrese el nuevo nombre para la categoría: ");
                categoria.setNombre(nuevoNombre);
                System.out.println("Categoría actualizada: " + categoria);
                return;
            }
        }
        System.out.println("Categoría con ID " + id + " no encontrada.");
    }

    @Override
    public void eliminar() {
        Integer id = leerEntero("Ingrese el ID de la categoria a eliminar: ");
        boolean eliminada = categorias.removeIf(categoria -> categoria.getId().equals(id));
        System.out.println(eliminada ? "Categoría eliminada." : "Categoría con ID " + id + " no encontrada.");
    }

}
