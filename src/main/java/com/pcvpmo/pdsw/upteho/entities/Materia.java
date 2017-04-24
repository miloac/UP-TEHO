package com.pcvpmo.pdsw.upteho.entities;

/**
 * Una clase simple que representa una Materia en la Unidad de Proyectos y sus detalles
 * @author Juan Camilo Mantilla
 */
public class Materia {
    private String sigla;
    private String nombre;
    private int creditos;
    private String descripcion;
    private Asignatura asignatura;

    public Materia(String sigla, String nombre, int creditos, String descripcion, Asignatura asignatura) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.creditos = creditos;
        this.descripcion = descripcion;
        this.asignatura = asignatura;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    
    
}
