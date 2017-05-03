/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.entities;

import java.io.Serializable;
import java.sql.Time;

/**
 *
 * @author andres
 */
public class HorarioDisponible implements Serializable{
    private Profesor profesor;
    private String dia; 
    private Time hora;
    
    public HorarioDisponible(){
        
    }
    public HorarioDisponible(Profesor profesor,String dia,Time hora){
        this.profesor=profesor;
        this.dia=dia;
        this.hora=hora;
    }
    
    public Profesor getProfesor(){
        return profesor;
    }
    
    public String getDia(){
        return dia;
    }
    
    public Time getHora(){
        return hora;
    }
    
    public void setProfesor(Profesor profesor){
        this.profesor=profesor;
    }
    
    public void setDia(String  dia){
        this.dia=dia;
    }
    
    public void getHora(Time hora){
        this.hora=hora;
    }
    
}
