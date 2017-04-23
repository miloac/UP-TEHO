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
public class Curso {
    int cohorte;
    int profesorId;
    String materia;
    String periodo;
    
    public Curso(int cohorte, int profId, String materia, String periodo){
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
    
    public String getMateria(){
        return this.materia;
    }
    
    public String getPeriodo(){
        return this.periodo;
    }
    
    public void setCohorte(int co){
        this.cohorte = co;
    }
    
    public void setProfesorId(int profId){
        this.profesorId = profId;
    }
    
    public void setMateria(String mat){
        this.materia = mat;
    }
    
    public void setPeriodo(String per){
        this.periodo = per;
    }
}
