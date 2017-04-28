/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.entities;

import java.io.Serializable;

/**
 *
 * @author andres
 */
public class Cohorte implements Serializable{
    private Programa programa;
    private Curso curso;
    private int cohorte;
    
       public Cohorte() {
    }
    
    public Cohorte(Programa programa,Curso curso, int cohorte){
        this.programa = programa;
        this.curso = curso;
        this.cohorte = cohorte;
    }
    
    public Programa getPrograma(){
        return this.programa;
    }
    
    public Curso getCurso(){
        return this.curso;
    }
    
    public int getCohorte(){
        return this.cohorte;
    }

    public void setPrograma(Programa co){
        this.programa = co;
    }
    
    public void setCurso(Curso curso){
        this.curso = curso;
    }
    
    public void setCohorte(int mat){
        this.cohorte = mat;
    }
    
}
