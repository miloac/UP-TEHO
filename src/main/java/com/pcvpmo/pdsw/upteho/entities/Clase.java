package com.pcvpmo.pdsw.upteho.entities;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Date;

/**
 * Una clase simple que representa una Clase en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Clase implements Serializable {
    private int cursosId;
    private int id;
    private Date fecha;
    private Time hora;
    private String tipoSalon;

    public Clase() {
    }
    
    public Clase(int Cursos_id, int id, Date fecha, Time hora){
        this.cursosId = Cursos_id;
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getCursosId() {
        return cursosId;
    }

    public void setCursosId(int Cursos_id) {
        this.cursosId = Cursos_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Time getHora(){
        return this.hora;
    }
    
    public void setHora(Time time){
        this.hora = time;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getTipoSalon(){
        return tipoSalon;
    }
    public void setTipoSalon(String tipoSalon){
        this.tipoSalon=tipoSalon;
    }
    
   
}

