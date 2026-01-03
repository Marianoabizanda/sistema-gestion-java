package com.gestion;

public class Main {
    public static void main(String[] args) {

        Persona p1 = new Persona(1, "Juan", 20);
        Persona p2 = new Persona(2, "Ana", 23);

        p1.mostrarDatos();
        System.out.println("-------------------------");
        p2.mostrarDatos();

    }
}
