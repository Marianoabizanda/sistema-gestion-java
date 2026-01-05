package com.gestion;

import java.util.ArrayList;

public class PersonaService {

    private ArrayList<Persona> personas;
    private PersonaReposity repo;

    public PersonaService(){
      //  personas = new ArrayList<>();
        repo = new PersonaReposity();
        personas = repo.cargar(); // Carga al iniciar.
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

    public Persona buscarPorId(int id){
        for(Persona p : personas){
            if(p.getId() == id){
                return p;
            }

        }
        return null;
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
