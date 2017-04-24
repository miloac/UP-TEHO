package com.pcvpmo.pdsw.upteho.entities;
import java.io.Serializable;
import java.sql.Date;

/**
 * Una clase simple que representa un Periodo Academico en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Periodo implements Serializable {
    private String nombre;
    private Date fechaInicial;
    private Date fechaFin;

    public Periodo() {
    }
    
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
    
    public void setFechaInicial(Date fechaInicial){
        this.fechaInicial = fechaInicial;
    }
    
    public void setFechaFin(Date fechaFinal){
        this.fechaFin = fechaFinal;
    }
}
