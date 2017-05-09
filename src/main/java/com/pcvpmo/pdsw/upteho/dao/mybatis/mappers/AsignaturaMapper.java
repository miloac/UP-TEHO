package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import java.util.List;
import org.apache.ibatis.annotations.Param;


/**
 * Interface para el Mapper Asignatura
 * @author Daniel Ospina
 */
public interface AsignaturaMapper {

    List<Asignatura> consultarAsignaturasxPrograma(@Param("idPrograma")Integer idPrograma);
    
    List<Asignatura> consultarAsignaturas();
    
    void registrarAsignatura(@Param("nombreAsig")String nombreAsig,@Param("idProg")int idProg);

    void registrarAsignaturaFull(@Param("idAsignatura")int idAsignatura, @Param("nombreAsig")String nombreAsig, @Param("idProg")int idProg);

}
