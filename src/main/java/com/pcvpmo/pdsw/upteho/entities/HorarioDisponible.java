package com.pcvpmo.pdsw.upteho.entities;

import java.io.Serializable;
import java.sql.Time;

/**
 * Una clase simple que representa un Horario Disponible en la Unidad de Proyectos y sus detalles
 * @author Andres Felipe Pardo
 */
public class HorarioDisponible implements Serializable{
    
    private Profesor profesor;
    private String dia; 
    private Time hora;
    
    public HorarioDisponible(){   
    }
    
    public HorarioDisponible(Profesor profesor,String dia,Time hora) {
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
