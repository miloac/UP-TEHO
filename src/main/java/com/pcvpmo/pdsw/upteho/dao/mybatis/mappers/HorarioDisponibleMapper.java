package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.HorarioDisponible;
import java.sql.Time;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author andres
 */
public interface HorarioDisponibleMapper {
    /**
     * conslulta los horarios disponibles de un profesor especifico
     * @param id id del profesor a consultar el horario
     * @return lista con los horarios disponibles de un profesor dado
     */
    List<HorarioDisponible> consultarHorarioProfesor(@Param("idProfesor")int id);
    
    /**
     * inserta el horario disponible de un profesor dado
     * @param id del profesor
     * @param diaDisp dia de disponibilidad
     * @param horaDisp horario disponibilidad
     */
    void insertarHorarioProfesor(@Param("profesorId")int id,@Param("diaDisp")String diaDisp,@Param("horaDisp")Time horaDisp);
}
