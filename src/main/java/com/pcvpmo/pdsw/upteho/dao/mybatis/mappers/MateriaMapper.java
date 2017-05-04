package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import com.pcvpmo.pdsw.upteho.entities.Materia;
import com.pcvpmo.pdsw.upteho.entities.Programa;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el Mapper Materia
 * @author Daniel Ospina
 * @author Jefferson Castañeda
 */
public interface MateriaMapper {

    
    /*
    * registra una materia en la base de datos
    * @param sigla
    * @param nombre
    * @param creditos
    * @param descripcion
    * @param asignatura a la que pertenece
    */
    void registrarMateria(@Param("sigla") String sigla,
            @Param("nombre") String nombre, 
            @Param("creditos") int creditos, 
            @Param("descripcion")String desc, 
            @Param("asignatura") int idAsig);
    
    /**
     * consultar una materia por su sigla
     * @param sigla
     * @return Materia
     */
    Materia consultarMateria(@Param("sigla") String sigla);
    
    /**
     * consulta los programas para poder asignar alguno a una nueva materia
     * @return programas 
     */
    List<Programa> consultarProgramas();
    
    /**
     * consulta las asignaturas por programa
     * @param programa
     * @return lista de asignaturas
     */
    List<Asignatura> getAsigXProg(@Param("programa")int programa);
    
    List<Materia> consultarMateriasxAsignatura(@Param("idAsignatura")Integer idAsignatura);

}

