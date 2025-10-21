package com.example.talento.backend;

import java.util.ArrayList;

public class CrudProductos extends CrudConsola<Producto> {

    private final ArrayList<Producto> productos;
    private final ArrayList<Categoria> categorias;

    public CrudProductos(ArrayList<Producto> productos, ArrayList<Categoria> categorias) {
        this.productos = productos;
        this.categorias = categorias;
    }

    @Override
    public void crear() {
        System.out.println("=== Crear Nuevo Producto ===");
        System.out.println("1. Crear Artículo");
        System.out.println("2. Crear Servicio");
        Integer opcion = leerEntero("Seleccione una opción: ");

        if (opcion == 1) {
            String nombre = leerTexto("Nombre: ");
            Double precio = leerDouble("Precio: ");

            if (categorias.isEmpty()) {
                System.out.println("No hay categorías disponibles. Por favor, cree una categoría primero.");
                return;
            }

            System.out.println("Categorías disponibles:");
            for (Categoria categoria : categorias) {
                System.out.println(categoria.getId() + ". " + categoria.getNombre());
            }   
            Integer categoriaId = leerEntero("Seleccione el ID de la categoría: ");
            Categoria categoriaSeleccionada = null;
            for (Categoria categoria : categorias) {
                if (categoria.getId().equals(categoriaId)) {
                    categoriaSeleccionada = categoria;
                    break;
                }
            }
            if (categoriaSeleccionada == null) {
                System.out.println("Categoría no encontrada. Operación cancelada.");
                return;
            } else {
                Articulo articulo = new Articulo(nombre, precio, categoriaSeleccionada);
                productos.add(articulo);
                System.out.println("Artículo creado exitosamente: " + articulo);
            }
        } else if (opcion == 2) {
            String nombre = leerTexto("Nombre: ");
            Double precio = leerDouble("Precio: ");
            Integer duracion = leerEntero("Duración (en horas): ");
            productos.add(new Servicio(nombre, precio, duracion));
            System.out.println("Servicio creado exitosamente.");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    @Override
    public void listar() {
        System.out.println("=== Lista de Productos ===");
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Productos Disponibles:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
        // Pausa para que el usuario pueda leer la lista antes de volver al menú
        leerTexto("Presione Enter para continuar...");
    }

    @Override
    public void actualizar() {
        System.out.println("=== Actualizar Producto ===");
        Integer id = leerEntero("Ingrese el ID del producto a actualizar: ");
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                String nuevoNombre = leerTexto("Nuevo nombre (actual: " + producto.getNombre() + "): ");
                Double nuevoPrecio = leerDouble("Nuevo precio (actual: " + producto.getPrecio() + "): ");
                producto.SetNombre(nuevoNombre);
                producto.setPrecio(nuevoPrecio);
                
                if (producto instanceof Articulo) {
                    System.out.println("¿Desea actualizar la categoría? 1. Si / 2. No");
                    Integer catcamb = leerEntero("Opción: ");
                    if (catcamb == 1) {
                        System.out.println("Categorias Disponibles:");
                        for (Categoria categoria : categorias) {
                            System.out.println(categoria.getId() + ". " + categoria.getNombre());
                        }
                        Integer nuevaCategoriaId = leerEntero("Seleccione el ID de la nueva categoría: ");
                        for (Categoria categoria : categorias) {
                            if (categoria.getId().equals(nuevaCategoriaId)) {
                                ((Articulo) producto).setCategoria(categoria);
                                break;
                            }
                        }
                    }
                }

                if (producto instanceof Servicio) {
                   System.out.println("¿Desea actualizar la duración? 1. Si / 2. No");
                   Integer durcamb = leerEntero("Opción: ");
                   if (durcamb == 1) {
                       Integer nuevaDuracion = leerEntero("Nueva duración (horas): ");
                       ((Servicio) producto).setDuracionHoras(nuevaDuracion);
                   }
                }

                System.out.println("Producto actualizado exitosamente: " + producto);
                return;
            }
        }
        System.out.println("Producto con ID " + id + " no encontrado.");
    }

    @Override
    public void eliminar() {
        System.out.println("=== Eliminar Producto ===");
        Integer id = leerEntero("Ingrese el ID del producto a eliminar: ");
        boolean eliminado = productos.removeIf(producto -> producto.getId().equals(id));
        System.out.println(eliminado ? "Producto eliminado exitosamente." : "Producto con ID " + id + " no encontrado.");
    }
}


