package com.pcvpmo.pdsw.upteho.entities;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Una clase simple que representa una Clase en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Clase implements Serializable {
    private Curso curso;
    private int id;
    private Timestamp fechaHora;
    private Time duracion;

    public Clase() {
    }
    
    public Clase(Curso curso, int id, Timestamp fecha, int programaId){
        this.curso = curso;
        this.id = id;
        this.fechaHora = fecha;
        this.duracion = duracion;
    }
    
    public Curso getCurso(){
        return this.curso;
    }
    
    public int getID(){
        return this.id;
    }
    
    public Timestamp getFecha(){
        return this.fechaHora;
    }
    
    public Time getDuracion(){
        return this.duracion;
    }
    
    public void setCurso(Curso curso){
        this.curso = curso;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public void setDuracion(Time progId){
        this.duracion = progId;
    }
    
    public void setFechaHora(Timestamp fecha){
        this.fechaHora = fecha;
    }
}
