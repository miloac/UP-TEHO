/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.entities;
import java.sql.Date;

/**
 *
 * @author Juan Camilo Mantilla
 */
public class Periodo {
    String nombre;
    Date fechaInicial;
    Date fechaFin;
    
    public Periodo(String nom, Date fechaI, Date fechaF){
        this.nombre = nom;
        this.fechaInicial = fechaI;
        this.fechaFin = fechaF;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public Date getFechaInicial(){
        return this.fechaInicial;
    }
    
    public Date getFechaFin(){
        return this.fechaFin;
    }
    
    public void setNombre(String nom){
        this.nombre = nom;
    }
    
    public void setFechaInicial(Date fechaI){
        this.fechaInicial = fechaI;
    }
    
    public void setFechaFin(Date fechaF){
        this.fechaFin = fechaF;
    }
}
