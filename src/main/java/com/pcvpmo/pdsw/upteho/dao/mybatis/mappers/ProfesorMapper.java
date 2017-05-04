package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Profesor;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el Mapper Profesor
 * @author Andres Felipe Pardo
 */
public interface ProfesorMapper {
     /**
     * consulta los profesores con el nombre dado
     * @param nombre texto con el nombre de los profesores a buscar
     * @return lista de profesores
     */
    List<Profesor> consultarProfesoresxNombre(@Param("nombrePro")String nombre);
}
