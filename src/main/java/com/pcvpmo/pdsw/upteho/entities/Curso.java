package com.pcvpmo.pdsw.upteho.entities;

import java.io.Serializable;
/**
 * Una clase simple que representa un Curso en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Curso implements Serializable {
    private int id;
    private Profesor profesor;
    private Materia materia;
    private Periodo periodo;

    public Curso() {
    }
    
    public Curso(int id, Profesor profesor, Materia materia, Periodo periodo){
        this.id = id;
        this.profesor = profesor;
        this.materia = materia;
        this.periodo = periodo;
    }
    
    public int getId(){
        return this.id;
    }
    
    public Profesor getProfesor(){
        return this.profesor;
    }
    
    public Materia getMateria(){
        return this.materia;
    }
    
    public Periodo getPeriodo(){
        return this.periodo;
    }
    
    public void setId(int co){
        this.id = co;
    }
    
    public void setProfesor(Profesor profesor){
        this.profesor = profesor;
    }
    
    public void setMateria(Materia mat){
        this.materia = mat;
    }
    
    public void setPeriodo(Periodo per){
        this.periodo = per;
    }
}
