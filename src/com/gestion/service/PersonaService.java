package com.gestion.service;

import com.gestion.repository.PersonaRepository;
import com.gestion.model.Persona;

import java.util.ArrayList;

public class PersonaService {

    private ArrayList<Persona> personas;
    private PersonaRepository repo;

    public PersonaService(){
      //  personas = new ArrayList<>(); ya no se utiliza porque el array se crea en PersonaRepository.java en el metodo cargar.
        repo = new PersonaRepository(); // Creo el encargado de archivos, desde la clase PersonaRepository creo el objeto repo.
        personas = repo.cargar(); // Carga al iniciar. // Cargo personas desde personas.csv
    }

    //Agregar personas
    public String agregarPersona(int id, String nombre, int edad){
        if(buscarPorId(id) != null) return "X ya existe una persona con ese nombre";
        if(edad < 0) return "X Edad inválida";
        if(nombre == null || nombre.trim().isEmpty()) return "X Nombre inválido";

        Persona persona = new Persona(id, nombre, edad);
        personas.add(persona);
        repo.guardar(personas); // Guarda despues de agregar.

        return "Persona agregada correctamente";
    }

    // Listar personas
    public void listarPersonas(){
        if (personas.isEmpty()){
            System.out.println("No hay personas cargadas");
            return;
        }

        System.out.println("\n - LISTADO DE PERSONAS - \n");
        for (Persona p : personas){
            p.mostrarDatos();
            System.out.println("ID | Nombre | Edad");
            System.out.println("-------------------");
        }

    }

    //Este metodo lo uso internamente en los métodos agregarPersona(), editarPersona() y eliminarPersona().
    public Persona buscarPorId(int id){
        for(Persona p : personas){
            if(p.getId() == id){
                return p;
            }

        }
        return null;
    }

    // Este método lo uso en el menú de opciones para buscar por id.
    public void mostrarPersonaPorId(int id){
        Persona p = buscarPorId(id);

        if (p == null){
            System.out.println("X No existe una persona con ese ID.");
            return;
        }
        System.out.println("\n---PERSONA ENCONTRADA---");
        p.mostrarDatos();
    }

    public void editarPersona(int id, String nuevoNombre, int nuevaEdad){
        Persona p = buscarPorId(id);

        if(p == null){
            System.out.println("X No existe una persona con ese ID");
            return;
        }
        if(nuevaEdad < 0){
            System.out.println("X Edad inválida.");
            return;
        }

        p.setNombre(nuevoNombre);
        p.setEdad(nuevaEdad);
        repo.guardar(personas); // Guarda despues de editar.
        System.out.println("Persona actualizada");

    }

    public void eliminarPersona(int id){
        Persona p = buscarPorId(id);

        if(p == null){
            System.out.println("X No existe una persona con ese ID");
            return;
        }

        personas.remove(p);
        repo.guardar(personas); // Guarda despues de eliminar.
        System.out.println("Persona eliminada.");

    }

}
