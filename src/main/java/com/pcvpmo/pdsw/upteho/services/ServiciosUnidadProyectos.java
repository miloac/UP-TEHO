package com.pcvpmo.pdsw.upteho.services;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Clase;
import com.pcvpmo.pdsw.upteho.entities.Curso;
import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.entities.Periodo;
import com.pcvpmo.pdsw.upteho.entities.Profesor;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import com.pcvpmo.pdsw.upteho.entities.Recurso;
import com.pcvpmo.pdsw.upteho.entities.Salon;
import java.util.List;

/**
 * Interface de Servicios necesarios para la aplicacion de Unidad de Proyectos
 * @author Daniel Ospina, Andres Felipe Pardo Mesa
 */
public interface ServiciosUnidadProyectos {
    /**
     * @obj Registra materia con los atributos especificos.
     * @pre tipoRequisito debe ser un número entre 0 y 1.
     * @param idPrograma 
     * @param idAsignatura
     * @param siglaRequisito
     * @param tipoRequisito
     * @param nombreMateria
     * @param siglaMateria
     * @param descripcionMateria
     * @pos la materia es registrada debe estar en la base de datos.
     * @throws UnidadProyectosException 
     */
    public void registrarMateria(int idPrograma, int idAsignatura, String siglaRequisito, int tipoRequisito, String nombreMateria, String siglaMateria, String descripcionMateria) throws UnidadProyectosException;
    
    /**
     * @obj Cancela una clase de un Curso especifico
     * @param cohorte
     * @param idClase
     * @pos se cancela la clase del curso especifico, se eliminan los recursos de la clase y la reserva del salon
     * @throws UnidadProyectosException
    **/
    public void cancelarClase(int cohorte, int idClase) throws UnidadProyectosException;

    /**
     * @param curso Curso al cual se le asignará la clase
     * @obj Programa una clase en un horario especifico
     * @param fecha
     * @param hora 
     * @pos si la fecha y la hora son correctas se programa la clase en el horario dado.
     * @throws UnidadProyectosException
     */ 
    public void programarClase(String fecha, String hora, Curso curso) throws UnidadProyectosException;
    //TODO: Cambiar parametros dependiendo como se diseñe el bean.
    // Los paranetros inicialmente puestos era fecha y hora unicamente
    
    /**
     * @obj Se registra un curso dada su asignatura ,materia y profesor correspondiente
     * @param idAsignatura
     * @param siglaMateria
     * @param idProfesor
     * @pos si el profesor tiene el horario adecuado para dictar el curso,se resgistra el curso sin clases ni periodo
     * @throws UnidadProyectosException
     * 
     */
    public void registrarCurso(int idAsignatura, String siglaMateria, int idProfesor) throws UnidadProyectosException ;
   
   /**
    * @obj Consulta las materia registradas en el sistema
    * @return lista de Materia
    * @pos List con todas las Materias registradas en la base de datos
    * @throws UnidadProyectosException
    */ 
   public List<Materia> consultarMaterias() throws UnidadProyectosException;
   
   /**
    * @obj consulta las materias de una asignatura
    * @param idAsignatura id de la asignatura
    * @return lista con Materias 
    * @pos List con las materias que contiene una Asignatura 
    * @throws UnidadProyectosException 
    */
   public List<Materia> consultarMaterias(int idAsignatura) throws UnidadProyectosException;
   
   /**
    * @obj Consulta los programas de la Unidad de Proyectos
    * @return Lista con los Programas de la unidad de proyectos
    * @pos List con los programas registrados en la base de datos
    * @throws UnidadProyectosException 
    */
   public List<Programa> consultarProgramas() throws UnidadProyectosException;
   
   /**
    * @obj Consulta las asignaturas 
    * @return lista con de las Asignaturas
    * @pos:List con  las asignaturas registradas en la base de datos
    * @throws UnidadProyectosException
    */
   public List<Asignatura> consultarAsignaturas()throws UnidadProyectosException;
   
   /**
    * @obj Consulta los profesores segun el filtro de busqueda
    * @param busqueda
    * @return lista con los Profesores que contienen en su nombre la palabra de la busqueda
    * @pos: List de tipo Profesor ,donde el nombre de los profesores contiene el String dado en la busqueda
    * @throws UnidadProyectosException
    */
  public List<Profesor> consultarProfesores(String busqueda) throws UnidadProyectosException;
  
  /**
   * @obj Consulta las clases programadas para un curso especifico
   * @param cohorte
   * @return lista de Clases dado un curso especifico
   * @pos: List de tipo Clase con las Clases que corresponden a un curso especifico
   * @throws UnidadProyectosException 
   */
  public List<Clase> consultarClases(String cohorte) throws UnidadProyectosException;
  
  /**
   * @obj Consulta los recursos disponibles que pueden ser asignados a una clase 
   * @return
   * @pos: List de tipo Recurso con los Recursos que estan disponibles.
   * @throws UnidadProyectosException
   */
  public List<Recurso> consultarRecursosDisponibles() throws UnidadProyectosException;
  
  /**
   * objetivo: consulta los recursos de una clase dada
   * @param cohorte
   * @return lista con Recursos
   * @pos: List de tipo Recurso que tiene los recursos usados en la clase dada
   * @throws UnidadProyectosException 
   */
  public List<Recurso> consultarRecursosClase(String cohorte) throws UnidadProyectosException;
  
  /**
   * @obj consulta los cursos registrados en la base de datos
   * @return Lista con todos los cursos registrados
   * @throws UnidadProyectosException 
   */
  public List<Curso> consultarCursos() throws UnidadProyectosException;
  
  /**
   * @obj se consulta un  curso especifico dado su numero de cohorte
   * @pre cohorte mayor que 0
   * @param cohorte cohorte del curso a consultar
   * @return Curso correspondiente a el numero de cohorte
   * @throws UnidadProyectosException 
   */
  public Curso consultarCurso(int cohorte) throws UnidadProyectosException;
  
  /**
   * Consulta Consulta todos los cursos de un periodo especifico
   * @param nombre del curso
   * @pos nombre debe tener el formato [Año]-[Semestre] Ejemplo: "2017-1"
   * @return lista de cursos del periodo
   * @throws UnidadProyectosException
   */
  public List<Curso> consultarCursosPorPeriodo(String nombre) throws UnidadProyectosException;
  /**
   * Consulta los salones dado el periodo academico
   * @pre periodo puede ser null
   * @param periodo
   * @return lista con los salones que corresponden al periodo academico
   * @throws UnidadProyectosException 
   */
  public List<Salon> consultarSalonesPeriodo(Periodo periodo) throws UnidadProyectosException; 
  
  /**
   * @obj Consultar clase correspondientes a un curso
   * @pre idCohorte puede ser null
   * @param idCohorte
   * @return lista con las Clases que corresponden a un curso
   * @throws UnidadProyectosException 
   */
  public List<Clase> consultarClasesCurso(int idCohorte)throws UnidadProyectosException;
  
  /**
   * @obj consultar los salones registrados en  la base de datos
   * @return lista con todos los salones registrados
   * @throws UnidadProyectosException 
   */
  public List<Salon> consultarSalones() throws UnidadProyectosException; 
  
  /**
   * @obj consultar los salones correspondientes a un curso especifico
   * @param cohorte
   * @return lista de salones que corresponden a un curso especifico
   * @throws UnidadProyectosException 
   */
  public List<Salon> consultarSalonCurso(int cohorte) throws UnidadProyectosException;
  
}
