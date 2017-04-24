package com.pcvpmo.pdsw.upteho.entities;

import java.io.Serializable;

/**
 * Una clase simple que representa un Profesor en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Profesor implements Serializable {
    private int id;
    private String nombre;
    private String correo;

    public Profesor() {
    }
    
    public Profesor(int id, String nom, String mail){
        this.id = id;
        this.nombre = nom;
        this.correo = mail;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getCorreo(){
        return this.correo;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNombre(String nom){
        this.nombre = nom;
    }
    
    public void setCorreo(String mail){
        this.correo = mail;
    }
}
