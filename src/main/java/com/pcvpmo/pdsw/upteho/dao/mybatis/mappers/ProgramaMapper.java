package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Programa;
import java.util.List;

/**
 * Interface para el Mapper Programa
 * @author Daniel Ospina
 */
public interface ProgramaMapper {
    
    /**
     * Consulta los programas de la Unidad del Proyectos
     * @return Lista de Programas
     */
    List<Programa> consultarProgramas();
}
