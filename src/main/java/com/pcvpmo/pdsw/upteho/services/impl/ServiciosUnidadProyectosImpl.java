package com.pcvpmo.pdsw.upteho.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pcvpmo.pdsw.upteho.dao.AsignaturaDAO;
import com.pcvpmo.pdsw.upteho.dao.ClaseDAO;
import com.pcvpmo.pdsw.upteho.dao.CohorteDAO;
import com.pcvpmo.pdsw.upteho.dao.CursoDAO;
import com.pcvpmo.pdsw.upteho.dao.HorarioDisponibleDAO;
import com.pcvpmo.pdsw.upteho.dao.MateriaDAO;
import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import com.pcvpmo.pdsw.upteho.dao.ProfesorDAO;
import com.pcvpmo.pdsw.upteho.dao.ProgramaDAO;
import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Clase;
import com.pcvpmo.pdsw.upteho.entities.Cohorte;
import com.pcvpmo.pdsw.upteho.entities.Curso;
import com.pcvpmo.pdsw.upteho.entities.HorarioDisponible;
import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.entities.Periodo;
import com.pcvpmo.pdsw.upteho.entities.Profesor;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import com.pcvpmo.pdsw.upteho.entities.Recurso;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectos;
import com.pcvpmo.pdsw.upteho.services.UnidadProyectosException;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
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
    
    @Inject
    private HorarioDisponibleDAO daoHorarioDisponible;
    
    @Inject
    private ProfesorDAO daoProfesor;
    
    @Inject
    private ProgramaDAO daoPrograma;
    
    @Inject
    private AsignaturaDAO daoAsignatura;
    
    @Inject
    private MateriaDAO daoMateria;
    
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
    public List<Programa> consultarProgramas() throws UnidadProyectosException {
        try {
            return daoPrograma.consultarProgramas();
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar todos los programas", ex);
        }
    }

    @Override
    public List<Asignatura> consultarAsignaturas(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesor> consultarProfesores(String busqueda) throws UnidadProyectosException{
        try {
            return daoProfesor.consultarProfesores(busqueda);
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
        try {
            return daoAsignatura.consultarAsignaturasxPrograma(idPrograma);
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar asignatura con el programa: " + idPrograma, ex);
        }
    }
    
    @Override
    public List<Clase> consultarClasesPeriodo(Periodo periodo) throws UnidadProyectosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Materia> consultarMateriasxAsignatura(Integer idAsignatura) throws UnidadProyectosException {
        try {
            return daoMateria.consultarMateriasxAsignatura(idAsignatura);
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar las materias por la asginatura: " + idAsignatura, ex);
        }
    }

    @Override
    public List<Clase> consultarClases() throws UnidadProyectosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Clase> consultarClasesCurso(int id) throws UnidadProyectosException {
       try{
           return daoClase.consultarClasesCurso(id);
       } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar las clases del curso"+id, ex);
       }
    }

    @Override
    public void agregarClase(int idCurso, Date fecha, Time hora, String tSalon, int idProfesor) throws UnidadProyectosException {
        try{
            List<HorarioDisponible>  horarios;
            horarios=daoHorarioDisponible.consultarHorarioProfesor(idProfesor);
            boolean isPosible=false;
            for(int i=0;i<horarios.size()&& !isPosible;i++){
                HorarioDisponible hor=horarios.get(i);
                if(hor.getDia()==obtenerDiaSemana(fecha))
                    if(hor.getHora().equals(hora))
                        isPosible=true;
            } 
            if(isPosible)daoClase.agregarClase(idCurso, fecha, hora, tSalon);
        }catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al insertar la clase", ex);
        }
    }
    
    private String obtenerDiaSemana(Date fecha){
      String[] dias={"DO","LU","MA", "MI","JU","VI","SA"};
      int numeroDia=0;
      Calendar cal= Calendar.getInstance();
      cal.setTime(fecha);
      numeroDia=cal.get(Calendar.DAY_OF_WEEK);
      return dias[numeroDia -1];
    }    

    @Override
    public void consultarCohorte(int id) throws UnidadProyectosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
