package com.gestion;

import java.util.ArrayList;

public class PersonaService {

    private ArrayList<Persona> personas;

    public PersonaService(){
        personas = new ArrayList<>();
    }

    //Agregar personas
    public void agregarPersona(int id, String nombre, int edad){
        Persona persona = new Persona(id, nombre, edad);
        personas.add(persona);
        System.out.println("Persona agregada correctamente");
    }

    public void listarPersonas(){
        if (personas.isEmpty()){
            System.out.println("No hay personas cargadas");
        }

        System.out.println("\n - LISTADO DE PERSONAS - \n");
        for (Persona p : personas){
            p.mostrarDatos();
            System.out.println("----------------");
        }

    }


}
