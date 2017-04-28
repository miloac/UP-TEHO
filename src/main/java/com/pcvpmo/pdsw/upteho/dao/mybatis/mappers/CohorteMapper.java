/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author andres
 */
public interface CohorteMapper {
    int consultarCohorte(@Param("idCurso")int idCurso,@Param("idPrograma") int idPrograma);
}
