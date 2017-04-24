/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    Curso consultarCurso(@Param("cohorteCur")int cohorte);
}
