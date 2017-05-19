package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Profesor;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el Mapper Profesor
 * @author Andres Felipe Pardo - Daniel Ospina
 */
public interface ProfesorMapper {
    
     /**
     * Consulta los profesores con el nombre dado
     * @param nombre texto con el nombre de los profesores a buscar
     * @return lista de profesores
     */
    List<Profesor> consultarProfesoresxNombre(@Param("nombrePro")String nombre);
    
    /**
     * Registra un profesor segun sus datos
     * @param id id del profesor
     * @param nombre nombre del profesor
     * @param correo correo del profesor
     */
    void registrarProfesor(@Param("id")int id, @Param("nombre")String nombre, @Param("correo")String correo);
}
