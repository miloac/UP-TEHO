/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Cohorte;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author andres
 */
public interface CohorteMapper {
    Cohorte consultarCohorte(@Param("idCurso")int idCurso,@Param("idPrograma") int idPrograma);
}
