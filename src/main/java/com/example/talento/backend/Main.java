package com.example.talento.backend;

import java.util.ArrayList;

public class Main {

    private static void ejecutarMenuCrud(CrudConsola<?> crud) {
        Integer op;
        do {
            crud.mostrarOpciones();
            op = crud.leerEntero("");
            switch (op) {
                case 1 -> crud.crear();
                case 2 -> crud.listar();
                case 3 -> crud.actualizar();
                case 4 -> crud.eliminar();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
    }

    public static void main(String[] args) {

        final ArrayList<Producto> productos = new ArrayList<>();
        final ArrayList<Categoria> categorias = new ArrayList<>();
        final ArrayList<Usuario> usuarios = new ArrayList<>();

        categorias.add(new Categoria("Electrónica"));
        categorias.add(new Categoria("Ropa"));
        categorias.add(new Categoria("Hogar"));
        categorias.add(new Categoria("Libros"));

        final CrudProductos crudProductos = new CrudProductos(productos, categorias);
        final CrudCategorias crudCategorias = new CrudCategorias(categorias);
        final CrudUsuarios crudUsuarios = new CrudUsuarios(usuarios, productos);

        Integer opcion;
        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Gestionar Productos");
            System.out.println("2. Gestionar Categorías");
            System.out.println("3. Gestionar Usuarios");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            String linea = crudProductos.scanner.nextLine();

            try {
                opcion = Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> ejecutarMenuCrud(crudProductos);
                case 2 -> ejecutarMenuCrud(crudCategorias);
                case 3 -> ejecutarMenuCrud(crudUsuarios);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);
    }

}