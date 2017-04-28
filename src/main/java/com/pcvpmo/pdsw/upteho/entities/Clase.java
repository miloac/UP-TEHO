package com.pcvpmo.pdsw.upteho.entities;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * Una clase simple que representa una Clase en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Clase implements Serializable {
    private int cursoId;
    private int id;
    private Date fecha;
    private Time hora;
    private String tipo_salon;

    public Clase() {
    }
    
    public Clase(int cursoId, int id, Date fecha, Time hora, String tipo_salon){
        this.cursoId = cursoId;
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo_salon = tipo_salon;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo_salon() {
        return tipo_salon;
    }

    public void setTipo_salon(String tipo_salon) {
        this.tipo_salon = tipo_salon;
    }
    
}

