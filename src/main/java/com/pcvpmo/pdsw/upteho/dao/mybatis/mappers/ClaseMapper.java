package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Clase;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el mapper Clase
 * @author Andres Felipe Pardo
 */
public interface ClaseMapper {
    List<Clase> consultarClasesxPeriodo(@Param("periodo")String periodo);
    List<Clase> consultarClasesCurso(@Param("curId")int id);
    void agregarClase(@Param("idCurso")int idCurso,@Param("fecha")Date fecha,@Param("hora")Time hora,@Param("tSalon")String tSalon);
    List<Clase> consultarClasesProfesor(@Param("idProf")int idProf);
    void cancelarClase(@Param("idClase") int id);
}