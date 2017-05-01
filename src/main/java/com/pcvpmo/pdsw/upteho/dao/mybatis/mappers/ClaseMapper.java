package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Clase;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el mapper Clase
 * @author Andres Felipe Pardo
 */
public interface ClaseMapper {
    List<Clase> consultarClasesxPeriodo(@Param("periodo")String periodo);
}