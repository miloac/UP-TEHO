package com.pcvpmo.pdsw.upteho.services;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Curso;
import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.entities.Periodo;
import com.pcvpmo.pdsw.upteho.entities.Profesor;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import com.pcvpmo.pdsw.upteho.entities.Recurso;
import com.pcvpmo.pdsw.upteho.entities.Clase;
import com.pcvpmo.pdsw.upteho.entities.HorarioDisponible;
import com.pcvpmo.pdsw.upteho.entities.ProgramaXmateria;
import com.pcvpmo.pdsw.upteho.entities.Requisito;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Interface de Servicios necesarios para la aplicacion de Unidad de Proyectos
 * @author Daniel Ospina, Andres Felipe Pardo Mesa
 */
public interface ServiciosUnidadProyectos {
    /**
     *  Registra materia con los atributos especificos.
     * //pre tipoRequisito debe ser un número entre 0 y 1.
     * @param idPrograma id del programa
     * @param idAsignatura id de la asignatura
     * @param siglaRequisito sigla del requisito
     * @param tipoRequisito tipo del requisito
     * @param nombreMateria nombre de la materia
     * @param siglaMateria sigla de la materia
     * @param descripcionMateria descripcion de la materia
     * //pos la materia es registrada debe estar en la base de datos.
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    void registrarMateria(int idPrograma, int idAsignatura, String siglaRequisito, int tipoRequisito, String nombreMateria, String siglaMateria, String descripcionMateria) throws UnidadProyectosException;
    
    /**
     * registra los programas por materia
     * @param idPrograma programas que pueden ver la materia
     * @param sigla de la materia que puede ser vista por varios programas
     * @throws com.pcvpmo.pdsw.upteho.services.UnidadProyectosException excepcion indicando que fallo durante el registro
     */
    void registrarProgramasPorMateria(Integer idPrograma,String sigla) throws UnidadProyectosException;
    
    /**
     * quita de la relacion la materia por programa
     * @param id del programa
     * @throws UnidadProyectosException indicando el error de la eliminacion
     */
    void removerProgramaPorMateria(int id) throws UnidadProyectosException;
    
    /**
     * remueve una materia dada su sigla
     * @param sigla de la materia a ser removida
     * @throws UnidadProyectosException indicando el error de la consulta
     */
    void removerMateria(String sigla)throws UnidadProyectosException;
    
    /**
     * remueve un requisito ingresado
     * @param siglaRequisito del requisito
     * @throws UnidadProyectosException indicando que no se pudo eliminar un requisito
     */
    void removerRequisito(String siglaRequisito) throws UnidadProyectosException;
    
    /**
     * retorna los requisitos de una materia
     * @param sigla de la materia
     * @return listado de todos los requisitos de la materia
     * @throws UnidadProyectosException indicando que no se genero la consulta
     */
    List<Requisito> consultarRequisitos(String sigla) throws UnidadProyectosException;
    
    /**
     *  Cancela una clase de un Curso especifico
     * @param cohorte cohorte de  la materia
     * @param idClase id de la clase
     * //pos se cancela la clase del curso especifico, se eliminan los recursos de la clase y la reserva del salon
     * @throws UnidadProyectosException Excepcion con datos del error
    **/
    void cancelarClase(int cohorte, int idClase) throws UnidadProyectosException;

    /**
     * 
     *  Programa una clase en un horario especifico
     * @param curso Curso al cual se le asignará la clase
     * @param fecha fecha de la clase
     * @param hora hora de la clase
     * //pos si la fecha y la hora son correctas se programa la clase en el horario dado.
     * @throws UnidadProyectosException Excepcion con datos del error
     */ 
    void programarClase(String fecha, String hora, Curso curso) throws UnidadProyectosException;
    
    /**
     *  Se registra un curso dada su asignatura ,materia y profesor correspondiente
     * @param idAsignatura id de la asignatura
     * @param siglaMateria sigla de la materia
     * @param idProfesor id del profesor
     * //pos si el profesor tiene el horario adecuado para dictar el curso,se resgistra el curso sin clases ni periodo
     * @throws UnidadProyectosException Excepcion con datos del error
     * 
     */
    void registrarCurso(int idAsignatura, String siglaMateria, int idProfesor) throws UnidadProyectosException ;
   
   /**
    *  Consulta las materia registradas en el sistema
    * @return lista de Materia
    * //pos List con todas las Materias registradas en la base de datos
    * @throws UnidadProyectosException Excepcion con datos del error
    */ 
    List<Materia> consultarMaterias() throws UnidadProyectosException;
   
   /**
    * retorna la materia dada su sigla
    * @param sigla de la materia que se quiere consultar
    * @return materia
    * @throws UnidadProyectosException indicando que no se pudo consultar
    */
   Materia consultarMateria(String sigla)throws UnidadProyectosException;
   /**
    *  consulta las materias de una asignatura
    * @param idAsignatura id de la asignatura
    * @return lista con Materias 
    * //pos List con las materias que contiene una Asignatura 
    * @throws UnidadProyectosException Excepcion con datos del error
    */
    List<Materia> consultarMaterias(int idAsignatura) throws UnidadProyectosException;
   
   /**
    * registra un requisito
     * @param mat sigla materia en registro
     * @param matReq sigla de su requisito o corequisito
     * @param tipo si es completo el requisito o no
     * @throws UnidadProyectosException indicando que no se completo el registro
    */
   void registrarRequisito(String mat,String matReq,int tipo)throws UnidadProyectosException;
   
   /**
    *  Consulta los programas de la Unidad de Proyectos
    * @return Lista con los Programas de la unidad de proyectos
    * //pos List con los programas registrados en la base de datos
    * @throws UnidadProyectosException Excepcion con datos del error
    */
    List<Programa> consultarProgramas() throws UnidadProyectosException;
   
   /**
    *  Consulta  programa por su id
     * @param id frl programa
    * @return Programa de la unidad de proyectos
    * @throws UnidadProyectosException Excepcion con datos del error
    */
   Programa consultarPrograma(Integer id) throws UnidadProyectosException;
   
   /**
    *  Consulta las asignaturas 
    * @return lista con de las Asignaturas
    * //pos:List con  las asignaturas registradas en la base de datos
    * @throws UnidadProyectosException Excepcion con datos del error
    */
    List<Asignatura> consultarAsignaturas()throws UnidadProyectosException;
   
   /**
    * consulta una asignatura dado su id
    * @param id de la asignatura
    * @return asignatura
     * @throws UnidadProyectosException no se pudo consultar la asignatura
    */
   Asignatura consultarAsignatura(Integer id)throws UnidadProyectosException;
   
   /**
    *  Consulta las asignaturas por programa 
    * @param programa nombre del programa
    * @return lista con de las Asignaturas del programa
    * //pos:List con  las asignaturas registradas en la base de datos
    * @throws UnidadProyectosException Excepcion con datos del error
    */
   List<Asignatura> consultarAsignaturasXProg(int programa)throws UnidadProyectosException;
   
   /**
    *  Consulta los profesores segun el filtro de busqueda
    * @param busqueda filtro de busqueda de profesores
    * @return lista con los Profesores que contienen en su nombre la palabra de la busqueda
    * //pos: List de tipo Profesor ,donde el nombre de los profesores contiene el String dado en la busqueda
    * @throws UnidadProyectosException Excepcion con datos del error
    */
    List<Profesor> consultarProfesores(String busqueda) throws UnidadProyectosException;

    /**
     *  Consulta las clases programadas para un curso especifico
     * @param cohorte cohorte del curso
     * @return lista de Clases dado un curso especifico
     * //pos: List de tipo Clase con las Clases que corresponden a un curso especifico
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    List<Clase> consultarClases(String cohorte) throws UnidadProyectosException;

    /**
     *  Consulta los recursos disponibles que pueden ser asignados a una clase 
     * @return Lista de Recursos
     * //pos: List de tipo Recurso con los Recursos que estan disponibles.
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    List<Recurso> consultarRecursosDisponibles() throws UnidadProyectosException;

    /**
     * objetivo: consulta los recursos de una clase dada
     * @param cohorte cohorte del curso
     * @return lista con Recursos
     * //pos: List de tipo Recurso que tiene los recursos usados en la clase dada
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    List<Recurso> consultarRecursosClase(String cohorte) throws UnidadProyectosException;

    /**
     *  consulta los cursos registrados en la base de datos
     * @return Lista con todos los cursos registrados
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    List<Curso> consultarCursos() throws UnidadProyectosException;

    /**
     *  se consulta un  curso especifico dado su numero de id
     * //pre id mayor que 0
     * @param id id del curso a consultar
     * @return Curso correspondiente a el numero de id
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    Curso consultarCurso(int id) throws UnidadProyectosException;

    /**
     * Consulta Consulta todos los cursos de un periodo especifico
     * @param nombre nombre del curso
     * //pos nombre debe tener el formato [Año]-[Semestre] Ejemplo: "2017-1"
     * @return lista de cursos del periodo
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    List<Curso> consultarCursosPorPeriodo(String nombre) throws UnidadProyectosException;

    /**
     *  Consulta las clases dado el periodo academico
     * //pre periodo puede ser null
     * @param periodo  periodo a consultar
     * @return lista con los clases que corresponden al periodo academico
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    List<Clase> consultarClasesPeriodo(Periodo periodo) throws UnidadProyectosException; 

    /**
     * Consultar las clases registrados en  la base de datos
     * @return lista con todos los clases registrados
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    List<Clase> consultarClases() throws UnidadProyectosException; 

    /**
     * Consultar las clases correspondientes a un curso especifico
     * @param id id del curso
     * @return lista de clases que corresponden a un curso especifico
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    List<Clase> consultarClasesCurso(int id) throws UnidadProyectosException;
    
    /**
     * Consulta el cohorte dado un Curso y un Programa
     * POS: Retorna 0 si el cohorte no existe
     * @param curso curso a consultar
     * @param programa programa a consultar
     * @return entero del cohorte
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    int consultarCohorte(Curso curso,Programa programa) throws UnidadProyectosException;
    
    /**
     * Consulta las clases dado un periodo especifico
     * //pos: si periodo es null, debe retornar todas las clases de todos los periodos
     * @param periodo periodo a consultar
     * @return Lista de clases
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    List<Clase> consultarClasesxPeriodo(String periodo) throws UnidadProyectosException;
    
    /**
     * Consulta las asignaturas dado un programa especifico
     * //pos: si el programa es null, debe retornar todas las asignaturas
     * @param idPrograma id del programa por el cual filtrar
     * @return Lista de asignaturas
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    List<Asignatura> consultarAsignaturasxPrograma(Integer idPrograma) throws UnidadProyectosException;
    
    /**
     * Consulta las Materias dada una asignatura especifica
     * //pos: si la sigla es null, debe retornar todas las materias
     * @param idAsignatura id de la asignatura por la cual filtrar
     * @return Lista de Materias
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    List<Materia> consultarMateriasxAsignatura(Integer idAsignatura) throws UnidadProyectosException;

    /**
     * Consulta las Materias dado un programa especifico
     * //pos: si la sigla es null, debe retornar todas las materias
     * @param idPrograma id del programa
     * @return Lista de Materias
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    List<Materia> consultarMateriasxPrograma(Integer idPrograma) throws UnidadProyectosException;
    
    /**
     * Agrega una clase a un curso especifico, si el horario del profesor coincide
     * @param idCurso id del  Curso al cual se le agregara una clase
     * @param fecha fecha de la clase
     * @param hora hora de la clase
     * @param tSalon tipo de salon de la clase
     * @param idProfesor id del profesor que dictara la clase
     * @return booleano si fue posible agregar la clase
     * @throws UnidadProyectosException si el identificador del curso o el identificador del profesor no existe
     */
    boolean agregarClase(int idCurso, Date fecha, Time hora, String tSalon,int idProfesor) throws UnidadProyectosException;

    /**
     * Consulta el siguiente id disponible de los cursos ya registrados
     * @return id disponible de un curso
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    int getNextCurso() throws UnidadProyectosException;

    /**
     * Consulta un periodo dado su id
     * @param idPeriodoActual id del periodo a consultar
     * @return Periodo con sus datos
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    Periodo consultarPeriodo(String idPeriodoActual) throws UnidadProyectosException;
    
    /**
     * Consulta todos los periodos en la Unidad de Proyectos
     * @return Lista de Periodos
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    List<Periodo> consultarPeriodos() throws UnidadProyectosException;
    
    /**
     * Registra un Curso
     * // PRE: Se espera que el programa, la asignatura, el periodo y el profesor ya esten registrados
     * // POS: El curso es registrado correctamente
     * @param cursoActual curso a registrar 
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    void registrarCurso(Curso cursoActual) throws UnidadProyectosException;
    
    /**
     * consulta si un cohorte ya se encuentra registrado
     * @param id numero id de un cohorte
     * @throws UnidadProyectosException si el numero id del cohorte no existe
     */
    void consultarCohorte(int id) throws UnidadProyectosException;
    
    /**
     * Registra un nuevo cohorte para un curso y programa especifico
     * @param idPrograma id del programa
     * @param idCurso id del curso
     * @param cohorte id del cohorte
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    void registrarCohorte(int idPrograma, int idCurso, int cohorte) throws UnidadProyectosException;
    
    /**
     * Consulta las clases de un profesor dado 
     * @param idProf id del profesor a consultar
     * @return lista de clases de un profesor dado
     * @throws UnidadProyectosException cuando el id del profesor no existe
     */
    List<Clase> consultarClasesProfesor(int idProf) throws UnidadProyectosException;
    
    /**
     * Cancela  la clase dado su id
     * @param id ud de la clase a cancelar
     * @throws UnidadProyectosException  Excepcion con datos del error
     */
    void cancelarClase(int id) throws UnidadProyectosException;
    
    /**
     * Registra una nueva asignatura para un programa de la Unidad de Proyectos
     * //PRE: se espera que el programa ya este registrado
     * @param nombreAsig nombre de la asignatura a registrar
     * @param idProg id del programa al que pertenece la asignatura
     * @throws UnidadProyectosException Si el nombre ingresado ya existe
     */
    void registrarAsignatura(String nombreAsig, int idProg) throws UnidadProyectosException;
    
    /**
     * Registra una nueva asignatura para un programa de la Unidad de Proyectos
     * @param idAsignatura id de la asignatura
     * @param nombreAsig nombre de la asignatura
     * @param idProg Id del programa
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    void registrarAsignatura(int idAsignatura, String nombreAsig, int idProg) throws UnidadProyectosException;
    
    /**
     * Registra un nuevo periodo
     * @param periodo Periodo a registrar
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    void registrarPeriodo(Periodo periodo) throws UnidadProyectosException;
    
    /**
     * Registra un nuevo profesor
     * @param profesor profesor a registrar
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    void registrarProfesor(Profesor profesor) throws UnidadProyectosException;
    
    /**
     * Registra una nueva materia con sus datos
     * //PRE: se espera que la asignatura este previamente registrada
     * @param materia materia a registrar
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    void registrarMateria(Materia materia) throws UnidadProyectosException;
    
    /**
     * Registra un nuevo Programa
     * @param programa programa a registrar
     * @throws UnidadProyectosException Excepcion con datos del error
     */
    void registrarPrograma(Programa programa) throws UnidadProyectosException;
    
    /**
     * Inserta a un profesor dado un nuevo horario
     * @param id del profesor 
     * @param diaDisp dia disp del profesor
     * @param horaDisp hora disp del profesor
     * @throws UnidadProyectosException con datos incorrectos
     */
    void insertarHorarioProfesor(int id, String diaDisp, Time horaDisp) throws UnidadProyectosException;
    
    /**
     * Consulta los horarios disponibles de un profesor
     * @param id del profesor para consultar sus horarios
     * @return horario del profesor
     * @throws UnidadProyectosException no se completo la consulta 
     */
    List<HorarioDisponible> consultarHorarioProfesor(int id) throws UnidadProyectosException;
    
    /**
     * devuelve el dia de la semana correspondiente a una fecha
     * @param fecha fecha del dia de la semana
     * @return dato de la fecha
     */
    String obtenerDiaSemana(Date fecha);
    
    /**
     * devuelve las relaciones materia-programa
     * @param sigla de la mateira
     * @return listado de las relaciones
     * @throws UnidadProyectosException para indicar cualquier error
     */
    List<ProgramaXmateria> relacionMateriaPrograma(String sigla) throws UnidadProyectosException;
    
    /**
     * devuelve las relaciones materia-programa
     * @param id del programa relacionado a mateira
     * @return listado de las relaciones
     * @throws UnidadProyectosException para indicar cualquier error
     */
    List<ProgramaXmateria> relacionProgramaMateria(Integer id) throws UnidadProyectosException;
    
    /**
     * devuelve las relaciones materia-programa registradas en el sistema
     * @return listado de las relaciones
     * @throws UnidadProyectosException para indicar cualquier error
     */
    List<ProgramaXmateria> todasLasRelaciones() throws UnidadProyectosException;
}

