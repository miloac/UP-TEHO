package com.pcvpmo.pdsw.upteho.entities;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Una clase simple que representa un Periodo Academico en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Periodo implements Serializable {
    String nombre;
    Timestamp fechaInicial;
    Timestamp fechaFin;

    public Periodo() {
    }
    
    public Periodo(String nom, Timestamp fechaI, Timestamp fechaF){
        this.nombre = nom;
        this.fechaInicial = fechaI;
        this.fechaFin = fechaF;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public Timestamp getFechaInicial(){
        return this.fechaInicial;
    }
    
    public Timestamp getFechaFin(){
        return this.fechaFin;
    }
    
    public void setNombre(String nom){
        this.nombre = nom;
    }
    
    public void setFechaInicial(Timestamp fechaI){
        this.fechaInicial = fechaI;
    }
    
    public void setFechaFin(Timestamp fechaF){
        this.fechaFin = fechaF;
    }
}
