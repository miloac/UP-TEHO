package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.Periodo;
import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Interface para el Mapper Periodo
 * @author Daniel Ospina
 */
public interface PeriodoMapper {
    
    /**
     * Consulta un periodo dado su id
     * @param idPeriodo id del periodo
     * @return Periodo
     */
    Periodo consultarPeriodo(@Param("idPeriodo") String idPeriodo);
    
    /**
     * Consulta todos los periodos
     * @return Lista de periodos
     */
    List<Periodo> consultarPeriodos();
    
    /**
     * Registra un nuevo periodo
     * @param nombre nombre del periodo
     * @param fechaInicial fecha de inicio del periodo
     * @param fechaFin fecha de finalizacion del periodo
     */
    void registrarPeriodo(@Param("nombre")String nombre, @Param("fechaInicial")Date fechaInicial, @Param("fechaFin")Date fechaFin);

}
