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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gabriel
 */
public class main {

    private final Map<Integer,Profesor> profesores;
    private final Map<Integer, Programa> programas;
    private final Map<Integer, Asignatura> asignaturas;
    private final Map<String, Materia> materias;
    private final Map<String, Periodo> periodos;
    private final Map<Integer, Curso> cursos;
    
    public main() {
        profesores=new HashMap<>();
        programas=new HashMap<>();
        asignaturas=new HashMap<>();
        materias=new HashMap<>();
        periodos=new HashMap<>();
        cursos=new HashMap<>();
        poblar();
    }
    
    public void poblar(){
        Profesor p=new Profesor(12, "pablo", "pablo@escuela.com");        
        profesores.put(p.getId(), p);
        Programa pro=new Programa(95, "maestria en gerencia");
        programas.put(pro.getId(), pro);
        Asignatura a=new Asignatura(56, "procesos", pro);
        asignaturas.put(a.getId(), a);
        Materia m=new Materia("qwer", "proceso de desarrollo", 3, "introduccion a los procesos de desarrollo", a);
        materias.put(m.getSigla(), m);
        Periodo per=new Periodo("2017-1", java.sql.Date.valueOf("2017-01-15"), java.sql.Date.valueOf("2017-06-05"));
        periodos.put(per.getNombre(), per);
        Curso c=new Curso(123, p, m,per);
        cursos.put(c.getCohorte(), c);
    }
    
    public static void main(String[] args) throws UnidadProyectosException {
        main m=new main();
        ServiciosUnidadProyectos s=ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectosTesting();
        try {
            System.out.println(s.consultarCurso(123));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
