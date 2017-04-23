package com.pcvpmo.pdsw.upteho.entities;

/**
 * Una clase simple que representa un Recurso en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Recurso {
    int id;
    String nombre;
    
    public Recurso(int id, String nom){
        this.id = id;
        this.nombre = nom;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNombre(String nom){
        this.nombre = nom;
    }
}
