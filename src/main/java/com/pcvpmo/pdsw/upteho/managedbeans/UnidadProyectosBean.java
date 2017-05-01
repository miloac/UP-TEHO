package com.pcvpmo.pdsw.upteho.managedbeans;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Clase;
import com.pcvpmo.pdsw.upteho.entities.Cohorte;
import com.pcvpmo.pdsw.upteho.entities.Curso;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.pcvpmo.pdsw.upteho.entities.Materia; 
import com.pcvpmo.pdsw.upteho.entities.Periodo;
import com.pcvpmo.pdsw.upteho.entities.Profesor;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import com.pcvpmo.pdsw.upteho.entities.Recurso;
import com.pcvpmo.pdsw.upteho.entities.Salon;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectos;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectosFactory;
import com.pcvpmo.pdsw.upteho.services.UnidadProyectosException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Managed Bean encargado de la comunicacion entre capa logica y presentacion
 * @author Daniel Ospina
 */
@ManagedBean(name = "UnidadProyectosBean")
@SessionScoped
public class UnidadProyectosBean implements Serializable {
    
    ServiciosUnidadProyectos sp = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectos();
    
    private Curso cursoActual; 
    private  int cohorteCursoActual;    
    private Programa programa;
    private Asignatura asignatura;    
    private Periodo periodo;    
    private Cohorte cohorte;
    private List<Profesor> profesor;
    private Profesor profesorSelect;
    private Materia materia;
    private String nameProf="a";

    

       //Curso que se haya seleccionado en la pagina, este atributo puede cambiar por id o String dependiendo de como lo implementemos
    
    public UnidadProyectosBean() {
    }
    
    public String irPaginaCurso(Curso curso_actual) {
        cursoActual = curso_actual;
        return "InfoCurso";
    }
    
    public String nombreCursoActual() {
        return cursoActual.getMateria().getNombre();
    }
    
    public int idCursoActual() {
        return cursoActual.getId();
    }
    
    /**
     * Registra una Materia nueva con los datos necesarios respectivos
     * @param idPrograma id del programa de grado al que pertenece la materia
     * @param idAsignatura id de la asignatura
     * @param siglaRequisito sigla de la materia requisito
     * @param tipoRequisito tipo de requisito (0 = prerequisito, 1 = corequisito)
     * @param nombreMateria Nombre completo de la materia
     * @param siglaMateria Sigla de la materia a registrar
     * @param descripcionMateria descripcion de la materia
     */
    public void registrarMateria(int idPrograma, int idAsignatura, String siglaRequisito, int tipoRequisito, String nombreMateria, String siglaMateria, String descripcionMateria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Cancela una clase de un Curso especifico
     * @param cohorte Codigo cohorte del curso
     * @param idClase id de la clase a cancelar
     */
    public void cancelarClase(int cohorte, int idClase) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Programa una Clase //TODO Terminar esta descripcion
     * @param fecha fecha de la clase
     * @param hora hora de la clase
     */
    public void programarClase(String fecha, String hora) {
        //TODO comprobar que tipo es la fecha y hora, salones y recursos
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Registra un nuevo curso
     * @param idAsignatura id de la asignatura
     * @param siglaMateria sigla de la materia a la cual pertenece el grupo
     * @param idProfesor id del profesor que dictara el curso
     */
    public void registrarCurso(int idAsignatura, String siglaMateria, int idProfesor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta las materias registradas en el sistema
     * @return una lista de Materia
     */
    public List<Materia> consultarMaterias() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta las materias de una asignatura
     * @param idAsignatura id de la asignatura
     * @return una lista con las Materias
     */
     public List<Materia> consultarMaterias(int idAsignatura){
         throw new UnsupportedOperationException("Not supported yet.");
     }
    
    /**
     * Consulta la lista de programas de la Unidad de Proyectos
     * @return una lista de Programas
     */
    public List<Programa> consultarProgramas() {
        //TODO comprobar que es String para una lista desplegable
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta las asignaturas (de un programa especifico)
     * @return Lista de Asignaturas
     */
    public List<Asignatura> consultarAsignaturas() {
        //TODO confirmar si se puede de un programa especifico (segun lo seleccionado en la lista desplegable de programa)
        //TODO comprobar que es String para una lista desplegable
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta los periodos academicos
     * @return una lista de Periodos academicos
     */
    public List<Periodo> consultarPeriodo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta los profesores filtrados segun la busqueda
     * @return Lista de profesores segun el filtrado por busqueda
     * @throws com.pcvpmo.pdsw.upteho.services.UnidadProyectosException excepsion en caso de que el nombre del 
     * profesor no se encuentre registrado 
     */
    public List<Profesor> consultarProfesores() throws UnidadProyectosException {
            return sp.consultarProfesores(getNameProf());        
    }
    
    /**
     * Consulta las clases programadas para un curso en especifico
     * @param cohorte numero de cohorte
     * @return Lista de Clases de un curso
     */
    public List<Clase> consultarClases(String cohorte) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<Clase> consultarClasesxPeriodo(String periodo) {
        if (periodo.equals("")) periodo = null;
        List<Clase> lista = null;
        try {
            lista = sp.consultarClasesxPeriodo(periodo);
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /**
     * Consulta los recursos disponibles que pueden ser asignados a una clase
     * @return Lista de recursos disponibles
     */
    public List<Recurso> consultarRecursosDisponibles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta los recursos asignados a una clase en particular
     * @param cohorte cohorte del curso que se quiere consultar
     * @return Lista de recursos asignados a una clase
     */
    public List<Recurso> consultarRecursosClase(String cohorte) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Consulta los cursos actuales en la Unidad de Proyectos
     * @return Lista de Cursos
     */
    public List<Curso> consultarCursos() {
        List<Curso> lista = null;
        try {
            lista = sp.consultarCursos();
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /**
     * Consulta todos los cursos de un periodo especifico
     * @param nombre nombre del periodo
     * @return lista de cursos de un periodo especifico
     */
    public List<Curso> consultarCursosPorPeriodo(String nombre) {
        if (nombre.equals("")) nombre = null;
        List<Curso> lista = null;
        try {
            lista = sp.consultarCursosPorPeriodo(nombre);
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
   
    public List<Salon> consultarSalonCurso() {
        List<Salon> lista = null;
        try {
            lista = sp.consultarSalonCurso(cohorteCursoActual);
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public int consultarCohorte(Curso curso,Programa programa){
        int cohorte=0;
        try{
          cohorte= sp.consultarCohorte(curso,programa); 
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        cohorteCursoActual=cohorte;
        return cohorte;
    }
        
    /**
     * Get the value of programa
     *
     * @return the value of programa
     */
    public Programa getPrograma() {
        return programa;
    }

    /**
     * Set the value of programa
     *
     * @param programa new value of programa
     */
    public void setPrograma(Programa programa) {
        this.programa = programa;
    }    

    /**
     * Get the value of asignatura
     *
     * @return the value of asignatura
     */
    public Asignatura getAsignatura() {
        return asignatura;
    }

    /**
     * Set the value of asignatura
     *
     * @param asignatura new value of asignatura
     */
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    
    /**
     * Get the value of periodo
     *
     * @return the value of periodo
     */
    public Periodo getPeriodo() {
        return periodo;
    }

    /**
     * Set the value of periodo
     *
     * @param periodo new value of periodo
     */
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
     /**
     * Get the value of cohorte
     *
     * @return the value of cohorte
     */
    public Cohorte getCohorte() {
        return cohorte;
    }

    /**
     * Set the value of cohorte
     *
     * @param cohorte new value of cohorte
     */
    public void setCohorte(Cohorte cohorte) {
        this.cohorte = cohorte;
    }

    public List<Profesor> getProfesor() {
        return profesor;
    }
    
    /**
     * Get the value of materia
     *
     * @return the value of materia
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * Set the value of materia
     *
     * @param materia new value of materia
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getNameProf() {
        return nameProf;
    }

    public void setNameProf(String nameProf) {
        this.nameProf = nameProf;
    }

    public Profesor getProfesorSelect() {
        return profesorSelect;
    }

    public void setProfesorSelect(Profesor profesorSelect) {
        this.profesorSelect = profesorSelect;
    }
    
    }

