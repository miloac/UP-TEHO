package com.pcvpmo.pdsw.upteho.entities;

import java.io.Serializable;

/**
 * Una clase simple que representa un Cohorte en la Unidad de Proyectos y sus detalles
 * @author Andres Felipe Pardo
 */
public class Cohorte implements Serializable {
    
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
