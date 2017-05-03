package com.pcvpmo.pdsw.upteho.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pcvpmo.pdsw.upteho.dao.ClaseDAO;
import com.pcvpmo.pdsw.upteho.dao.CohorteDAO;
import com.pcvpmo.pdsw.upteho.dao.CursoDAO;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Clase;
import com.pcvpmo.pdsw.upteho.entities.Cohorte;
import com.pcvpmo.pdsw.upteho.entities.Curso;
import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.entities.Periodo;
import com.pcvpmo.pdsw.upteho.entities.Profesor;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import com.pcvpmo.pdsw.upteho.entities.Recurso;
import com.pcvpmo.pdsw.upteho.entities.Salon;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectos;
import com.pcvpmo.pdsw.upteho.services.UnidadProyectosException;
import java.util.ArrayList;
import java.util.List;

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
    private CohorteDAO daoCohorte;
    
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
    public List<Profesor> consultarProfesores(String busqueda) throws UnidadProyectosException{
        try {
            return daoCurso.consultarProfesores(busqueda);
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("El nombre no se encuentra registrado", ex);
        }
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
    public Curso consultarCurso(int id) throws UnidadProyectosException {
        if(id <0){
            throw new UnidadProyectosException("El id "+id+"no es permitido");
        }
        try{
            return daoCurso.consultarCurso(id);
        }catch(PersistenceException e){
            throw new UnidadProyectosException("Error al consultar el curso "+id,e);
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
       //try{
           //return daoSalon.consultarSalonPeriodo(periodo.getNombre());
       //}catch(PersistenceException e){
        //   throw new  UnidadProyectosException("Error al consultar los salones  del periodo"+periodo.getNombre(),e);
       //}
       List<Salon> lista=new ArrayList<Salon>();
       return lista;
    }

    @Override
    public List<Salon> consultarSalonCurso(int cohorte) throws UnidadProyectosException {
        //try{
         //   return daoSalon.consultarSalonCurso(cohorte);
        //}catch(PersistenceException e){
        //    throw new UnidadProyectosException("Error al consultar el salon  del  curso"+cohorte,e);
        //}
        List<Salon> lista=new ArrayList<Salon>();
       return lista;
    }

    @Override
    public List<Salon> consultarSalones() throws UnidadProyectosException {
        //try{
        //    return daoSalon.consultarSalones();
        //}catch(PersistenceException e){
        //    throw new UnidadProyectosException("Error al consultar todos los salones",e);
        //}
        List<Salon> lista=new ArrayList<Salon>();
       return lista;
    }

    @Override
    public int consultarCohorte(Curso curso, Programa programa) throws UnidadProyectosException {
        Cohorte cohorte;
        try {
            cohorte=daoCohorte.consultarCohorte(curso.getId(),programa.getId());
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar el cohorte", ex);
        }
        if(cohorte==null)return 0;
        else return cohorte.getCohorte();
    }
    
    @Override
    public List<Clase> consultarClasesxPeriodo(String periodo) throws UnidadProyectosException {
        if(periodo != null) {
            String[] valores = periodo.split("-");
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
            return daoClase.consultarClasesxPeriodo(periodo);
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar las clases en el periodo" + periodo, ex);
        }
    }  

    @Override
    public List<Asignatura> consultarAsignaturasxPrograma(Integer idPrograma) throws UnidadProyectosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Materia> consultarMateriasxAsignatura(String sigla) throws UnidadProyectosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
