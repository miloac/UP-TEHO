/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.entities;

/**
 * Una clase simple que representa un Curso en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Curso {
    private int cohorte;
    private int profesorId;
    private Materia materia;
    private Periodo periodo;
    
    public Curso(int cohorte, int profId, Materia materia, Periodo periodo){
        this.cohorte = cohorte;
        this.profesorId = profId;
        this.materia = materia;
        this.periodo = periodo;
    }
    
    public int getCohorte(){
        return this.cohorte;
    }
    
    public int getProfesorId(){
        return this.profesorId;
    }
    
    public Materia getMateria(){
        return this.materia;
    }
    
    public Periodo getPeriodo(){
        return this.periodo;
    }
    
    public void setCohorte(int co){
        this.cohorte = co;
    }
    
    public void setProfesorId(int profId){
        this.profesorId = profId;
    }
    
    public void setMateria(Materia mat){
        this.materia = mat;
    }
    
    public void setPeriodo(Periodo per){
        this.periodo = per;
    }
}
