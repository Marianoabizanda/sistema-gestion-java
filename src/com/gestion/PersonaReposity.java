package com.gestion;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.File;

public class PersonaReposity {

    private static final String ARCHIVO = "personas.csv"; //Aca creo el archivo en la carpeta, si no existe se crea al guardarlo.

    public ArrayList<Persona> cargar(){
        ArrayList<Persona> personas = new ArrayList<>();
        File file = new File(ARCHIVO);

        // Si no existe el archivo devuelvo lista vacia.
        if(!file.exists()) return personas;

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String linea;
            while((linea = br.readLine()) != null) {
                // Formato: id, nombre, edad
                String[] partes = linea.split(",", -1);
                if (partes.length != 3) continue;

                int id = Integer.parseInt(partes[0].trim());
                String nombre = partes[1].trim();
                int edad = Integer.parseInt(partes[2].trim());

                personas.add(new Persona(id, nombre, edad));
            }
        } catch (Exception e) {
            System.out.println("X Error al cargar el archivo: " + e.getMessage());

        }
        return personas;

        }
    public void guardar(ArrayList<Persona> personas){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))){
            for(Persona p : personas){
                bw.write(p.getId() + "," + p.getNombre() + "," + p.getEdad());
                bw.newLine();
            }
            }catch (IOException e) {
            System.out.println("X Error al guardar el archivo: " + e.getMessage());
        }
    }
}
