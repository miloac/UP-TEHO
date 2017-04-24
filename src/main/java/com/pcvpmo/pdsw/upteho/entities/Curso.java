package com.pcvpmo.pdsw.upteho.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Una clase simple que representa un Curso en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Curso {
    private int cohorte;
    private Profesor profesor;
    private Materia materia;
    private Periodo periodo;
    
    public Curso(int cohorte, Profesor profesor, Materia materia, Periodo periodo){
        this.cohorte = cohorte;
        this.profesor = profesor;
        this.materia = materia;
        this.periodo = periodo;
    }
    
    public int getCohorte(){
        return this.cohorte;
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
    
    public void setCohorte(int co){
        this.cohorte = co;
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
