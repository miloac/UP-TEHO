package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Cohorte;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el mapper Cohorte
 * @author Andres Felipe Pardo
 */
public interface CohorteMapper {
    Cohorte consultarCohorte(@Param("idCurso")int idCurso,@Param("idPrograma") int idPrograma);

    void registrarCohorte(@Param("idPrograma")int idPrograma, @Param("idCurso")int idCurso, @Param("cohorte")int cohorte);
}
