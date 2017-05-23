package com.pcvpmo.pdsw.upteho.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pcvpmo.pdsw.upteho.dao.AsignaturaDAO;
import com.pcvpmo.pdsw.upteho.dao.ClaseDAO;
import com.pcvpmo.pdsw.upteho.dao.CohorteDAO;
import com.pcvpmo.pdsw.upteho.dao.CursoDAO;
import com.pcvpmo.pdsw.upteho.dao.HorarioDisponibleDAO;
import com.pcvpmo.pdsw.upteho.dao.MateriaDAO;
import com.pcvpmo.pdsw.upteho.dao.PeriodoDAO;
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
import com.pcvpmo.pdsw.upteho.entities.Requisito;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectos;
import com.pcvpmo.pdsw.upteho.services.UnidadProyectosException;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import org.mybatis.guice.transactional.Transactional;

/**
 * Clase de Servicios necesarios para la aplicacion de Unidad de Proyectos
 * @author Daniel Ospina, Felipe Pardo, Juan Camilo Mantilla
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
    
    @Inject
    private PeriodoDAO daoPeriodo;
    
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
    public List<Materia> consultarMaterias() throws UnidadProyectosException{
       try{
            return daoMateria.consultarMaterias();
        }catch(PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar todos las materias", ex);
        }
    }

    @Override
    public List<Materia> consultarMaterias(int idAsignatura) throws UnidadProyectosException {
        try{
            return daoMateria.consultarMateriasxAsignatura(idAsignatura);
        }catch(PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar todos las materias", ex);
        }
    }
    
    @Override
    public List<Materia> consultarMateriasxPrograma(Integer idPrograma) throws UnidadProyectosException {
        try {
            return daoMateria.consultarMateriasxPrograma(idPrograma);
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar las materias por la asginatura: " + idPrograma, ex);
        }
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
    public Programa consultarPrograma(Integer id)throws UnidadProyectosException{
        try{
            return daoPrograma.consultarPrograma(id);
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar el programa por id"+id, ex);
        }
    }

    @Override
    public List<Asignatura> consultarAsignaturas() throws UnidadProyectosException{
        try {
            return daoAsignatura.consultarAsignaturas();
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar las asignaturas"+ ex);
        }
    }
    
    @Override
    public Asignatura consultarAsignatura(Integer id)throws UnidadProyectosException{
        try{
            return daoAsignatura.consultarAsignaturaPorID(id);
        }catch (PersistenceException ex){
            throw new UnidadProyectosException("no se pudo consultar la asignatura",ex);
        }
    }
    
    @Override
    public List<Asignatura> consultarAsignaturasXProg(int programa) throws UnidadProyectosException{
        try {
            return daoAsignatura.consultarAsignaturasxPrograma(programa);
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar asignatura con el programa: " + programa, ex);
        }
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
            if(valores.length == 2){
                try{
                    Integer.parseInt(valores[0]);
                    Integer.parseInt(valores[1]);
                } catch(NumberFormatException e){
                    throw new UnidadProyectosException("El formato del periodo no es correcto [parseInt fallo]",e);
                }
            }
            else {
                throw new UnidadProyectosException("El formato del periodo no es correcto [split fallo]");
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
            if(valores.length == 2){
                try{
                    Integer.parseInt(valores[0]);
                    Integer.parseInt(valores[1]);
                }
                catch(NumberFormatException e){
                    throw new UnidadProyectosException("El formato del periodo no es correcto [parseInt fallo]",e);
                }
            }
            else {
                throw new UnidadProyectosException("El formato del periodo no es correcto [split fallo]");
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
    public boolean agregarClase(int idCurso, Date fecha, Time hora, String tSalon, int idProfesor) throws UnidadProyectosException {
        try{
            boolean isPosible=esPosible(fecha,hora,idProfesor);
            if(isPosible)daoClase.agregarClase(idCurso, fecha, hora, tSalon);
            return isPosible;
        }catch (PersistenceException | UnidadProyectosException ex) {
            throw new UnidadProyectosException("Error al insertar la clase", ex);
        }
    }
    
    @Override
    public boolean esPosible(Date fecha,Time hora,int idProfesor)throws UnidadProyectosException{
        try{
            List<HorarioDisponible>  horarios;
            horarios=daoHorarioDisponible.consultarHorarioProfesor(idProfesor);
            boolean isPosible=false;
            for(int i=0;i<horarios.size()&& !isPosible;i++){
                HorarioDisponible hor=horarios.get(i);
          
                if(hor.getDia().equals(obtenerDiaSemana(fecha)) && hor.getHora().equals(hora))
                    isPosible=true;
            }
            List<Clase> horariosC;
            horariosC=consultarClasesProfesor(idProfesor);
            for(int i=0;i<horariosC.size() && isPosible;i++){
                if(horariosC.get(i).getFecha().equals(fecha) && horariosC.get(i).getHora().equals(hora))
                    isPosible=false;
            }
            return isPosible;
            }catch (PersistenceException ex) {
                throw  new UnidadProyectosException("Error al  intentar consular Horario o clases del profesor", ex);
        }
    }
    
    @Override
    public String obtenerDiaSemana(Date fecha){
        String[] dias={"DO","LU","MA", "MI","JU","VI","SA"};
        int numeroDia;
        Calendar cal= Calendar.getInstance();
        cal.setTime(fecha);
        numeroDia=cal.get(Calendar.DAY_OF_WEEK);
        return dias[numeroDia -1];
    }    

    @Override
    public void consultarCohorte(int id) throws UnidadProyectosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNextCurso() throws UnidadProyectosException {
        try {
            return daoCurso.getNextCurso();
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar la siguiente id disponible de curso", ex);
        }
    }

    @Override
    public Materia consultarMateria(String siglaMateria) throws UnidadProyectosException {
        try {
            return daoMateria.consultarMateria(siglaMateria);
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar la materia:" + siglaMateria, ex);
        }
    }

    @Override
    public Periodo consultarPeriodo(String idPeriodo) throws UnidadProyectosException {
        try {
            return daoPeriodo.consultarPeriodo(idPeriodo);
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar el periodo: " + idPeriodo, ex);
        }
    }

    @Override
    public List<Periodo> consultarPeriodos() throws UnidadProyectosException {
        try {
            return daoPeriodo.consultarPeriodos();
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar todos los periodos", ex);
        }
    }
    
    @Transactional
    @Override
    public void registrarCurso(Curso cursoActual) throws UnidadProyectosException {
        try {
            daoCurso.registrarCurso(cursoActual.getId(), cursoActual.getProfesor().getId(), cursoActual.getMateria().getSigla(), cursoActual.getPeriodo().getNombre());
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al registrar el curso " + cursoActual.getId(), ex);
        }
    }
    
    @Transactional
    @Override
    public void registrarCohorte(int idPrograma, int idCurso, int cohorte) throws UnidadProyectosException{
        try {
            daoCohorte.registrarCohorte(idPrograma, idCurso, cohorte);
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al registrar un nuevo cohorte: + "+ cohorte + "con id del programa: " + idPrograma + " id del curso: " + idCurso, ex);
        }
    }

    @Override
    public List<Clase> consultarClasesProfesor(int idProf) throws UnidadProyectosException {
        try{
            return daoClase.consultarClasesProfesor(idProf);
        }catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al consultar las clases del profesor "+idProf, ex);
        }
    }

    @Override
    public void cancelarClase(int id) throws UnidadProyectosException {
        try{
            daoClase.cancelarClase(id);
        }catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al cancelar la clase "+id, ex);
        }
    }
    
    @Transactional
    @Override
    public void registrarAsignatura(String nombreAsig, int idProg) throws UnidadProyectosException {
        try{
            List<Asignatura> asig = daoAsignatura.consultarAsignaturas();
            boolean noRepite = true;
            nombreAsig = nombreAsig.trim();
            for(int i=0; i< asig.size() && noRepite; i++){
                if(asig.get(i).getNombre().equals(nombreAsig)) noRepite = false;
            }
            if (noRepite) daoAsignatura.registrarAsignatura(nombreAsig, idProg);
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al insertar la asignatura", ex);
        }
    }
    
    @Transactional
    @Override
    public void registrarAsignatura(int idAsignatura, String nombreAsig, int idProg) throws UnidadProyectosException {
        try{
            List<Asignatura> asig = daoAsignatura.consultarAsignaturas();
            boolean noRepite = true;
            nombreAsig = nombreAsig.trim();
            for(int i=0; i< asig.size() && noRepite; i++){
                if(asig.get(i).getNombre().equals(nombreAsig)) noRepite = false;
            }
            if (noRepite) daoAsignatura.registrarAsignatura(idAsignatura, nombreAsig, idProg);
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al insertar la asignatura", ex);
        }
    }
    
    @Transactional
    @Override
    public void registrarPeriodo(Periodo periodo) throws UnidadProyectosException {
        if(periodo.getNombre() != null) {
            String[] valores = periodo.getNombre().split("-");
            if(valores.length == 2){
                try{
                    Integer.parseInt(valores[0]);
                    Integer.parseInt(valores[1]);
                }
                catch(NumberFormatException e){
                    throw new UnidadProyectosException("El formato del periodo no es correcto [parseInt fallo]",e);
                }
            }
            else {
                throw new UnidadProyectosException("El formato del periodo no es correcto [split fallo]");
            }
        }
        try {
            daoPeriodo.registrarPeriodo(periodo.getNombre(), periodo.getFechaInicial(), periodo.getFechaFin());
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al registrar un nuevo periodo", ex);
        }
    }
    
    @Transactional
    @Override
    public void registrarProfesor(Profesor profesor) throws UnidadProyectosException {
        try {
            daoProfesor.registrarProfesor(profesor.getId(), profesor.getNombre(), profesor.getCorreo());
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al registrar un nuevo profesor", ex);
        }
    }
    
    @Transactional
    @Override
    public void registrarMateria(Materia materia) throws UnidadProyectosException {
        boolean permiso = true;
        try{
            List<Materia> lista = daoMateria.consultarMaterias();
            for (Materia m:lista){
                if (m.getSigla().equals(materia.getSigla()) || m.getNombre().equals(materia.getNombre())){
                    permiso=false;
                }
            }
        }catch (PersistenceException ex){}
        try {
            if (permiso) daoMateria.registrarMateria(materia.getSigla(), materia.getNombre(), materia.getCreditos(), materia.getDescripcion(), materia.getAsignatura().getId());
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al registrar una nueva materia", ex);
        }
    }
        
    @Transactional
    @Override
    public void registrarPrograma(Programa programa) throws UnidadProyectosException {
        try {
            daoPrograma.registrarPrograma(programa.getId(), programa.getNombre());
        } catch (PersistenceException ex) {
            throw new UnidadProyectosException("Error al registrar un Programa con id: " + programa.getId(), ex);
        }
    }

    @Override
    public void insertarHorarioProfesor(int id, String diaDisp, Time horaDisp) throws UnidadProyectosException {
        try{
            daoHorarioDisponible.insertarHorarioProfesor(id, diaDisp, horaDisp);
        }catch (PersistenceException ex){
            throw new UnidadProyectosException("Error al insertar horario al profesor con id: " + id, ex);
        }
    }

    @Override
    public List<HorarioDisponible> consultarHorarioProfesor(int id) throws UnidadProyectosException {
        try{
            return daoHorarioDisponible.consultarHorarioProfesor(id);
        }catch (PersistenceException ex){
            throw new UnidadProyectosException("Error al consultar horario del profesor con id: " + id, ex);
        }
    }
    
    @Override
    public void registrarRequisito(String mat, String matReq, int tipo) throws UnidadProyectosException {
        try{
            daoMateria.registrarRequisito(mat,matReq,tipo);
        }catch(PersistenceException ex){
            throw new UnidadProyectosException("Error al consultar al registrar el requisito " + mat, ex);
        }
    }

    @Override
    public void removerMateria(String sigla) throws UnidadProyectosException {
        try{
            daoMateria.remover(sigla);
        }catch(PersistenceException ex){
            throw new UnidadProyectosException("Error al consultar eliminar la materia " + sigla, ex);
        }
    }

    @Override
    public void registrarProgramasPorMateria(Integer idPrograma, String sigla) throws UnidadProyectosException {
        try{
            daoMateria.registrarProgramaMateria(idPrograma,sigla);
        }catch(PersistenceException ex){
            throw new UnidadProyectosException("no se pudo Registrar el programa con id " + idPrograma + "error: ", ex);
        }
    }
    
    @Override
    public void removerRequisito(String sigla)throws UnidadProyectosException{
        try{
            daoMateria.removerRequisito(sigla);
        }catch(PersistenceException ex){
            throw new UnidadProyectosException("no se pudo eliminar el requisito con id " + sigla + "error: ", ex);
        }
    }
    
    @Override
    public void removerProgramaPorMateria(int id) throws UnidadProyectosException{
        try{
            daoPrograma.removerPrograma(id);
        }catch (PersistenceException ex){
            throw new UnidadProyectosException("no se pudo eliminar la relacion" +ex);
        }
    }

    @Override
    public List<Requisito> consultarRequisitos(String sigla) throws UnidadProyectosException {
        List<Requisito> ans;
        try{
            ans = daoMateria.consultarRequisitos(sigla);
        }catch (PersistenceException ex){
            ans=null;
        }
        return ans;
    }
    
    @Override
    public boolean hayConflicto(Date fecha,Time hora,Curso act)throws UnidadProyectosException{
        try{
            Programa progAct=act.getMateria().getAsignatura().getPrograma();
            boolean resp=true;
            List<Curso> cursos=consultarCursos();
            List<Clase> clases=daoClase.consultarClasesHorario(fecha, hora);
            for (int i=0;i<clases.size() && resp;i++){
                System.out.println(clases.get(i).getId());
                Curso cur=daoCurso.consultarCurso(clases.get(i).getCursoId());
                Programa prog=cur.getMateria().getAsignatura().getPrograma();
                if(prog.equals(progAct))resp=false;
            }
            return resp;
        }catch (PersistenceException ex){
            throw new UnidadProyectosException("no se puedo determinar si existia conflicto al registrar clase" +ex);
        }
    }
}

