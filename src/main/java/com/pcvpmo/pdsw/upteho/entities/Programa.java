package com.pcvpmo.pdsw.upteho.entities;

import java.io.Serializable;

/**
 * Una clase simple que representa un Programa en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Programa implements Serializable {
    int id;
    String nombre;

    public Programa() {
    }
    
    public Programa(int id, String nom){
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
