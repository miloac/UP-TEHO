package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Curso;
import com.pcvpmo.pdsw.upteho.entities.Profesor;
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
    
   
}
