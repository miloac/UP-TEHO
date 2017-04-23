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
public class Requisito {
    String sigMateria;
    String sigRequisito;
    int tipo;
    
    public Requisito(String mat, String req, int tipo){
        this.sigMateria = mat;
        this.sigRequisito = req;
        this.tipo = tipo;
    }
    
    public String getSigMateria(){
        return this.sigMateria;
    }
    
    public String getSigRequisito(){
        return this.sigRequisito;    
    }
    
    public int getTipo(){
        return this.tipo;
    }
    
    public void setSigMateria(String mat){
        this.sigMateria = mat;
    }
    
    public void setSigRequisito(String req){
        this.sigRequisito = req;
    }
    
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
}
