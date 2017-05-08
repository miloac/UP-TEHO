package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Programa;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el Mapper Programa
 * @author Daniel Ospina
 */
public interface ProgramaMapper {
    
    /**
     * Consulta los programas de la Unidad del Proyectos
     * @return Lista de Programas
     */
    public List<Programa> consultarProgramas();
    
    /**
     * consulta un programa por id
     * @param id del programa a ser consultado
     * @return programa obtenido
     */
    public Programa consultarPrograma(@Param("programaId") int id);
}
