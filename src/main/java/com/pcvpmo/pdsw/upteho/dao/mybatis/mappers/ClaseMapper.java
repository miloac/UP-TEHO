package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Clase;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author andres
 */
public interface ClaseMapper {
    List<Clase> consultarClases();
    List<Clase> consultarClaseCurso(@Param("idCohorte")int cohorte);
}
