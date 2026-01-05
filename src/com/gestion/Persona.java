package com.gestion;

public class Persona {


        private int id;
        private String nombre;
        private int edad;


        public Persona(int id, String nombre, int edad){
            this.id = id;
            this.nombre = nombre;
            this.edad = edad;

        }

        public int getId(){
            return id;
        }

         public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setNombre(String nombre){
            this.nombre = nombre;
        }

        public void setEdad(int edad){
            this.edad = edad;
        }

        public void mostrarDatos(){
            System.out.println("ID: " + id);
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);

        }
}
