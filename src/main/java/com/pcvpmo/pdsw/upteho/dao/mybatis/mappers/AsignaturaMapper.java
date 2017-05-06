package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Asignatura;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Juan Camilo Mantilla
 */
public interface AsignaturaMapper {
    List<Asignatura> consultarAsignaturas();
    void registrarAsignatura(@Param("nombreAsig")String nombreAsig,@Param("idProg")int idProg);
}
