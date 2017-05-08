package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Periodo;
import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el Mapper Periodo
 * @author Daniel Ospina
 */
public interface PeriodoMapper {

    Periodo consultarPeriodo(@Param("idPeriodo") String idPeriodo);

    List<Periodo> consultarPeriodos();

    void registrarPeriodo(@Param("nombre")String nombre, @Param("fechaInicial")Date fechaInicial, @Param("fechaFin")Date fechaFin);

}
