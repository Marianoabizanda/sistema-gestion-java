package com.gestion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*Persona p1 = new Persona(1, "Juan", 20);
        Persona p2 = new Persona(2, "Ana", 23);

        p1.mostrarDatos();
        System.out.println("-------------------------");
        p2.mostrarDatos();*/

        Scanner scanner = new Scanner(System.in);
        PersonaService servicio = new PersonaService();

        boolean salir = false;

        while(!salir){
            System.out.println("\n *** SISTEMA DE GESTIÓN *** \n");
            System.out.println("1. Agregar persona");
            System.out.println("2. Listar personas");
            System.out.println("3. Editar persona");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Salir");
            System.out.println("Opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Edad: ");
                    int edad = scanner.nextInt();

                    servicio.agregarPersona(id, nombre, edad);
                    break;

                case 2:
                    servicio.listarPersonas();
                    break;

                case 3:
                    System.out.println("Id a editar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();

                    System.out.println("Nueva edad: ");
                    int nuevaEdad = scanner.nextInt();

                    servicio.editarPersona(idEditar,nuevoNombre,nuevaEdad);
                    break;

                case 4:
                    System.out.println("Id a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();

                    servicio.eliminarPersona(idEliminar);
                    break;

                case 5:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");


            }


        }

        scanner.close();

    }
}
