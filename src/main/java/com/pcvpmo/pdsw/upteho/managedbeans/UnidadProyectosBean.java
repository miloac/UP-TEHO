package com.pcvpmo.pdsw.upteho.managedbeans;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Clase;
import com.pcvpmo.pdsw.upteho.entities.Cohorte;
import com.pcvpmo.pdsw.upteho.entities.Curso;
import java.io.Serializable;
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
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;
import org.primefaces.component.datatable.DataTable;


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
    private Programa programa;
    private Asignatura asignatura;
    private Periodo periodo;    
    private Cohorte cohorte;
    private List<Profesor> profesor;      
    private Profesor profesorSelect;
    private String nameProf;
    private String idProgramaActual;
    private String idAsignaturaActual;
    private String siglaMateriaActual;
    private String idRequisito;
    private List<Programa> selectedPrograms;
    private List<Programa> selectedProgramsToCompare;
    private Integer asignaturaActualID;
    private String currentLink;
    private MultiMap asSelectedXprog;
    private DataTable dataTable;
    private String mesageForUser;
    public boolean alertOfInvalidProgram;
    
    public UnidadProyectosBean() {
        asSelectedXprog = new MultiHashMap();
        selectedPrograms=new ArrayList<>();
        selectedProgramsToCompare=new ArrayList<>();
    }
    
    public String irPaginaCurso(Curso curso_actual) {
        cursoActual = curso_actual;
        return "InfoCurso";
    }
    
    public String irPaginaAsginatura(){
        return "RegistrarAsignatura";
    }
        
    public String irPaginaConsultarSeleccion(String link){
        currentLink = link;
        return "SeleccionEnRegistrarMateria.xhtml";
    }
    /**
     * gets the name of curse that are enfoqued on program
     * @return  name curse selected
     */
    public String nombreCursoActual() {
        return cursoActual.getMateria().getNombre();
    }
    
    /**
     * gets the id of curse that are enfoqued on program
     * @return  id curse selected
     */
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
        List<Materia> materias = null;
        try{
            materias = sp.consultarMaterias();
        }catch(UnidadProyectosException ex){
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;
    }
    
    /**
     * Consulta las materias de una asignatura
     * @param idAsignatura id de la asignatura
     * @return una lista con las Materias
     */
    public List<Materia> consultarMaterias(int idAsignatura){
        List<Materia> materias = null;
        try{
            materias = sp.consultarMaterias(idAsignatura);
        }catch(UnidadProyectosException ex){
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;
     }
    
    /**
     * Consulta la lista de programas de la Unidad de Proyectos
     * @return una lista de Programas
     */
    public List<Programa> consultarProgramas() {
        //TODO comprobar que es String para una lista desplegable
        List<Programa> lista = null;
        try{
            lista=sp.consultarProgramas();
        }catch (UnidadProyectosException ex){
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);          
        }
        return lista;
    }
    /**
     * retorna todas las asginaturas y su programa en el registro de materias
     * @return un mapa con las asignaturas y programas seleccionados
     */
    public HashMap<String,String> getAsignaturasYProgramas(){
        HashMap<String,String> resp = new HashMap<>();
        Set values = asSelectedXprog.keySet();
        Iterator keys = values.iterator();
        while(keys.hasNext()){
            int prog = (int) keys.next();
            Collection asginaturas = (Collection) asSelectedXprog.get(prog);
            Iterator keyAsigs = asginaturas.iterator();
            while (keyAsigs.hasNext()){
                resp.put("una", "selected");
                //int asigId = (int) keyAsigs.next();
                //Asignatura asig = obtenerAsignatura(asigId);
                //Programa prg = obtenerPrograma(prog);
                //resp.put(asig.getNombre(),prg.getNombre());
            }
        }
        return resp;
    }
    
    /**
     * quita una asignatua y programa selccionados para registrar materia
     * @param a asignatura 
     * @param p programa (llave del multimap)
     */
    public void quitarFila(Asignatura a, Programa p){
        asSelectedXprog.remove(p.getId(),a.getId());
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
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public int consultarCohorte(Curso curso,Programa programa){
        int cohort=0;
        try{
          cohort= sp.consultarCohorte(curso,programa); 
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        cohorteCursoActual=cohort;
        return cohort;
    }
    
    /**
     * get the current requisito
     * @return requisito selected
     */
    public String getIdRequisito(){
        return idRequisito;
    }
    
    /**
     * set the requisito
     * @param currentr requisito for sets
     */
    public void setIdRequisito(String currentr){
        idRequisito=currentr;
    }
    
    /**
     * Get the value of programa
     *
     * @return the value of programa selected
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
     * Get the value of programs selected
     *
     * @return the  list of programs
     */
    public List<Programa> getSelectedPrograms() {
        return selectedPrograms;
    }

    /**
     * Set the value of selectedPrograms
     * @param p
     */
    public void setSelectedPrograms(List<Programa> p) {
        this.selectedPrograms = p;
    }    
    
    public List<Asignatura> consultaAsginaturasXprog(Programa prog){
        List<Asignatura> lista = new ArrayList<>();
        try{
            if (prog==null){lista = sp.consultarAsignaturasXProg(0);}
            else{lista = sp.consultarAsignaturasXProg(prog.getId());}
        }catch (UnidadProyectosException ex){}
       
        return lista;
    }
   
    public void setDataTable(DataTable dt){
        this.dataTable=dt;
    }
    
    public DataTable getDataTable(){
        return this.dataTable;
    }
    
    /**
      * indexes the selected signatures
     * @param prog to verify the selection
      */
     public void changeOption(Programa prog){
         
        if (prog!=null && (idAsignaturaActual!=null || !idAsignaturaActual.equals("0"))){
           
            Asignatura sig = obtenerAsignatura(Integer.parseInt(idAsignaturaActual));
            if(sig!=null){
                if(asSelectedXprog.containsKey(prog.getId())){
                    Collection signa = (Collection) asSelectedXprog.get(prog.getId());
                    if (!signa.contains(sig.getId())){
                        asSelectedXprog.put(prog.getId(),prog.getId());
                        System.out.println("added succesfully ");
                    }else{
                        System.out.println("the signature is currently added");
                    }
                }else{
                    System.out.println("non-selected program "+prog);
                }
            }
        }
     }
    
     /**
     * listener for the select on registrarNuevaMateria.xhtml
    */
    public void rowSelectCheckBox(){
        selectedProgramsToCompare = selectedPrograms;
        System.out.println(selectedPrograms.size());
        programa=selectedPrograms.get(selectedPrograms.size()-1);
        if (!asSelectedXprog.containsKey(programa.getId())){
            if(idAsignaturaActual==null || idAsignaturaActual.equals("0")){
                idAsignaturaActual="0";
                asSelectedXprog.put(programa.getId(), null);
                System.out.println("added programa without sig");
            }else{
                Asignatura sig = obtenerAsignatura(Integer.parseInt(idAsignaturaActual));
                asSelectedXprog.put(programa.getId(), sig.getId());
                System.out.println("added succesfully with sig");
            }
       }  
    }
     
    /**
     * listener for the unselect to update the values on view
     */
    public void rowUnSelectCheckBox(){
        for (Programa p: selectedProgramsToCompare){
            if (!selectedPrograms.contains(p)){
                programa = p;
                break;
            }
        }
        if (programa!=null){
            asSelectedXprog.remove(programa.getId());
            System.out.println("quito el programa ");
        }
        selectedProgramsToCompare=selectedPrograms;
        programa=null;
    }
    
    
     /**
      * gets all sigantures of program currently selected
     * @param prog
      * @return list of selected program's signatures
      */
     public HashMap<String,String> getAsignaturasXprog(Programa prog){
        List<Asignatura> lista;
        HashMap<String,String> result=new HashMap<>();
        if (prog!=null){
            lista=consultaAsginaturasXprog(prog);
            if (lista!=null){
                for (Asignatura asig: lista) {
                    result.put(asig.getNombre(), String.valueOf(asig.getId()));
                }
            }
        }
        return result;
    }
     
     /**
      * gets the signature by his ID
     * @param id
     * @return asignatura consultada
      */
     public Asignatura obtenerAsignatura(Integer id){
         Asignatura resp = null;
         try{
             resp = sp.consultarAsignatura(id);
         }catch(UnidadProyectosException ex){
         }
         return resp;
     }
     
     /**
      * gets the program by his ID
     * @param id del programa
     * @return programa consultada
      */
     public Programa obtenerPrograma(Integer id){
         Programa resp = null;
         try{
             resp = sp.consultarPrograma(id);
         }catch(UnidadProyectosException ex){
         }
         return resp;
     }
     
    /**
     * Get the value of asignatura
     *
     * @return the value of asignatura
     */
    public Asignatura getAsignatura() {
        return asignatura;
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
    
    /**
     * Get the value of periodo
     * @return the value of periodo
     */
    public Periodo getPeriodo() {
        return periodo;
    }
    
    public Curso cursoTemp(){
        Programa pro=new Programa(5, "especializacion en proyectos");
        Asignatura as=new Asignatura(69, "fundamentos", pro);
        Materia ma=new Materia("INFU", "Introduccion a fundamentos", 4, "sdgb", as);
        Periodo pe=new Periodo("2020-1", java.sql.Date.valueOf("2020-05-03"), java.sql.Date.valueOf("2020-05-15"));
        Curso cu = new Curso(56, ma, pe);
        return cu;

    }
    
    /**
     * gets the link for the views
     * @param link to save 
     */
    public void setCurrentLink(String link){
        currentLink=link;
    }
    
    /**
     * get the string value of parameter
     * @param prog
     * @return yes or no active the list
     */
    public boolean isntActived(Programa prog){
        boolean ans=true;
        if (selectedPrograms.contains(prog)){
            ans=false;
        }
        return ans;
    }
    
    /**
     * 
     */
    public void conocer(){
        System.out.println("si esta activando el remotecommand");
    }
    /**
     * gets the link for the views
     * @return 
     */
    public String getCurrentLink(){
        return currentLink;
    }
    
    public boolean getAlertOfInvalidProgram(){
        
        return alertOfInvalidProgram;
    }
    
    public void setAlertOfInvalidProgram(boolean st){
        this.alertOfInvalidProgram=st;
    }
    
    /**
     *mesage of error or some happend
     * @return the mesage to view
     */
    public String getMesageForUser(){
        return mesageForUser;
    }
    
    /**
     * sets the mesage to be shown
     * @param mesage 
     */
    public void setMesageForUser(String mesage){
        this.mesageForUser=mesage;
    }
    
    
    
    public void setAsignaturaActualID(Integer asig){
        this.asignaturaActualID = asig;
    }
    
    public Integer getAsignaturaActualID(){
        return this.asignaturaActualID;
    }
    
    public String getIdAsignaturaActual(){
        return this.idAsignaturaActual;
    }
    
    public void setIdAsignaturaActual(String idAct){
        this.idAsignaturaActual = idAct;
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
        if (lista!=null){
            for (Programa prog: lista) {
                res.put(prog.getNombre(), String.valueOf(prog.getId()));
            }
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
        if (lista!=null){
            for (Asignatura asig: lista) {
                res.put(asig.getNombre(), String.valueOf(asig.getId()));
            }
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
        if(lista!=null){
            for (Materia materia: lista) {
                res.put(materia.getNombre(), String.valueOf(materia.getSigla()));
            }
        }
        return res;
    }
    
    public void changePrograma() {
        idAsignaturaActual = null;
        siglaMateriaActual = null;
    }
    
    public void changeAsignatura() {
        siglaMateriaActual = null;
    }
 

    public String getSiglaMateriaActual() {
        return siglaMateriaActual;
    }

    public void setSiglaMateriaActual(String siglaMateriaActual) {
        this.siglaMateriaActual = siglaMateriaActual;
    }
    
    public String getResumen() {
        String prog = idProgramaActual;
        String asig = idAsignaturaActual;
        String materia = siglaMateriaActual;
        int cohort = cohorteCursoActual;
        return prog + " " + asig + " " + materia + " " + cohort;
        
    }
    
}

