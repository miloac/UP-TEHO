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
    
    /**
     * consultar una materia por su sigla
     * @param sigla
     * @return Materia
     */
    Materia consultarMateria(@Param("sigla") String sigla);
    
    /**
     * consultar una materia por su sigla
     * @param sigla
     * @return Materia
     */
    Materia consultarMateriaSigla(@Param ("sigla") String sigla);
    
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
    List<Asignatura> getAsigXProg(@Param("programa") int programa);
    
    /**
     * consulta las materias de determinada asignatura
     * @param idAsignatura
     * @return 
     */
    List<Materia> consultarMateriasxAsignatura(@Param("idAsignatura")Integer idAsignatura);

    
    void registrarMateria(@Param("sigla")String sigla,
                                 @Param("nombre")String nombre, 
                                 @Param("creditos")int creditos, 
                                 @Param("descripcion")String descripcion, 
                                 @Param("idAsignatura")int idAsignatura);

    /**
     * consulta todas las materias
     * @return 
     */
    public List<Materia> consultarMaterias();
}

