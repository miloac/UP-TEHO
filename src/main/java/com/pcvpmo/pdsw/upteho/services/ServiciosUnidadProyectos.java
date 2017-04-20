/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.services;

import com.pcvpmo.pdsw.upteho.dao.PersistenceException;
import java.util.List;

/**
 * Interface de Servicios necesarios para la aplicacion de Unidad de Proyectos
 * @author Daniel Ospina, Andres Felipe Pardo Mesa
 */
public interface ServiciosUnidadProyectos {
    /**
     * objetivo: Registra materia con los atributos especificos.
     * @pre: tipoRequisito debe ser un número entre 0 y 1.
     * @param idPrograma 
     * @param idAsignatura
     * @param siglaRequisito
     * @param tipoRequisito
     * @param nombreMateria
     * @param siglaMateria
     * @param descripcionMateria
     * @throws PersistenceException
     * @pos: si todos los parametros son correctos ,la materia es registrada.
     */
    public void registrarMateria(int idPrograma, int idAsignatura, String siglaRequisito, int tipoRequisito, String nombreMateria, String siglaMateria, String descripcionMateria) throws PersistenceException;
    
    /**
     * objetivo: Cancela una clase de un Curso especifico
     * @param cohorte
     * @param idClase
     * @throws PersistenceException
     * @pos:si todos los parametros son correctos ,se cancela la clase en el curso dado
    **/
    public void cancelarClase(int cohorte, int idClase) throws PersistenceException;

    /**
     * objetivo: Programa una clase en un horario especifico
     * @param fecha
     * @param hora 
     * @throws PersistenceException
     * @pos: si la fecha y la hora son correctas se programa la clase en el horario dado.
     */ 
    public void programarClase(String fecha, String hora) throws PersistenceException;
    //TODO: Poner parametros adicionales dependiendo como se diseñe el bean.
    
    /**
     * objetivo: Se registra un curso dada su asignatura ,materia y profesor correspondiente
     * @param idAsignatura
     * @param siglaMateria
     * @param idProfesor 
     * @throws PersistenceException
     * @pos: si los parametros son correctos,y el profesor tiene el horario adecuado para dictar el curso,se resgistra el curso
     */
    public void registrarCurso(int idAsignatura, String siglaMateria, int idProfesor) throws PersistenceException ;
   
   /**
    * objetivo: Consulta las materia registradas en el sistema
    * @return lista de Materia
    * @throws PersistenceException
    * @pos: List con todas las Materias registradas en la base de datos
    */ 
   public List<Materia> consultarMaterias() throws PersistenceException;
   
   /**
    * objetivo: consulta las materias de una asignatura
    * @return lista con Materias 
    * @throws PersistenceException 
    * @pos: List con las materias de una asignatura dada  una asignatura
    */
   public List<Materia> consultarMaterias(int idAsignatura) throws PersistenceException;
   
   /**
    * objetivo: Consulta los programas de la Unidad de Proyectos
    * @return Lista con los Programas de la unidad de proyectos
    * @throws PersistenceException 
    * @pos: List con los programas registrados en la base de datos
    */
   public List<Programa> consultarProgramas() throws PersistenceException;
   
   /**
    * objetivo: Consulta las asignaturas 
    * @return lista con de las Asignaturas
    * @throws PersistenceException 
    * @pos:List con  las asignaturas registradas en la base de datos
    */
   public List<Asignatura> consultarAsignaturas()throws PersistenceException;
   
   /**
    * objetivo: Consulta los profesores segun el filtro de busqueda
    * @param busqueda
    * @return lista con los Profesores que contienen en su nombre la palabra de la busqueda
    * @throws PersistenceException 
    * @pos: List de tipo Profesor ,donde el nombre de los profesores contiene el String dado en la busqueda
    */
  public List<Profesor> consultarProfesores(String busqueda) throws PersistenceException;
  
  /**
   * objetivo: Consulta las clases programadas para un curso especifico
   * @param cohorte
   * @return lista de Clases dado un curso especifico
   * @throws PersistenceException 
   * @pos: List de tipo Clase con las Clases que corresponden a un curso especifico
   */
  public List<Clase> consultarClases(String cohorte) throws PersistenceException;
  
  /**
   * objetivo: Consulta los recursos disponibles que pueden ser asignados a una clase 
   * @return
   * @throws PersistenceException 
   * @pos: List de tipo Recurso con los Recursos que estan disponibles.
   */
  public List<Recurso> consultarRecursosDisponibles() throws PersistenceException;
  
  /**
   * objetivo: consulta los recursos de una clase dada
   * @param cohorte
   * @return lista con Recursos
   * @throws PersistenceException
   * @pos: List de tipo Recurso que tiene los recursos usados en la clase dada 
   */
  public List<Recurso> consultarRecursosClase(String cohorte) throws PersistenceException;
}
