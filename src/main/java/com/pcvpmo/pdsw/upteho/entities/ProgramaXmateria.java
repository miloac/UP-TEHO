/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.entities;

import java.io.Serializable;
/**
 *clase que representa la union de una materia y un programa que no se asocian por ninguna asignatura
 * @author Jefferson Castañeda
 */
public class ProgramaXmateria implements Serializable{
    private int idPrograma;
    private String siglaMateria;
    
    public ProgramaXmateria(){
        
    }
    
    public ProgramaXmateria (int idprog, String sigmat){
        idPrograma=idprog;
        siglaMateria=sigmat;
    }
    
    public Integer getIdPrograma(){
        return idPrograma;
    }
    
    public String getSiglaMateria(){
        return siglaMateria;
    }
    
    public void getIdPrograma(Integer id){
        idPrograma = id;
    }
    
    public void getSiglaMateria(String sigla){
        siglaMateria = sigla;
    }
    
        
}
