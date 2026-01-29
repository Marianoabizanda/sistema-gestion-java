package com.gestion;

import java.util.Scanner;

public class Main {
    // Método para leer el ingreso del usuario y convertir a número.
    private static int leerEntero(Scanner scanner, String mensaje){
        while(true){
            System.out.print(mensaje);
            String input = scanner.nextLine().trim(); //Lee lo que el usuario escribió como texto y lo guarda en variable.

            try{

                return Integer.parseInt(input); // Convierto el texto input a número entero.

            }catch(NumberFormatException e){ // Esto se ejecuta cuando ParseInt no puede convertir (por letras, vacio, etc).

                System.out.println("Ingresa un número válido");

            }
        }
    }

    // Método para leer el texto ingresado por el usuario y asegurarse que no este vacio.
    public static String leerTexto(Scanner scanner, String mensaje){
        while(true){
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()){
                return input;
            }
            System.out.println("X El texto no puede estar vacío.");
        }
    }

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
            System.out.println("3. Buscar por Id");
            System.out.println("4. Editar persona");
            System.out.println("5. Eliminar persona");
            System.out.println("6. Salir");
            //System.out.println("Opcion: ");

            //int opcion = scanner.nextInt();
            int opcion = leerEntero(scanner, "Opción: ");
            //scanner.nextLine();

            switch (opcion){
                case 1:
                    //System.out.println("ID: ");
                    //int id = scanner.nextInt();
                    int id = leerEntero(scanner, "ID: ");
                    //scanner.nextLine();

                    //System.out.println("Nombre: ");
                    //String nombre = scanner.nextLine();
                    String nombre = leerTexto(scanner, "Nombre: ");

                    //System.out.println("Edad: ");
                    //int edad = scanner.nextInt();
                    int edad = leerEntero(scanner, "Edad: ");

                    servicio.agregarPersona(id, nombre, edad);
                    break;

                case 2:
                    servicio.listarPersonas();
                    break;

                case 3:
                    int idBuscar = leerEntero(scanner, "Id a buscar: ");
                    servicio.mostrarPersonaPorId(idBuscar);
                    break;

                case 4:
                    System.out.println("Id a editar: ");
                    //int idEditar = scanner.nextInt();
                    int idEditar = leerEntero(scanner, "ID a editar: ");
                    scanner.nextLine();

                    System.out.println("Nuevo nombre: ");
                    //String nuevoNombre = scanner.nextLine();
                    String nuevoNombre = leerTexto(scanner, "Nuevo nombre: ");

                    System.out.println("Nueva edad: ");
                    //int nuevaEdad = scanner.nextInt();
                    int nuevaEdad = leerEntero(scanner, "Nueva edad: ");

                    servicio.editarPersona(idEditar,nuevoNombre,nuevaEdad);
                    break;

                case 5:
                    System.out.println("Id a eliminar: ");
                    //int idEliminar = scanner.nextInt();
                    int idEliminar = leerEntero(scanner, "Id a eliminar: ");
                    scanner.nextLine();

                    servicio.eliminarPersona(idEliminar);
                    break;

                case 6:
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
