package com.gestion;

import java.util.ArrayList;

public class PersonaService {

    private ArrayList<Persona> personas;
    private PersonaRepository repo;

    public PersonaService(){
      //  personas = new ArrayList<>();
        repo = new PersonaRepository(); // Creo el encargado de archivos, desde la clase PersonaRepository creo el objeto repo.
        personas = repo.cargar(); // Carga al iniciar. // Cargo personas desde personas.csv
    }

    //Agregar personas
    public void agregarPersona(int id, String nombre, int edad){
        if (buscarPorId(id)!= null){
            System.out.println("X Ya existe una persona con ese ID.");
            return;
        }if(edad < 0){
            System.out.println("X Edad inválida.");
            return;
        }

        Persona persona = new Persona(id, nombre, edad);
        personas.add(persona);
        repo.guardar(personas); // Guarda despues de agregar.
        System.out.println("Persona agregada correctamente");
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
            System.out.println("----------------");
        }

    }

    //Este metodo lo uso internamente en los métodos editarPersona() y eliminarPersona().
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
