package com.pcvpmo.pdsw.upteho.entities;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Una clase simple que representa una Clase en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Clase implements Serializable {
    private int cohorteCurso;
    private int id;
    private Timestamp fechaHora;
    private Time duracion;

    public Clase() {
    }
    
    public Clase(int cohorteCurso, int id, Timestamp fecha, Time duracion){
        this.cohorteCurso = cohorteCurso;
        this.id = id;
        this.fechaHora = fecha;
        this.duracion = duracion;
    }

    public int getCohorteCurso() {
        return cohorteCurso;
    }

    public void setCohorteCurso(int cohorteCurso) {
        this.cohorteCurso = cohorteCurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Time getDuracion(){
        return this.duracion;
    }
    
    public void setDuracion(Time time){
        this.duracion = time;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }
   
}

