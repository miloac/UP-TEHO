package com.pcvpmo.pdsw.upteho.entities;

import java.io.Serializable;

/**
 *
 * @author daniel
 */
public class ReservacionSalon implements Serializable {
    
    private Clase clase;
    private int cohorteCurso;
    private Salon salon;

    public ReservacionSalon() {
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public int getCohorteCurso() {
        return cohorteCurso;
    }

    public void setCohorteCurso(int cohorteCurso) {
        this.cohorteCurso = cohorteCurso;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
}
