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
