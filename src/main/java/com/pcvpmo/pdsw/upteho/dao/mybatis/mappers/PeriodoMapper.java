package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Periodo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el Mapper Periodo
 * @author Daniel Ospina
 */
public interface PeriodoMapper {

    public Periodo consultarPeriodo(@Param("idPeriodo") String idPeriodo);

    public List<Periodo> consultarPeriodos();

}
