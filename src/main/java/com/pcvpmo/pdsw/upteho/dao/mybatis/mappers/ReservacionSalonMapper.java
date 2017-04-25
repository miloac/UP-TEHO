package com.pcvpmo.pdsw.upteho.dao.mybatis.mappers;

import com.pcvpmo.pdsw.upteho.entities.ReservacionSalon;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Daniel Ospina
 */
public interface ReservacionSalonMapper {
    List<ReservacionSalon> consultarSalonesReservados();
    List<ReservacionSalon> consultarSalonPeriodo(@Param("idPeriodo")String periodo);
}
