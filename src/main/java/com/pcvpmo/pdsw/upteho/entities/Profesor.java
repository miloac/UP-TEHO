/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.entities;

/**
 *
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
