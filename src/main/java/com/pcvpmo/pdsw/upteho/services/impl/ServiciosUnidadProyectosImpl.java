/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pcvpmo.pdsw.upteho.dao.ClaseDAO;
import com.pcvpmo.pdsw.upteho.dao.CursoDAO;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.ReservacionSalonDAO;
import com.pcvpmo.pdsw.upteho.dao.SalonDAO;
import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Clase;
import com.pcvpmo.pdsw.upteho.entities.Curso;
import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.entities.Periodo;
import com.pcvpmo.pdsw.upteho.entities.Profesor;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import com.pcvpmo.pdsw.upteho.entities.Recurso;
import com.pcvpmo.pdsw.upteho.entities.ReservacionSalon;
import com.pcvpmo.pdsw.upteho.entities.Salon;
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
    
    @Inject 
    private ClaseDAO daoClase;
    
    @Inject
    private SalonDAO daoSalon;
    
    @Inject
    private ReservacionSalonDAO daoReservacionSalon;
    
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
            return daoCurso.consultarCurso(cohorte);
        }catch(PersistenceException e){
            throw new UnidadProyectosException("Error al consultar el curso "+cohorte,e);
        }
    }

    @Override
    public List<Curso> consultarCursosPorPeriodo(String nombre) throws UnidadProyectosException {
        if(nombre != null) {
            String[] valores = nombre.split("-");
            if(valores.length != 2){
                try{
                    int valor1 = Integer.parseInt(valores[0]);
                    int valor2 = Integer.parseInt(valores[1]);
                }
                catch(Exception e){
                    throw new UnidadProyectosException("El formato del periodo no es correcto",e);
                }
            }
        }
        try {
            return daoCurso.consultarCursosPorPeriodo(nombre);
        } catch (PersistenceException e) {
            throw new UnidadProyectosException("Error al consultar los cursos por el periodo " + nombre, e);
        }
    }
    
    @Override
    public List<Salon> consultarSalonesPeriodo(Periodo periodo) throws UnidadProyectosException {
       try{
           return daoSalon.consultarSalonPeriodo(periodo.getNombre());
       }catch(PersistenceException e){
           throw new  UnidadProyectosException("Error al consultar los salones  del periodo"+periodo.getNombre(),e);
       }
    }


    @Override
    public List<ReservacionSalon> consultarSalonesReservados() throws UnidadProyectosException {
        try{
            return daoReservacionSalon.consultarSalonesReservados();
        }catch(PersistenceException e){
            throw new UnidadProyectosException("Error al consultar los Salones",e);
        }
    }

    @Override
    public List<Salon> consultarSalonCurso(int cohorte) throws UnidadProyectosException {
        try{
            return daoSalon.consultarSalonCurso(cohorte);
        }catch(PersistenceException e){
            throw new UnidadProyectosException("Error al consultar el salon  del  curso"+cohorte,e);
        }
    }

    @Override
    public List<Salon> consultarSalones() throws UnidadProyectosException {
        try{
            return daoSalon.consultarSalones();
        }catch(PersistenceException e){
            throw new UnidadProyectosException("Error al consultar todos los salones",e);
        }
    }

    @Override
    public List<ReservacionSalon> consultarSalonesCurso(int idCohorte) throws UnidadProyectosException {
        try {
            return daoReservacionSalon.consultarSalonesCurso(idCohorte);
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar los salones del curso con cohorte: " + idCohorte, ex);
        }
    }

    
}
