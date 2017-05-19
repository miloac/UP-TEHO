package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import java.util.List;
import org.apache.ibatis.annotations.Param;


/**
 * Interface para el Mapper Asignatura
 * @author Daniel Ospina
 */
public interface AsignaturaMapper {
    
    /**
     * Consulta asignaturas dado un programa especifico
     * @param idPrograma  id del programa por el cual filtrar
     * @return Lista de Asignaturas
     */
    List<Asignatura> consultarAsignaturasxPrograma(@Param("idPrograma")Integer idPrograma);
    
    /**
     * Consulta todas las asignaturas
     * @return Lista de Asignaturas
     */
    List<Asignatura> consultarAsignaturas();
    
    /**
     * Consulta una asignatura dado su ID
     * @param id id de la asignatura
     * @return Asignatura consultada
     */
    Asignatura getAsignaturaPorID(@Param("idAsig") Integer id);
    
    /**
     * Registra una nueva asignatura
     * @param nombreAsig Nombre de la asignatura
     * @param idProg id del programa al que pertenece la asignatura
     */
    void registrarAsignatura(@Param("nombreAsig")String nombreAsig,@Param("idProg")int idProg);
    
    /**
     * Registra una nueva asignatura con datos mas especificos
     * @param idAsignatura id de la asignatura
     * @param nombreAsig nombre de la asignatura
     * @param idProg id del programa al que pertenece la asignatura
     */
    void registrarAsignaturaFull(@Param("idAsignatura")int idAsignatura, @Param("nombreAsig")String nombreAsig, @Param("idProg")int idProg);

}
