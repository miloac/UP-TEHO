/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.HorarioDisponible;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author andres
 */
public interface HorarioDisponibleMapper {
    /**
     * conslulta los horarios disponibles de un profesor especifico
     * @param id
     * @return lista con los horarios disponibles de un profesor dado
     */
    List<HorarioDisponible> consultarHorarioProfesor(@Param("idProfesor")int id);
}
