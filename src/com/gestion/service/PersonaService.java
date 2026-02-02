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
        if(buscarPorId(id) != null) return "X ya existe una persona con ese ID";
        if(edad < 0) return "X Edad inválida";
        if(nombre == null || nombre.trim().isEmpty()) return "X Nombre inválido";

        Persona persona = new Persona(id, nombre.trim(), edad);
        personas.add(persona);
        repo.guardar(personas); // Guarda despues de agregar.

        return "Persona agregada correctamente";
    }

    // Listar personas
    public String listarPersonas(){
        if (personas.isEmpty()){
            return "No hay personas cargadas";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("\n - LISTADO DE PERSONAS - \n\n");
        sb.append("ID | Nombre | Edad");
        sb.append("\n-------------------\n");

        for (Persona p : personas){
            sb.append(p.getId()).append(" | ")
            .append(p.getNombre()).append(" | ")
            .append(p.getEdad()).append("\n");
        }
        return sb.toString();
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
    public String mostrarPersonaPorId(int id){
        Persona p = buscarPorId(id);

        if (p == null) return "X No existe una persona con ese ID.";
            //System.out.println("X No existe una persona con ese ID.");


        return "\nPersona encontrada:\n" + p.getId() + " | " + p.getNombre() + " | " + p.getEdad();
        //System.out.println("\n---PERSONA ENCONTRADA---");
    }



    public String editarPersona(int id, String nuevoNombre, int nuevaEdad){
        Persona p = buscarPorId(id);

        if(p == null) return "X No existe una persona con ese ID";
        if(nuevaEdad < 0) return "X Edad inválida.";
        if(nuevoNombre == null || nuevoNombre.trim().isEmpty()) return "X Nombre inválido";



        p.setNombre(nuevoNombre.trim());
        p.setEdad(nuevaEdad);
        repo.guardar(personas); // Guarda despues de editar.

        return "Persona actualizada";
    }



    public String eliminarPersona(int id){
        Persona p = buscarPorId(id);

        if(p == null) return "X No existe una persona con ese ID";

        personas.remove(p);
        repo.guardar(personas); // Guarda despues de eliminar.

        return "Persona eliminada.";
    }



    public String listarOrdenadasPorNombre(){
        if(personas.isEmpty()){
            return "No hay personas cargadas";
        }
            StringBuilder sb = new StringBuilder();
            sb.append("\n - LISTADO ORDENADO POR NOMBRE - \n\n");
            sb.append("ID | Nombre | Edad\n");
            sb.append("--------------------\n");

            personas.stream()
                    .sorted((p1,p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre()))
                    .forEach(p ->
                            sb.append(p.getId()).append(" | ")
                                    .append(p.getNombre()).append(" | ")
                                    .append(p.getEdad()).append("\n")
                    );

            return sb.toString();
    }



    public String listarOrdenadasPorEdad() {
        if (personas.isEmpty()) {
            return "No hay personas cargadas";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\n - LISTADO ORDENADO POR NOMBRE - \n\n");
        sb.append("ID | Nombre | Edad\n");
        sb.append("--------------------\n");

        personas.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()))
                .forEach(p ->
                        sb.append(p.getId()).append(" | ")
                                .append(p.getNombre()).append(" | ")
                                .append(p.getEdad()).append("\n")
                );

        return sb.toString();

    }


}
