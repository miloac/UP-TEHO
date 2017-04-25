/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pcvpmo.pdsw.upteho.dao.CursoDAO;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Clase;
import com.pcvpmo.pdsw.upteho.entities.Curso;
import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.entities.Profesor;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import com.pcvpmo.pdsw.upteho.entities.Recurso;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectos;
import com.pcvpmo.pdsw.upteho.services.UnidadProyectosException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de Servicios necesarios para la aplicacion de Unidad de Proyectos
 * @author Daniel Ospina, Felipe Pardo
 */
@Singleton
public class ServiciosUnidadProyectosImpl implements ServiciosUnidadProyectos {
    
    @Inject
    private CursoDAO daoCurso;
    
    @Override
    public void registrarMateria(int idPrograma, int idAsignatura, String siglaRequisito, int tipoRequisito, String nombreMateria, String siglaMateria, String descripcionMateria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelarClase(int cohorte, int idClase){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void programarClase(String fecha, String hora, Curso curso){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarCurso(int idAsignatura, String siglaMateria, int idProfesor){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Materia> consultarMaterias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Materia> consultarMaterias(int idAsignatura){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Programa> consultarProgramas(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Asignatura> consultarAsignaturas(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesor> consultarProfesores(String busqueda){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Clase> consultarClases(String cohorte){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Recurso> consultarRecursosDisponibles(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Recurso> consultarRecursosClase(String cohorte){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> consultarCursos() throws UnidadProyectosException{
        try {
            return daoCurso.consultarCursos();
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar los cursos", ex);
        }
    }

    @Override
    public Curso consultarCurso(int cohorte) throws UnidadProyectosException {
        if(cohorte <0){
            throw new UnidadProyectosException("El cohorte"+cohorte+"no es permitido");
        }
        try{
        return  daoCurso.consultarCurso(cohorte);
        }catch(PersistenceException e){
            throw new UnidadProyectosException("Error al consultar el curso "+cohorte,e);
        }
    }
    
}
