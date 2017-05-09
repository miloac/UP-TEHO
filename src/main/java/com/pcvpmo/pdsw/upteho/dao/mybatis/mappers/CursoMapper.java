package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Curso;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el Mapper Curso
 * @author Daniel Ospina
 */
public interface CursoMapper {
    
    /**
     * Consulta todos los cursos en la Unidad de Proyectos
     * @return una lista con los cursos
     */
    List<Curso> consultarCursos();
    
    /**
     * Consulta un curso especifico dado un cohorte
     * @param id cohorte del curso
     * @return Objeto Curso 
     */
    Curso consultarCurso(@Param("idCur")int id);
    
    /**
     * Consulta todos los cursos de un periodo dado
     * @param nombre nombre del periodo
     * @return Lista de cursos
     */
    List<Curso> consultarCursosPorPeriodo(@Param("nombrePeriodo")String nombre);
    
    /**
     * Consulta el siguiente id disponible de los cursos ya registrados
     * @return entero del id del curso disponible
     */
    int getNextCurso();
    
    /**
     * Registra un curso
     * @param id id del curso
     * @param idProfesor id del profesor
     * @param siglaMateria sigla de la materia
     * @param nombrePeriodo nombre del periodo
     */
    public void registrarCurso(@Param("idCurso")int id,
                               @Param("idProfesor")int idProfesor,
                               @Param("siglaMateria")String siglaMateria,
                               @Param("nombrePeriodo")String nombrePeriodo);
    
   
}
