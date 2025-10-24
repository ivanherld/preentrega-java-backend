package com.example.talento.backend;

import java.util.ArrayList;

public class CrudUsuarios extends CrudConsola<Usuario> {

    private final ArrayList<Usuario> usuarios;
    private final ArrayList<Producto> productos;

    public CrudUsuarios(ArrayList<Usuario> usuarios, ArrayList<Producto> productos) {
        this.usuarios = usuarios;
        this.productos = productos;
    }


    //* Funciones auxiliares, reutilizables */
    private void mostrarCatalogo() {
        System.out.println("Lista de productos disponibles a comprar:");
        for (Producto producto : productos) {
            System.out.println(producto.getId() + " - " + producto.getNombre());
        }
        System.out.println("0 - Salir o dejar de agregar productos.");
    }

    private Producto buscarProductoPorId(Integer productoId) {
        for (Producto producto : productos) {
            if (producto.getId().equals(productoId)) {
                return producto;
            }
        }
        return null;
    }

    private void seleccionarProductosParaUsuario(ArrayList<Producto> seleccionados) {
        Integer productoId = -1;
        while (productoId != 0) {
            mostrarCatalogo();
            productoId = leerEntero("Seleccione el ID del producto o salida: ");
            if (productoId == 0) break;
            Producto encontrado = buscarProductoPorId(productoId);
            if (encontrado != null) {
                seleccionados.add(encontrado);
                System.out.println("Producto " + encontrado.getNombre() + " agregado a la lista de compras.");
            } else {
                System.out.println("ID de producto no válido.");
            }
        }
    }

    //*          ///               ///                   ///                     // */

    @Override
    public void crear() {
        System.out.println("=== Crear Nuevo Usuario ===");
        String nombre = leerTexto("Ingrese el nombre del nuevo usuario: ");
        String email = leerTexto("Ingrese el email del nuevo usuario: ");
        String password = leerTexto("Ingrese la contraseña del nuevo usuario: ");

        ArrayList<Producto> seleccionados = new ArrayList<>();

        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles por ahora, continúe con el registro.");
        } else {
            seleccionarProductosParaUsuario(seleccionados);
        }

        Usuario nuevoUsuario = new Usuario(nombre, email, password, seleccionados);
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario creado: " + nuevoUsuario);
    }

    
    

    @Override
    public void listar() {
        System.out.println("=== Lista de Usuarios ===");
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios disponibles.");
        } else {
            System.out.println("Usuarios Disponibles:");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
        
        leerTexto("Presione Enter para continuar...");
    }

    @Override
    public void actualizar() {
        System.out.println("=== Actualizar Usuario ===");
        Integer id = leerEntero("Ingrese el ID del usuario a actualizar: ");
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                String nuevoNombre = leerTexto("Nuevo nombre (actual: " + usuario.getNombre() + "): ");
                String nuevoEmail = leerTexto("Nuevo email (actual: " + usuario.getEmail() + "): ");

                System.out.println("¿Desea cambiar la contraseña? 1. Si / 2. No");
                Integer passcamb = leerEntero("Opción: ");
                if (passcamb == 1) {
                    System.out.println("Primero debe autenticarse.");
                    String password = leerTexto("Ingrese su contraseña: ");
                    if (usuario.verificarPassword(password)) {
                        String nuevaPassword = leerTexto("Nueva contraseña: ");
                        usuario.setPassword(nuevaPassword);
                    } else {
                        System.out.println("Contraseña incorrecta. No se puede cambiar la contraseña.");
                    }
                }
                usuario.setNombre(nuevoNombre);
                usuario.setEmail(nuevoEmail);

                
                System.out.println("¿Desea modificar los productos comprados? 1. Si / 2. No");
                Integer prodcamb = leerEntero("Opción: ");
                if (prodcamb == 1) {
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos disponibles en el catálogo.");
                    } else {
                        System.out.println("Actualmente tiene " + usuario.getProductosComprados().size() + " productos.");
                        System.out.println("Se agregarán nuevos productos a la lista existente (use 0 para terminar).");
                        seleccionarProductosParaUsuario(usuario.getProductosComprados());
                    }
                }

                System.out.println("Usuario actualizado exitosamente: " + usuario);
                return;
            }
        }
        System.out.println("Usuario con ID " + id + " no encontrado.");
    }

    @Override
    public void eliminar() {
        System.out.println("=== Eliminar Usuario ===");
        Integer id = leerEntero("Ingrese el ID del usuario a eliminar: ");
        boolean eliminado = usuarios.removeIf(usuario -> usuario.getId().equals(id));
        System.out.println(eliminado ? "Usuario eliminado exitosamente." : "Usuario con ID " + id + " no encontrado.");
    }

}
