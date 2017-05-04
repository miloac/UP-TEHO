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
}
