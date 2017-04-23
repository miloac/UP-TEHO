package com.pcvpmo.pdsw.upteho.entities;

/**
 * Una clase simple que representa un Profesor en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Profesor {
    int id;
    String nombre;
    String correo;
    
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
