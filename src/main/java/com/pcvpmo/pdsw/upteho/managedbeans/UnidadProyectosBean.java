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
import org.apache.ibatis.exceptions.PersistenceException;
import org.primefaces.context.RequestContext;


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
    //variables para el registro de una mateira--------------------------------------------
    private String asignaturaSeleccionada;
    private Integer programaSeleccionado;
    //-----------------------------
    private String currentLink;
    private List<String> selectedPrograms;
    private String mesageForUser;
    private HashMap<String,String> requisitosEscogidos;
    private String idRequisito;
    private String tipoRequisito;
    //--fundamental--
    private String siglaMateria;
    private String nombreMateria;
    private String descripcion;
    private String creditos;
    //-------------------------------------------------------------------------------------
    private String idPeriodoActual;   
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
        selectedPrograms = new ArrayList<>();
        requisitosEscogidos=new HashMap<>();
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
            if(cursoActual.getProfesor()!=null){
                cursoActual.setProfesor(null);
            }
        } catch (UnidadProyectosException ex) {
            Logger.getLogger(UnidadProyectosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "RegistroMateriaNuevoCohorte";
    }
    
    public String volverPaginaCurso() {
        cursoActual.setProfesor(profesorSelect);
        setProfesorSelect(null);
        return "ProgramarCurso";
    }
    
    public String irPaginaAsginatura(){
        return "RegistrarAsignatura";
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
     * funcion llamada en caso de que el usuario tenga problemas con la pagina y necesite recargarla
     * esta funcion serciora que tambien la parte logica de RegistrarMateria se reinicie
     */
    public void resetForRegistrarMateria(){
        finalizarRegistroMateria();
    }
    
    /**
     * reinicia todas las variables que estaban involucradas con el registro de una materia que se decidio no ser registrada
     * @return si es ejecutado desde el commandButton de cancelar, retorna el link de redireccionamiento a la pagina de inicio
     */
    public String finalizarRegistroMateria(){
        idProgramaActual=null;
        idRequisito=null;
        idAsignaturaActual=null;
        siglaMateriaActual=null;
        selectedPrograms =new ArrayList<>();
        mesageForUser=null;
        requisitosEscogidos=new HashMap<>();
        siglaMateria=null;
        nombreMateria=null;
        descripcion=null;
        return "ConsultarMaterias.xhtml";
    }
    
    /**
     * Registra una Materia nueva con los datos necesarios respectivos
     * @param asig asignatura a la que esta registrada la materia
     * @param cred creditos de la asignatura
     * @param sigla  codigo mnemónico de la asignatura (no se puede repetir)
     * @param nombre nombre de la asignatura (preferiblemente no se repite)
     * @param descripcion descripcion de la materia
     * @return valor indicando si se completo la operacion
     */
    public boolean registrarMateria(Asignatura asig, String nombre, String sigla, Integer cred, String descripcion) {
        boolean ans;
        try{
            Materia toRegistry = new Materia(sigla,nombre,cred,descripcion,asig);
            sp.registrarMateria(toRegistry);
            ans=true;
        }catch(UnidadProyectosException ex){
            ans=false;
        }
        return ans;
    }
    
    /**
     * registra los requisitos de una materia
     * @param requisitos de la materia en registro
     * @param sigla de la materia a ser relacionada
     * @return valor indicando si se completo la operacion
     */
    public boolean registrarRequisitosMateria(HashMap<String,String> requisitos,String sigla){
        boolean ans = true;
        Iterator reqs = requisitos.entrySet().iterator();
        while (ans && reqs.hasNext()){
            Map.Entry e = (Map.Entry) reqs.next();
            String tipoR = (String) e.getValue();
            if (isNumeric(tipoR)){
                try{
                    sp.registrarRequisito(sigla,(String) e.getKey(),Integer.parseInt(tipoR));
                }catch (UnidadProyectosException ex){
                    ans=false;
                }
            }
        }
        return ans;
    }
    
    /**
     * registra los programas asociados a la materia que se esta registrando y sus requisitos
     * @param sigla de la materia que se esta intentando registrar
     * @param listado de id de los programas que pueden ver la materia
     * @return valor booleano indicando si se pudo completar la operacion
     */
    public boolean registrarProgramasMateria(String sigla, List<String> listado){
        boolean ans=true;
        while (ans){
            for (String st:listado){
                if(isNumeric(st)){
                    try{
                        sp.registrarProgramasPorMateria(Integer.parseInt(st),sigla);
                        ans=true;
                    }catch (UnidadProyectosException ex){
                        ans=false;                        
                    }
                }
            }
        }
        
        return ans;        
        
    }
    
    private void devolverse(String sigla, HashMap<String,String> reqs,List<String> selp){
        for (Map.Entry e : reqs.entrySet()) {
            try{
                sp.removerRequisito((String) e.getKey());
            }catch(UnidadProyectosException ex){}
        }
        for (String s: selp){
            try{
                sp.removerProgramaPorMateria(Integer.parseInt(s));
            }catch (UnidadProyectosException ex){}
        }
        try{
            sp.removerMateria(sigla);
        }catch(UnidadProyectosException ex){} 
    }
    
    /**
     * listener del boton que le permite al cliente proceder a registrar la asignatura
     * @return link de la pagina consultar materias, para verificar el registro
     */
    public String clickAgregarMateria(){
        RequestContext request = RequestContext.getCurrentInstance();
        Materia noRegistred = obtenerMateria(siglaMateria);
        boolean continuar=false;
        //si la sigla no es igual que la de alguna materia ya registrada
        if (noRegistred==null){
            boolean noInvalidMateria = (nombreMateria.length()>0 && descripcion.length()>20 && siglaMateria.length()==4 && !requisitosEscogidos.isEmpty() && isNumeric(creditos));
            if( !selectedPrograms.isEmpty() && isNumeric(asignaturaSeleccionada) && noInvalidMateria){
                Asignatura asig = obtenerAsignatura(Integer.parseInt(asignaturaSeleccionada));
                continuar = registrarMateria(asig,nombreMateria,siglaMateria,Integer.parseInt(creditos),descripcion);
                if (continuar){
                    boolean primerRegistro = registrarRequisitosMateria(requisitosEscogidos,siglaMateria);
                    boolean segundoRegistro = registrarProgramasMateria(siglaMateria,selectedPrograms);
                    if (!primerRegistro || !segundoRegistro){
                        devolverse(siglaMateria,requisitosEscogidos,selectedPrograms);
                    }
                }                   
            }else{
                request.execute("alertaError('verifique que ha completado los formularios y las selecciones')");
            }
        }else{
            if(noRegistred.getNombre().equals(nombreMateria)){
                request.execute("alertaError('el nombre de esta materia ya esta registrado')");
            }else{
                request.execute("alertaError('la sigla que esta intentando registrar ya esta ocupada por otra materia')");
            }
            currentLink = "";
        }
        if(continuar){
            finalizarRegistroMateria();
            currentLink = "RegistroNuevaMateria.xhtml";
            request.execute("alertaError('se ha registrado la materia con exito')");
            currentLink="ConsultarMaterias.xhtml";
        }
        return currentLink;
    }
    
    /**
     * metodo para quitar lo que se halla alcanzado a registrar en la base de datos
     */
    private void cancelarInsercion(RequestContext request){
        try{
            sp.removerMateria(siglaMateria);
            finalizarRegistroMateria();
        }catch(UnidadProyectosException ex){
            
        }
        request.execute("alertaError('removiendo datos')");
    }
    
    /**
     * registra los requisitos o corequisitos para una materia (si se puede)
     * @param siglaMat sigla de la materia en curso de registro
     * @param siglaReq sigla de su requisito
     * @param tipo si es completo o corequisito
     * @param request para generar dialogo e informar oportunamente el cliente
     * @return saying that all requisits was regystered
     */
    
    public boolean registrarRequisitos(String siglaMat, String siglaReq, int tipo, RequestContext request){
        boolean ans = true;
        try{
            sp.registrarRequisito(siglaMat, siglaReq, tipo);
        }catch(UnidadProyectosException ex){
            ans=false;
            request.execute("alertaError('no se pudo completar el registro')");
            cancelarInsercion(request);
        }
        return ans;
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
     * retorna una mateira dado su Id
     * @param sigla de la materia que se quiere consultar
     * @return materia consultada
     */
    public Materia obtenerMateria(String sigla){
        Materia resp=null;
        try{
            resp=sp.consultarMateria(sigla);
        }catch(UnidadProyectosException ex){}
        return resp;
    }
    
    /**
     * quita una asignatua y programa selccionados para registrar materia
     * @param sigla nombre materia
     */
    public void quitarRequisito(String sigla){
        requisitosEscogidos.remove(sigla);
    }
    
    /**
     * Consulta las asignaturas
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
     * consulta las materias de un programa (el seleccionado actualmente)
     * @return 
     */
    public List<Materia> consultaMateriasXprog(){
        List<Materia> lista = new ArrayList<>();
        try{
            if (idProgramaActual==null || !isNumeric(idProgramaActual)){lista = sp.consultarMateriasxPrograma(0);}
            else{lista = sp.consultarMateriasxPrograma(Integer.parseInt(idProgramaActual));}
        }catch (UnidadProyectosException ex){}
                
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
     * get the current creditos value
     * @return credits of signature selected
     */
    public String getCreditos(){
        return this.creditos;
    }
    
    /**
     * set the credits of current materia to registry
     * @param creditos creditos for sets
     */
    public void setCreditos(String creditos){
        this.creditos = creditos;
    }
    
    /**
     * Get the value of programa
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
     * retorna las asignaturas asociadas a un programa dado prog
     * @param prog programa del que se obtendran sus asignaturas
     * @return asignaturas del programa consultadas
     */
    public List<Asignatura> consultaAsginaturasXprog(Programa prog){
        List<Asignatura> lista = new ArrayList<>();
        try{
            if (prog==null){lista = sp.consultarAsignaturasXProg(0);}
            else{lista = sp.consultarAsignaturasXProg(prog.getId());}
        }catch (UnidadProyectosException ex){}
       
        return lista;
    }  
    
    /**
     * devuelve los requisitos que se hallan seleccionado con la finalidad de verificar que la seleccion es correcta antes de proceder
     * @return mapeo de los requisitos
     */
    public HashMap<Materia,String> getRequisitosEscogidos(){
        HashMap<Materia,String> resp = new HashMap<>();
        Set siglas = requisitosEscogidos.keySet();
        Iterator sigla = siglas.iterator();
        while(sigla.hasNext()){
            String sigla_materia = (String) sigla.next();
            String tipo = requisitosEscogidos.get(sigla_materia);
            if(tipo.equals("0")){
                tipo="preRequisito";
            }if(tipo.equals("1")){
                tipo="coRequisito";
            }
            Materia mat = obtenerMateria(sigla_materia);
            resp.put(mat ,tipo);
        }
        return resp;
    }
           
    /**
     * retorna las materias de un programa (el seleccionado actualmente)
     * @return mapeado de las materias 
     */
    public Map<String,String> getMateriasPorPrograma(){
        List<Materia> lista=consultaMateriasXprog();
        HashMap<String,String> resp = new HashMap<>();
        for (Materia m: lista){
            resp.put(m.getNombre(),m.getSigla());
        }
        return resp;
    }
    
     /**
     * retorna todas las asginaturas y su programa escogidos en el registro de materias
     * @return un mapa con las asignaturas y programas seleccionados
     */
    public HashMap<Programa,String> getAsignaturasYProgramas(){
        HashMap<Programa,String> resp = new HashMap<>();
        String forOther = "Asignatura del programa ";
        for (String idProgram: selectedPrograms){
            Integer id =Integer.valueOf(idProgram);
            Programa current = obtenerPrograma(id);
            Programa selected = obtenerPrograma(programaSeleccionado);
            if (id.equals(programaSeleccionado)){
                if (isNumeric(idAsignaturaActual)){
                    Asignatura asig = obtenerAsignatura(Integer.parseInt(idAsignaturaActual));
                    resp.put(current,asig.getNombre());
                }
                else{
                    resp.put(current,"No ha seleccionado la asignatura");
                }
            }else{
                resp.put(current, forOther+selected.getNombre());
            }
        }
        return resp;
    }
    
     /**
      * gets all sigantures of program currently selected
     * @param prog programa del que se obtendran sus asignaturas
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
      * retorna los programas seleccionados, estos programas pueden ver la materia en registro
      * @return lista de programas con su respectivo id
      */
     public HashMap<String,String> getProgramasSeleccionados(){
         HashMap<String,String> resp = new HashMap<>();
         for (String idPrograma:selectedPrograms){
             Integer id =Integer.valueOf(idPrograma);
             Programa current = obtenerPrograma(id);
             resp.put(current.getNombre(),String.valueOf(current.getId()));
         }         
         return resp;
     }

     /**
      * gets the signature by his ID
     * @param id id de la asignatura deseada
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
    
    //-------------------------------------listener de la vista registrar Materia-----------------------------------------------------------------------------------------------------
    
    /**
     * verifica si una cadena es numero para anticipar errores de operaciones sobre esta misma
     * @param st cadena a verificar si es numero
     * @return true si es un numero false si son solo caracteres no numericos
     */
     public boolean isNumeric(String st){
         boolean ans;
         if(st!=null){
            if (st.isEmpty() || st.equals("") || st.length()==0){
                ans=false;
            }else{
                int pos = 0; 
                ans=true;
                while(ans && pos<st.length()){
                    char c = st.charAt(pos);
                    ans = Character.isDigit(c);
                    pos+=1;
                }
            }
         }else{
             ans=false;
         }
         return ans;
     }
            
      /**
     * agrega un requisito escogido
     */
    public void addRequisito(){
        if (idRequisito.length()>0){
            if(requisitosEscogidos.containsKey(idRequisito)){
                requisitosEscogidos.replace(idRequisito,tipoRequisito);
            }else{
                requisitosEscogidos.put(idRequisito,tipoRequisito);
            }
        }
    }
    
    /**
     * retorna el link de requisitos seleccionados
     * @return link de la pagina
     */
    public String getLinkRequisitos(){
        return "ListaRequisitosSeleccionados.xhtml";
    }
     /**
      * define el estado de un select para darle acceso 
     * @param prog programa al que se le quieren seleccionar las asginaturas
     * @return si se ha escogido el programa se puede escoger la asignatura, si no, estara deshabilitada la opcion
      */
     public boolean enable(Programa prog){
         boolean ans;
         ans = !selectedPrograms.contains(String.valueOf(prog.getId()));
         return ans;
     }
     
     
    /**
      * funcion logica que soporta el funcionamiento de seleccion de asignaturas de un programa en RegistrarNuevaMateria
     * @param prog programa al que pertenecen las asignaturas escogibles en esa seccion
      */
     public void changeOption(Programa prog){
         if(isNumeric(idAsignaturaActual)){
             asignaturaSeleccionada = idAsignaturaActual;
             programaSeleccionado = prog.getId();
         }    
     }    
            
     /**
      * another listener
     * @param prog programa que se esta seleccionando
     * @param rowIndex identificador de la fila de la tabla, donde esta el programa (solo importante para presentacion)
      */
     public void clickButtonSelect(Programa prog, int rowIndex){
         if (prog!=null){
             String id = String.valueOf(prog.getId()); 
            if(!selectedPrograms.contains(id)){
                selectedPrograms.add(id);
            }
            else{
                selectedPrograms.remove(id);
                if(programaSeleccionado.equals(prog.getId())){
                    asignaturaSeleccionada=null;
                    programaSeleccionado=null;
                }
                if(selectedPrograms.isEmpty()){
                    idAsignaturaActual=null;
                    idRequisito=null;
                    tipoRequisito=null;
                }
            }
         }
     }
         
    //---------------------------------------------------------listener registrar materia fin ------------------------------------------------------------------------------
             
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
     * gets the link for the views
     * @return the link of current page
     */
    public String getCurrentLink(){
        return currentLink;
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
     * @param mesage mensaje que se quiere mostrar al usuario
     */
    public void setMesageForUser(String mesage){
        this.mesageForUser=mesage;
    }
    
    
    public String getSiglaMateria(){
        return this.siglaMateria;
    }
    
    public String getNombreMateria(){
        return this.nombreMateria;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    public void setSiglaMateria(String var){
        this.siglaMateria=var;
    }
    
    public void setNombreMateria(String var){
        this.nombreMateria=var;
    }
    
    public void setDescripcion(String var){
        this.descripcion=var;
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
        if (lista!=null){
            for (Asignatura asig: lista) {
                res.put(asig.getNombre(), String.valueOf(asig.getId()));
            }
        }
        return res;
    }
    
    /**
     * obtiene las materias de una asignatura (la actualmente escogida)
     * @return mapeo de las materias de la asginatura escogida
     */
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
 
    public void setTipoRequisito(String tr){
        this.tipoRequisito = tr;
    }
    
    public String getTipoRequisito(){
        return this.tipoRequisito;
    }
    
    public void setIdRequisito(String idR) {
        this.idRequisito = idR;
    }
    
    public String getIdRequisito(){
        return this.idRequisito;
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


    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
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