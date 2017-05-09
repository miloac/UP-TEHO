package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Materia;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el Mapper Materia
 * @author Daniel Ospina
 */
public interface MateriaMapper {
    List<Materia> consultarMateriasxAsignatura(@Param("idAsignatura")Integer idAsignatura);

    Materia consultarMateria(@Param("siglaMateria")String siglaMateria);

    void registrarMateria(@Param("sigla")String sigla,
                                 @Param("nombre")String nombre, 
                                 @Param("creditos")int creditos, 
                                 @Param("descripcion")String descripcion, 
                                 @Param("idAsignatura")int idAsignatura);
    
    /**
     * consulta las materias segun el programa
     * @param programa
     * @return 
     */
    List<Materia> consultarMateriasxPrograma(@Param("programa")Integer programa);
}
