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
public class Asignatura {
    int id;
    String nombre;
    int programaId;
    
    public Asignatura(int id, String nom, int progId){
        this.id = id;
        this. nombre = nom;
        this.programaId = progId;
    }
    public int getID(){
        return this.id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getprogramaID(){
        return this.programaId;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public void setNombre(String nom){
        this.nombre = nom;
    }
    
    public void setProgramaID(int progId){
        this.programaId = progId;
    }
    
}
