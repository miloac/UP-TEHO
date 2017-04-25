/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.services.impl;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Curso;
import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.entities.Periodo;
import com.pcvpmo.pdsw.upteho.entities.Profesor;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectos;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectosFactory;
import com.pcvpmo.pdsw.upteho.services.UnidadProyectosException;

/**
 *
 * @author Gabriel
 */
public class main {
    public static void main(String[] args) throws UnidadProyectosException {
        ServiciosUnidadProyectos s=ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        Profesor p=new Profesor(12, "pablo", "pablo@escuela.com");
        Programa pro=new Programa(95, "maestria en gerencia");
        Asignatura a=new Asignatura(56, "procesos", pro);
        Materia m=new Materia("qwer", "proceso de desarrollo", 3, "introduccion a los procesos de desarrollo", a);
        Periodo per=new Periodo("2017-1", java.sql.Date.valueOf("2017-01-15"), java.sql.Date.valueOf("2017-06-05"));
        Curso c=new Curso(123, p, m,per);
        System.out.println(s.consultarCurso(123));
    }
}
