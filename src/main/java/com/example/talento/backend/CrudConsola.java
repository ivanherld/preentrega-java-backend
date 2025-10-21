package com.example.talento.backend;

import java.util.Scanner;

public abstract class CrudConsola<T> {
    
    protected final Scanner scanner = new Scanner(System.in);
    
    public abstract void crear();
    public abstract void listar();
    public abstract void actualizar();
    public abstract void eliminar();

    public void mostrarOpciones() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Crear");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
    }

    protected Integer leerEntero(String mensaje){
        while (true) {
            try {
                System.out.print(mensaje);
                String linea = scanner.nextLine();
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");   
            }
        }
    }

    protected Double leerDouble(String mensaje){
        while (true) {
            try {
                System.out.print(mensaje);
                String linea = scanner.nextLine();
                return Double.parseDouble(linea);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número decimal.");   
            }
        }
    }

    protected String leerTexto(String mensaje){
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}
