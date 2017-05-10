package com.pcvpmo.pdsw.upteho.managedbeans;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Clase;
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
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectos;
import com.pcvpmo.pdsw.upteho.services.ServiciosUnidadProyectosFactory;
import com.pcvpmo.pdsw.upteho.services.UnidadProyectosException;
import java.util.HashMap;
import java.util.Map;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import org.apache.ibatis.exceptions.PersistenceException;

/**
 * Managed Bean encargado de la comunicacion entre capa logica y presentacion
 * @author Daniel Ospina
 */
@ManagedBean(name = "UnidadProyectosBean")
@SessionScoped
public class UnidadProyectosBean implements Serializable {
    
    ServiciosUnidadProyectos sp = ServiciosUnidadProyectosFactory.getInstance().getServiciosUnidadProyectos();
    
    private Curso cursoActual; 
    private int cohorteCursoActual;        
    private Profesor profesorSelect;
    private String nameProf;
    private String idProgramaActual;
    private String idAsignaturaActual;
    private String siglaMateriaActual;
    private String idPeriodoActual;   
    private Programa programa;
    private Asignatura asignatura;
    private Periodo periodo;
    private List<Profesor> profesor;
    private Materia materia;
    private double numeroHorasPrf=0;
    private double numeroHorasCur=0;
    private java.util.Date fechaClase;
    private String horaClase;
    private List<String> horas=null;
    private String tipoSalon;
    private String mensaje;
    private boolean registroClase;
    private boolean errorRegistroCurso;
    private String paginaPrevia;
    //Curso que se haya seleccionado en la pagina, este atributo puede cambiar por id o String dependiendo de como lo implementemos
    
    public UnidadProyectosBean() {
    }
    
    public String irPaginaCurso(Curso curso_actual) {
        cursoActual = curso_actual;
        programa=cursoActual.getMateria().getAsignatura().getPrograma();
        asignatura=cursoActual.getMateria().getAsignatura();
        materia=cursoActual.getMateria();
        profesorSelect=cursoActual.getProfesor();
        periodo=cursoActual.getPeriodo();
        cohorteCursoActual = consultarCohorte(cursoActual, programa);
        return "ProgramarClases";
    }
    public String irProgramacionClase() {
        return "ProgramacionClase";
    }
    
    public String irProgramarCurso() {
        if (errorRegistroCurso) return "programarCurso";
        return "ReporteProgramacion";
    }
    
    public String irProgramarClases() {
        String pagina;
        if(registroClase)
            pagina= "ProgramarClases";
        else
            pagina="ProgramacionClase";
        return pagina;
    }
    
    public String irPaginaCohorte() {
        int idCurso;
        Materia materia;
        Periodo periodo;
        try {
            idCurso = sp.getNextCurso();
            materia = sp.consultarMateria(siglaMateriaActual);
            periodo = sp.consultarPeriodo(idPeriodoActual);
            cursoActual = new Curso(idCurso, materia, periodo);
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "RegistroMateriaNuevoCohorte";
    }
    
    public String volverPaginaCurso() {
        cursoActual.setProfesor(profesorSelect);
        return "ProgramarCurso";
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
     * Registra un Curso
     */
    public void registrarCursoActual()  {
        try {
            errorRegistroCurso = false;
            sp.registrarCurso(cursoActual);
            sp.registrarCohorte(Integer.parseInt(idProgramaActual), cursoActual.getId(), cohorteCursoActual);
            mensaje = "Registro exitoso";
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            errorRegistroCurso = true;
            mensaje = "Faltan datos, No se ha podido registrar un nuevo Curso";
        } catch (PersistenceException ex) {
            errorRegistroCurso = true;
            mensaje = "El curso o el cohorte ya existe\nError: \n" + ex.getMessage();
        }
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
        /*java.util.ArrayList<Programa> lista = new java.util.ArrayList<Programa>();
        Programa pro = new Programa(1,"prueba");
        lista.add(pro);
        return lista;*/
        List<Programa> lista = null;
        try {
            lista = sp.consultarProgramas();
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /**
     * Consulta las asignaturas (de un programa especifico)
     * @return Lista de Asignaturas
     */
    public List<Asignatura> consultarAsignaturas(){
        List<Asignatura> lista = null;
        try {
            lista = sp.consultarAsignaturas();
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
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
     */
    public List<Profesor> consultarProfesores() {
        List<Profesor> lista = null;
        try {        
            lista = sp.consultarProfesores(getNameProf());
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /**
     * Consulta todas las clases programadas para un periodo especifico, si periodo es: "" consulta todas las clases de todos los periodos
     * @param periodo periodo a consultar
     * @return lista de Clases
     */
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

    /**
     * Consulta el salon dado el cohorte del curso actual elegido
     * @return lista de Salones
     */
    public List<Clase> consultarClasesCurso() {
        List<Clase> lista = null;
        try {
            lista = sp.consultarClasesCurso(cursoActual.getId());
             numeroHorasCur=lista.size()*1.5;
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

    public String getNameProf() {
        return nameProf;
    }
    
    public void agregarClase(){
        try{
            DateFormat formatter = new SimpleDateFormat("HH:mm");
            Time horaT = new Time(formatter.parse(horaClase).getTime());
            Date sqlFecha=new Date(fechaClase.getTime());
            boolean resp=sp.agregarClase(cursoActual.getId(),sqlFecha, horaT, tipoSalon,profesorSelect.getId());
            registroClase=resp;
            if(resp)mensaje="La clase se registro";
            else mensaje="El profesor no tiene horario disponible";
        } catch (UnidadProyectosException | ParseException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public List<Clase> consultarClasesProfesor(int idProf) {
         List<Clase> clases=null;
         try{
            clases= sp.consultarClasesProfesor(idProf);
             numeroHorasPrf=clases.size()*1.5;
         } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
         }
         return clases;
     }
     public void cancelarClase(int id){
         try{
             sp.cancelarClase(id);
         }catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
         }
     }

    /**
     * Consulta los nombres de lor Programas registrados
     * @return Lista de String con los nombres de los Programas
     */
    public ArrayList<String> consultarProgramasNombres() {
        //TODO Encontrar error que no permite que funcione
        ArrayList<String> nombres = new ArrayList<String>();
        List<Programa> programas = this.consultarProgramas();
        for(int i=0; i<programas.size(); i++){
            nombres.add(programas.get(i).getNombre());
        }
        
        return nombres;
    }
    
    public void registrarAsignatura(String nombre, String nomPrograma) {
        int idprograma =0;
        if(!(nomPrograma.equals("") || nombre.equals(""))){
            try{
                List<Programa> prog = sp.consultarProgramas();
                for(int i=0; i<prog.size(); i++){
                    if (prog.get(i).getNombre().equals(nomPrograma))idprograma = prog.get(i).getId();
                 }
                 sp.registrarAsignatura(nombre, idprograma);
            }
            catch (UnidadProyectosException ex) {
                Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
    /**
     * Get the value of programa
     *
     * @return the value of programa
     */
    public Programa getPrograma() {
        return programa;
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

    public Curso getCursoActual() {
        return cursoActual;
    }

    public void setCursoActual(Curso cursoActual) {
        this.cursoActual = cursoActual;
    }    

    public int getCohorteCursoActual() {
        return cohorteCursoActual;
    }

    public void setCohorteCursoActual(int cohorteCursoActual) {
        this.cohorteCursoActual = cohorteCursoActual;
    }

    public String getIdProgramaActual() {
        return idProgramaActual;
    }

    public void setIdProgramaActual(String idProgramaActual) {
        this.idProgramaActual = idProgramaActual;
    }

    public Map<String, String> getProgramas() {
        List<Programa> lista = null;
        HashMap<String, String> res = new HashMap<>();
        try {
            lista = sp.consultarProgramas();
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Programa programa: lista) {
            res.put(programa.getNombre(), String.valueOf(programa.getId()));
        }
        return res;
    }
    
    public Map<String, String> getPeriodos() {
        List<Periodo> lista = null;
        HashMap<String, String> res = new HashMap<>();
        try {
            if (idPeriodoActual == null || idPeriodoActual.equals("")) lista = sp.consultarPeriodos();
            else lista = sp.consultarPeriodos();
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Periodo periodo: lista) {
            res.put(periodo.getNombre(), String.valueOf(periodo.getNombre()));
        }
        return res;
        
    }
    
    public Map<String, String> getAsignaturas() {
        List<Asignatura> lista = null;
        HashMap<String, String> res = new HashMap<>();
        try {
            if (idProgramaActual == null || idProgramaActual.equals("")) lista = sp.consultarAsignaturasxPrograma(null);
            else lista = sp.consultarAsignaturasxPrograma(Integer.parseInt(idProgramaActual));
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Asignatura asignatura: lista) {
            res.put(asignatura.getNombre(), String.valueOf(asignatura.getId()));
        }
        return res;
    }
    
    public Map<String, String> getMaterias() {
        List<Materia> lista = null;
        HashMap<String, String> res = new HashMap<>();
        try {
            if (idAsignaturaActual == null || idAsignaturaActual.equals("")) lista = sp.consultarMateriasxAsignatura(null);
            else lista = sp.consultarMateriasxAsignatura(Integer.parseInt(idAsignaturaActual));
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Materia materia: lista) {
            res.put(materia.getNombre(), String.valueOf(materia.getSigla()));
        }
        return res;
    }
    
    public String getIdAsignaturaActual() {
        return idAsignaturaActual;
    }
    
    public void changePeriodo() {
        idProgramaActual = null;
        idAsignaturaActual = null;
        siglaMateriaActual = null;
        cohorteCursoActual = 0;
    }
    
    public void changePrograma() {
        idAsignaturaActual = null;
        siglaMateriaActual = null;
        cohorteCursoActual = 0;
    }
    
    public void changeAsignatura() {
        siglaMateriaActual = null;
        cohorteCursoActual = 0;
    }
    
    public void setIdAsignaturaActual(String idAsignaturaActual) {
        this.idAsignaturaActual = idAsignaturaActual;
    }

    public String getSiglaMateriaActual() {
        return siglaMateriaActual;
    }

    public void setSiglaMateriaActual(String siglaMateriaActual) {
        this.siglaMateriaActual = siglaMateriaActual;
    }

    public String getIdPeriodoActual() {
        return idPeriodoActual;
    }
    
    public void setNumeroHorasPrf(double nHoras){
        numeroHorasPrf=nHoras;
    }
    
    public double getNumeroHorasPrf(){
        return numeroHorasPrf;
    }
    public void setNumeroHorasCur(double nHoras){
        numeroHorasCur=nHoras;
    }
    
    public double getNumeroHorasCur(){
        return numeroHorasCur;
    }
    
    public void setFechaClase(java.util.Date nFecha){
        fechaClase=nFecha;
    }
    
    public java.util.Date  getFechaClase(){
        return fechaClase;
    }
    
    public void setHoraClase(String nHora){
        horaClase=nHora;
    }
    
    public String  getHoraClase(){
        return horaClase;
    }
    
    public void setHoras(List<String> nHoras){
        horas=nHoras;
    }
    
    public List<String> getHoras(){
        if(horas==null){
        horas=new ArrayList<String>(Arrays.asList("07:00","08:30","10:00","11:30","13:00","14:30","16:00","17:30"));
        }
       
       return horas;
    }
    
    public void setTipoSalon(String nTSalon){
        tipoSalon=nTSalon;
    }
    
    public String getTipoSalon(){
        return tipoSalon;
    }
    
    public void setMensaje(String nMensaje){
        
        mensaje=nMensaje;
    }
    public String getMensaje(){
        
        return mensaje;
    }
    
    public String irProgramarClaseSinValidar(){
        return "ProgramarClases";
    }

    public void setIdPeriodoActual(String idPeriodoActual) {
        this.idPeriodoActual = idPeriodoActual;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public List<Profesor> getProfesor() {
        return profesor;
    }

    public void setProfesor(List<Profesor> profesor) {
        this.profesor = profesor;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public boolean isRegistroClase() {
        return registroClase;
    }

    public void setRegistroClase(boolean registroClase) {
        this.registroClase = registroClase;
    }

    public boolean isErrorRegistroCurso() {
        return errorRegistroCurso;
    }

    public void setErrorRegistroCurso(boolean errorRegistroCurso) {
        this.errorRegistroCurso = errorRegistroCurso;
    }

    public String getPaginaPrevia() {
        return paginaPrevia;
    }

    public void setPaginaPrevia(String paginaPrevia) {
        this.paginaPrevia = paginaPrevia;
    }
    
    public String getResumen() {
        if (cursoActual == null || siglaMateriaActual == null || idPeriodoActual == null || idAsignaturaActual == null || profesorSelect == null)        {
            return "";
        }
        else {
            return "Resumen: " + cursoActual.getMateria().getNombre() + ", " 
                               + cursoActual.getPeriodo().getNombre() + ", "
                               + cursoActual.getProfesor().getNombre();
        }
    }
    
}