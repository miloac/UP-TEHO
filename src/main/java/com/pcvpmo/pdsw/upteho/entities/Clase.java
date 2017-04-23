/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.entities;
import java.sql.Date;

/**
 *
 * @author Juan Camilo Mantilla
 */
public class Clase {
    int cohorte;
    int id;
    Date fechaHora;
    int programaId;
    
    public Clase(int cohorte, int id, Date fecha, int programaId){
        this.cohorte = cohorte;
        this.id = id;
        this.fechaHora = fecha;
        this.programaId = programaId;
    }
    
    public int getCohorte(){
        return this.cohorte;
    }
    
    public int getID(){
        return this.id;
    }
    
    public Date getFecha(){
        return this.fechaHora;
    }
    
    public int getProgramaId(){
        return this.programaId;
    }
    
    public void setCohorte(int co){
        this.cohorte = co;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public void setProgramaId(int progId){
        this.programaId = progId;
    }
    
    public void setFechaHora(Date fecha){
        this.fechaHora = fecha;
    }
}
