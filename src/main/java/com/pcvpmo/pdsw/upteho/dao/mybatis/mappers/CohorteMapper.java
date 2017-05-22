package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Cohorte;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el mapper Cohorte
 * @author Andres Felipe Pardo
 */
public interface CohorteMapper {
    
    /**
     * Consulta un cohorte dado el curso y su programa
     * @param idCurso id del curso
     * @param idPrograma id del programa
     * @return Cohorte
     */
    Cohorte consultarCohorte(@Param("idCurso")int idCurso, @Param("idPrograma") int idPrograma);
    
    /**
     * Registra un nuevo cohorte segun el programa y curso
     * @param idPrograma id del programa
     * @param idCurso id del curso
     * @param cohorte numero de cohorte a registrar
     */
    void registrarCohorte(@Param("idPrograma")int idPrograma, @Param("idCurso")int idCurso, @Param("cohorte")int cohorte);
}
