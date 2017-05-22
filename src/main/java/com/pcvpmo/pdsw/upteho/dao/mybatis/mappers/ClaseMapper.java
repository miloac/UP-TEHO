package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Clase;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el mapper Clase
 * @author Andres Felipe Pardo
 */
public interface ClaseMapper {
    
    /**
     * Consulta las clases de un periodo especifico
     * @param periodo periodo por el cual filtrar
     * @return Lista de Clases
     */
    List<Clase> consultarClasesxPeriodo(@Param("periodo")String periodo);
    
    /**
     * Consulta las clases de un curso especifico
     * @param id id del curso
     * @return Lista de clases
     */
    List<Clase> consultarClasesCurso(@Param("curId")int id);
    
    /**
     * Agrega una clase a un curso especifico
     * @param idCurso id del curso
     * @param fecha fecha de la clase
     * @param hora hora de la clase
     * @param tSalon tipo de salon
     */
    void agregarClase(@Param("idCurso")int idCurso,@Param("fecha")Date fecha,@Param("hora")Time hora,@Param("tSalon")String tSalon);
    
    /**
     * Consulta las clases programadas de un profesor
     * @param idProf id del profesor
     * @return Lista de Clases
     */
    List<Clase> consultarClasesProfesor(@Param("idProf")int idProf);
    
    /**
     * Cancela una clase
     * @param id id de la clase
     */
    void cancelarClase(@Param("idClase") int id);
}